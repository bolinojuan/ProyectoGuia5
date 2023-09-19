
package guia5.AccesoADatos;
import guia5.Entidades.Materia;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con=null;

public MateriaData(){
    con=Conexion.getConexion();
}

//metodos
public void guardarMateria(Materia materia){
    String sql="INSERT INTO materia (nombre,año,estado) VALUES (?,?,?)";
    try{
     PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     
     ps.setString(1,materia.getNombre());
     ps.setInt(2,materia.getAnioMateria());
     ps.setBoolean(3, materia.isActivo());
     ps.executeUpdate();
     ResultSet rs=ps.getGeneratedKeys();
     if(rs.next()){
        // materia.setIdMateria(rs.getInt("idMateria")); -->  ej: condicion que se utiliza para comparar el id de un alumno con el que se pasa por parametro
         
        JOptionPane.showMessageDialog(null, "Materia añadida con éxito");
        
     }else{
         JOptionPane.showMessageDialog(null, "La materia ya existe");
     }
     ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a tabla Materia"+ex.getMessage());
            }
    
    
}

public Materia buscarMateria(int id){
    Materia materia=null;
    String sql="SELECT nombre,año,estado FROM materia WHERE idMateria=? AND estado=1";
    try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            materia=new Materia();
            materia.setIdMateria(id);
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("año"));
            materia.setActivo(rs.getBoolean("estado"));
        }else{
            JOptionPane.showMessageDialog(null, "La materia no existe");
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
    }
    return materia;
}

public void modificarMateria(Materia materia){
    String sql="UPDATE materia SET nombre=?,año=?, estado = ? WHERE idMateria=?";
     
    try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, materia.getNombre());
        ps.setInt(2, materia.getAnioMateria());
        ps.setBoolean(3, materia.isActivo());
        ps.setInt(4, materia.getIdMateria());
        int exito=ps.executeUpdate();
        if(exito==1){
            JOptionPane.showMessageDialog(null, "Materia modificada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "La materia no existe");
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
    }
}


public void eliminarMateria(int id){
    
    try{
        String sql="UPDATE materia SET estado=0 WHERE idMateria=? AND estado=1";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        int fila=ps.executeUpdate();
        if(fila==1){
            JOptionPane.showMessageDialog(null, "Se eliminó la materia");
        }else{
            JOptionPane.showMessageDialog(null, "La materia no existe");
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
    }
}

public List <Materia> listarMaterias(){
    ArrayList <Materia> materias=new ArrayList();
    
    try{
        String sql="SELECT * FROM materia WHERE estado=1";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Materia materia=new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("año"));
            materia.setActivo(rs.getBoolean("estado"));
            materias.add(materia);
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
    }
    return materias;
}


//public void setearMateriasActivas(){
//String sql = "UPDATE materia SET estado = 1";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.executeUpdate();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//
//}
}
