package control;

import connection.ConnSQL;
import view.vLogin;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Control {

    ConnSQL con; //Instancia del objeto de conexión con la base de datos

    public Control() {
        con = new ConnSQL(); //Creación de la conexión con la base de datos SQL en mySQL
        new vLogin(this); //
    }

    //Permite conocer si existe o no un usuario con un nombre dado
    private boolean existUser(String user, ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (user.equals(names.get(i))) {
                return true;
            }
        }
        return false;
    }

    /*Con un nombre de usuario y una contraseña se hace el cruce en la base de datos con el fin de encontrar
    coincidencias respecto al nombre de usuario y su respectiva contraseña*/
    public boolean login(String user, String pass) {
        //Escribimos la sentencia SQL y la columna especifica que deseamos obtener
        ArrayList<String> names = con.getData("SELECT * FROM usuario", "Username");
        //Se obtiene la lista de usuarios de la bd

        if (!existUser(user, names)) {
            System.out.println("El usuario no existe");
            return false;
        }

        if (pass.equals(con.getData("SELECT * FROM usuario where Username = " +
                "'" + user + "'", "Password").get(0))) {
            System.out.println("Bienvenido");
            return true;
        }
        System.out.println("Contraseña incorrecta");
        return false;
    }

    /*Similar al anterior con un codigo se hace el cruce en la base de datos con el fin de encontrar
    coincidencias respecto al estudiante identificado con el codigo ingresado y sus creditos disponibles*/
    public String getCredits(String code) {
        ArrayList<String> codes = con.getData("SELECT * FROM estudiante", "Codigo");

        if (!existUser(code, codes)) {
            return "Estudiante no encontrado";
        } else {
            return "Cantidad de creditos: " + con.getData("SELECT * FROM estudiante where Codigo = "
                    + "'" + code + "'", "Cant_Creditos").get(0);
        }
    }

}
