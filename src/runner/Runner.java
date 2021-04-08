package runner;

import connection.ConnSQL;
import view.vLogin;
import view.vPrincipal;

public class Runner {

    public static void main(String[] args) {
        new vLogin();
        new vPrincipal();

        ConnSQL con = new ConnSQL();         //Creamos un objeto de tipo conexion
        con.conectado();
    }
}
