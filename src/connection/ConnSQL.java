package connection;

import java.sql.*;
import java.util.ArrayList;

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

    public void desconectar(){
        con = null;
        System.out.println("La conexion la BD se ha cerrado");
    }

    public ArrayList<String> getData(String sentence, String column){
        ArrayList<String> datalist = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sentence)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                datalist.add(rs.getString(column));
            }

        } catch (SQLException sqle) {
            //System.out.println("Error en la ejecución:"
                    //+ sqle.getErrorCode() + " " + sqle.getMessage());
        }
        System.out.println(sentence);
        System.out.println(datalist);
        return datalist;
    }

}
