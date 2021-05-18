package control;

import connection.ConnSQL;
import view.VLogin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("ALL")
public class Control {

    ConnSQL con; //Instancia del objeto de conexión con la base de datos
    Calendar calendar;

    public Control() {
        con = new ConnSQL(); //Creación de la conexión con la base de datos SQL en mySQL
        new VLogin(this); //
        calendar = Calendar.getInstance();
    }

    //Permite conocer si existe o no un usuario con un nombre dado
    private boolean existUser(String user, List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (user.equals(names.get(i))) {
                return true;
            }
        }
        return false;
    }

    /*Con un nombre de usuario y una contraseña se hace el cruce en la base de datos con el fin de encontrar
    coincidencias respecto al nombre de usuario y su respectiva contraseña*/
    public int login(String user, String pass) {
        //Escribimos la sentencia SQL y la columna especifica que deseamos obtener
        //List<String> names = con.getData("SELECT * FROM usuario", "Username");
        //Se obtiene la lista de usuarios de la bd

        /*if (!existUser(user, names)) {
            System.out.println("El usuario no existe");
            return false;
        }*/
        ArrayList<String> datos = getUser(user);
        if (!datos.isEmpty() && pass.equals(datos.get(2))) {
            return Integer.parseInt(datos.get(5));
        }
        //System.out.println("Contraseña incorrecta");
        return -1;
    }

    public ArrayList<String> getUser(String user){
        return con.getDataUsers("SELECT * FROM usuario where Username =" + "'" + user + "'");
    }

    /*Similar al anterior con un codigo se hace el cruce en la base de datos con el fin de encontrar
    coincidencias respecto al estudiante identificado con el codigo ingresado y sus creditos disponibles*/
    public String getCredits(String code) {
        List<String> codes = con.getData("SELECT * FROM estudiante", "Codigo");

        if (!existUser(code, codes)) {
            return "Estudiante no encontrado";
        } else {
            return "Cantidad de creditos: " + con.getData("SELECT * FROM estudiante where Codigo = '"
                    + code + "'", "Cant_Creditos").get(0);
        }
    }

    public String getBuyCredEst(String code) {
        return con.getOneColumn("SELECT sum(Cantidad) FROM registro where Tipo=2" +
                " and Estudiante_ID=(SELECT Estudiante_ID from estudiante where Codigo='" + code + "')");
    }

    public String getConsumeCredEst(String code) {
        String one = con.getOneColumn("SELECT Estudiante_ID from estudiante where Codigo='" + code + "'");
        return con.getOneColumn("SELECT sum(Cantidad) FROM registro where Tipo=1" +
                " and Estudiante_ID='" + one + "'");
    }

    public List<String> getData(String code) {
        return con.getData("SELECT * FROM estudiante where Codigo='" + code + "'");
    }

    public boolean addCredits(String code, String quantity) {
        if (code.isEmpty() || quantity.isEmpty()) {
            return false;
        } else {
            int c = Integer.parseInt(con.getData("SELECT * FROM estudiante where Codigo='" + code + "' ",
                    "Cant_Creditos").get(0)) + Integer.parseInt(quantity);
            con.setData("UPDATE estudiante set Cant_Creditos='" + c + "' where Codigo='" + code + "'");
            return true;
        }
    }

    public List<String> chargeMenu(String date) {
        return con.getDataMenu("SELECT * FROM menu where Fecha='" + date + "'");
    }

    public void createRegister(String tipo, String cantidad, String usuario, String estudiante){
        con.addRegister("INSERT INTO registro (Fecha, Hora, Tipo, Cantidad, Usuario_ID, Estudiante_ID)" +
                " values (?,?," + tipo + "," + cantidad + "," + usuario + "," + getData(estudiante).get(0) + ")");
    }

    public String[][] getUsers(){
        ArrayList<String> datos = con.getDataUsers2("SELECT * FROM usuario");
        String[][] info = new String[datos.size()/5][5];
        int cont = 0;
        for (int i = 0; i < datos.size()/5; i++) {
            for (int j = 0; j < 5; j++) {
                info[i][j] = datos.get(cont);
                cont++;
            }
        }
        return info;
    }


}
