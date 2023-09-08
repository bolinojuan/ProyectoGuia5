
package persistencia;
import java.sql.*;
import javax.swing.*;

public class MiConexion {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String DB = "universidadEjemplo";
    private static final String PASSWORD = "";
    private static Connection conexion;
    
    public Connection getConexion(){

    if(conexion == null){
    
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
            conexion = DriverManager.getConnection(URL+DB+" ?useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+ USER + "&password="+PASSWORD);
            
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Error al cargar el driver  "+ ex.getMessage());
      
        }catch(SQLException ex){
     
            JOptionPane.showMessageDialog(null,"Error de conexion a la BD " +ex.getMessage());
        }
    }
    return conexion;
    }

    

}
