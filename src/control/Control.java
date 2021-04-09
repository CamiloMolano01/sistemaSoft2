package control;

import connection.ConnSQL;
import view.vLogin;
import view.vPrincipal;

import java.util.ArrayList;

public class Control {

    ConnSQL con;

    public Control() {
        con = new ConnSQL(); //Creación de la conexión con la base de datos SQL en oracle
        //con.conectado();
        new vLogin(this);
        //new vPrincipal();
    }

    private boolean existUser(String user, ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (user.equals(names.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String user, String pass) {
        ArrayList<String> names = con.getData("SELECT * FROM usuario", "Username");
        //Se recibe la lista de usuarios de la bd

        if (!existUser(user, names)) {
            System.out.println("??");
            return false;
        }

        if (pass.equals(con.getData("SELECT * FROM usuario where Username = " + "'" + user + "'", "Password").get(0))) {
            System.out.println("Bienvenido");
            return true;
        }
        System.out.println("Contraseña incorrecta");
        return false;
    }

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
