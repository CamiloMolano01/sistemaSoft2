package connection;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public class ConnSQL {

    //Ingreso la dirección donde se encuentra almacenada la base de datos actualmente
    private final String url = "jdbc:mysql://localhost/sistema_creditos";

    //Inicializo en null el objeto de conexión
    Connection con = null;
    /* Metodo constructor donde se realiza la conexión con la base de datos donde se
       ingresa el usuario y contraseña como metodo de verificación para acceder a la misma */
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

    //Retorna el estado de la conexión con la base de datos
    public Connection conectado() {  //Este metodo de tipo Connection nos devuelve el estado del objeto
        return con;
    }

    //Permite desconectar la base de datos de la aplicación
    public void desconectar(){ //
        con = null;
        System.out.println("La conexion la BD se ha cerrado");
    }


    /* Acepta como parametro una sentencia sql en formato String y una columna de la tabla en cuestion
       igualmente en formato String, retorna las columnas obtenidas en la consulta de la base de datos */
    public ArrayList<String> getData(String sentence, String column){
        ArrayList<String> datalist = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sentence)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                datalist.add(rs.getString(column));
            }

        } catch (SQLException sqle) { //Si existe algun error este se visualizará en la consola
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return datalist;
    }

}
