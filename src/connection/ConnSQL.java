package connection;

import java.sql.*;

public class ConnSQL {

    private final String url = "jdbc:mysql://localhost/sistema_creditos";
    //PreparedStatement psPrepararSentencia;
    Connection con = null;

    public ConnSQL() {
        try{
            con = DriverManager.getConnection(url,"root","");
            if (con!=null){
                System.out.println("Conexión a base de datos funcionando");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    /**
     *
     * @return
     */
    public Connection conectado(){  //Este metodo de tipo Connection nos devuelve el estado del objeto
        return con;
    }

    public void desconectar(){     //Por seguridad, cuando terminemos sentencias, cerramos la conexion o si la necesitamos cerrar por otro caso
        con = null;                  //Ahora de nuevo con sera null
        System.out.println("La conexion la BD se ha cerrado");
    }


}
