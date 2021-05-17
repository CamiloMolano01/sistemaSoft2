package connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class ConnSQL {

    //Ingreso la dirección donde se encuentra almacenada la base de datos actualmente
    private static final String url = "jdbc:mysql://mysql-cxmxlx.alwaysdata.net/cxmxlx_sistema_creditos";

    //Inicializo en null el objeto de conexión
    Connection con = null;
    /* Metodo constructor donde se realiza la conexión con la base de datos donde se
       ingresa el usuario y contraseña como metodo de verificación para acceder a la misma */
    public ConnSQL() {
        try{
            con = DriverManager.getConnection(url,"cxmxlx","CJRbv3pTHYRCFct");
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
    public List<String> getData(String sentence, String column){
        List<String> datalist = new ArrayList<>();

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

    public String getOneColumn(String sentence){
        String data = "";
        try (PreparedStatement stmt = con.prepareStatement(sentence)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) data = rs.getString(1);
        } catch (SQLException sqle) { //Si existe algun error este se visualizará en la consola
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return data;
    }

    public ArrayList<String> getDataMenu(String sentence){
        ArrayList<String> datalist = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(sentence)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                datalist.add(rs.getString("Tipo"));
                datalist.add(rs.getString("Proteina"));
                datalist.add(rs.getString("Carbohidrato"));
                datalist.add(rs.getString("Verdura/Fruta"));
                datalist.add(rs.getString("Sopa"));
                datalist.add(rs.getString("Jugo"));
                datalist.add(rs.getString("Postre"));
            }
        } catch (SQLException sqle) { //Si existe algun error este se visualizará en la consola prueba final o cambio
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return datalist;
    }



    public ArrayList<String> getData(String sentence){
        ArrayList<String> datalist = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(sentence)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                datalist.add(rs.getString("Codigo"));
                datalist.add(rs.getString("Name"));
                datalist.add(rs.getString("LastName"));
                datalist.add(rs.getString("Cant_Creditos"));
            }
        } catch (SQLException sqle) { //Si existe algun error este se visualizará en la consola
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return datalist;
    }

    public void setData(String sentence) {
        try (PreparedStatement stmt = con.prepareStatement(sentence)) {
            stmt.executeUpdate();
        } catch (SQLException sqle) { //Si existe algun error este se visualizará en la consola
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }
}
