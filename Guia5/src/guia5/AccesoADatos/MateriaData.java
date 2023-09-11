
package guia5.AccesoADatos;

import guia5.Entidades.Materia;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con;

public MateriaData(){
}

//metodos
public void guardarMateria(Materia materia){
    String sql="INSERT INTO materia (nombre,anioMateria,activo) VALUES (?,?,?)";
    PreparedStatement ps;
    try{
     ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     ps.setString(1,materia.getNombre());
     ps.setInt(2,materia.getAnioMateria());
     ps.setBoolean(3, materia.isActivo());
     ResultSet rs=ps.getGeneratedKeys();
     if(rs.next()){
         materia.setIdMateria(rs.getInt("idMateria"));
         JOptionPane.showMessageDialog(null, "Materia añadida con éxito");
     }
     ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a tabla Materia"+ex.getMessage());
    }
    
    
}

public Materia buscarMateria(int id){
    Materia materia=null;
    String sql="SELECT nombre,anioMateria,estado FROM materia WHERE idMateria=? AND estado=1";
    PreparedStatement ps;
    try{
        ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            materia=new Materia();
            materia.setIdMateria(id);
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("anioMateria"));
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
    String sql="UPDATE materia SET nombre=?,anioMatteria=?,estado=? WHERE idMateria=?";
    PreparedStatement ps;
    try{
        ps=con.prepareStatement(sql);
        ps.setString(1, materia.getNombre());
        ps.setInt(2, materia.getAnioMateria());
        ps.setBoolean(3, materia.isActivo());
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
        String sql="UPDATE materia SET estado=0 WHERE idMateria=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        int fila=ps.executeUpdate(sql);
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
    PreparedStatement ps;
    try{
        String sql="SELECT * FROM materia WHERE estado=1";
       ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Materia materia=new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("anioMateria"));
            materia.setActivo(rs.getBoolean("estado"));
            materias.add(materia);
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
    }
    return materias;
}

}
