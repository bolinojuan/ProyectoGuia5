
package guia5.AccesoADatos;

import guia5.Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;




public class AlumnoData { 

    private Connection con=null;
    
      
    
    public AlumnoData(){
    
    
con = Conexion.getConexion();
  
    }
    
    //metodos
    public void guardarAlumno(Alumno alumno){
<<<<<<< Updated upstream
    String insert = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) "
                              + "Values(?,?,?,?,?) ";
                              
        try {
            
            PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1 , alumno.getDni());       
            ps.setString(2,alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5,alumno.isActivo());
            
            ps.executeUpdate();
           
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                
                 alumno.setDni(rs.getInt(1));
            JOptionPane.showMessageDialog(null,"Alumno agregado exitosamente");
            }
            
         
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion " +ex.getMessage());
        }
=======
        
>>>>>>> Stashed changes
    }

    public Alumno buscarAlumno(int id){
    
        String select = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado =1";
        
        Alumno alumno = null;
        
        try {
            PreparedStatement    ps = con.prepareStatement(select);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
        
            if(rs.next()){
                
                alumno = new Alumno();
                
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecha(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
            }else{
                
             JOptionPane.showMessageDialog(null,"Alumno no encontrado");
             ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexion a BD "+ ex.getMessage());
        }
        
        
        return alumno;
    }

      public Alumno buscarPorDni(int dni){
      
          Alumno alumno = null;
          
          String sql = "SELECT idAlumno, apellido, nombre, fechaNacimiento,estado  FROM alumno WHERE dni = ?";
          
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            
            ResultSet resultado = ps.executeQuery();
            
            if(resultado.next()){
            alumno = new Alumno();
            
            alumno.setIdAlumno(resultado.getInt("idAlumno"));
            alumno.setApellido(resultado.getString("apellido"));
            alumno.setNombre(resultado.getString("nombre"));
            alumno.setFecha(resultado.getDate("fechaNacimiento").toLocalDate());
            alumno.setActivo(true);
            
            
            }else{
            JOptionPane.showMessageDialog(null,"Alumno no encontrado");
             ps.close();
            }
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error en la conexion a BD "+ ex.getMessage());

        }
          
          return alumno;
      }
    
      public List listarAlumno(){
      return //TreeSet;
      }

     public void modificarAlumno(Alumno alumno){
     
         String modificar = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?,fechaNacimiento = ?, estado = ? WHERE idAlumno = ? ";
         
        try {
            PreparedStatement ps = con.prepareStatement(modificar);
      
            ps.setInt(1, alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5,alumno.isActivo());
            ps.setInt(6, alumno.getIdAlumno());
            
            int resultado =ps.executeUpdate();
            
            if(resultado==1){
              JOptionPane.showMessageDialog(null, "Alumno modificado exitosamente");
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la carga hacia la tabla alumno " +ex.getMessage());
        }
     }

     
     public void eliminarAlumno(int id){
     
        String eliminar = "UPDATE  alumno SET estado = 0 WHERE idAlumno = ?";
        
        try {
               PreparedStatement  ps = con.prepareStatement(eliminar);
               ps.setInt(1, id);
               
               int resultado = ps.executeUpdate();
               
               if(resultado ==1){
                JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente");
               }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al conectar con la tabla alumno");
        }
             
 
         }
         
     }

