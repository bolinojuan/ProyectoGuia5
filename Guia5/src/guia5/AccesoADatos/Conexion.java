
package guia5.AccesoADatos;
import java.sql.*;
import javax.swing.*;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String DB = "universidadEjemplo";
    private static final String PASSWORD = "";
    private static Connection con;
    
    private Conexion(){
    
    }
    
    public  static Connection getConexion(){

    if(con == null){
    
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
            con= DriverManager.getConnection(URL+DB+" ?useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+ USER + "&password="+PASSWORD);
            
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Error al cargar el driver  "+ ex.getMessage());
      
        }catch(SQLException ex){
     
            JOptionPane.showMessageDialog(null,"Error de conexion a la BD " +ex.getMessage());
        }
    }
    return con;
    }

    

}
