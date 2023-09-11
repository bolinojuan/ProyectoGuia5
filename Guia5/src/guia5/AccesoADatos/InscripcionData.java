
package guia5.AccesoADatos;


import guia5.Entidades.*;

import guia5.Entidades.Inscripcion;
import guia5.Entidades.Materia;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;
    private static ArrayList<Inscripcion> inscripcion;
    
    public InscripcionData(){
    inscripcion = new ArrayList<>();
    }

//metodos    
public void guardarInscripcion(Inscripcion insc){
    String sql="INSERT INTO inscripcion (nota,idAlumno,idMateria) VALUES (?,?,?)";
    PreparedStatement ps;
    try{
     ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     ps.setDouble(1,insc.getNota());
     ps.setInt(2,insc.getAlumno().getIdAlumno());
     ps.setInt(3, insc.getMateria().getIdMateria());
     ResultSet rs=ps.getGeneratedKeys();
     if(rs.next()){
         insc.setIdInscripcion(rs.getInt("idInscripcion"));
         JOptionPane.showMessageDialog(null, "Inscripción realizada con éxito");
     }
     ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a tabla Inscripción"+ex.getMessage());
    }
}

public List obtenerInscripciones(){
String sql = "SELECT * FROM inscripcion";
PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            JOptionPane.showMessageDialog(null," Lista obtenida exitosamente" );
            }
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error en la conexion a Base de Datos "+ex.getMessage());
        }

    return inscripcion;
}


public List obtenerInscripcionesPorAlumno(int id){
    return inscripcion;
}


//TreeSet de materias
public List obtenerMateriasCursadas(int id){
    ArrayList <Materia> materias=new ArrayList();
    try{
        String sql="SELECT inscripcion.idMateria,nombre,año FROM inscripcion JOIN materia ON (inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        Materia materia;
        while(rs.next()){
            materia=new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("anioMateria"));
            materia.setActivo(rs.getBoolean("estado"));
            materias.add(materia);
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones"+ex.getMessage());
    }
    return materias;
}

public List obtenerMateriasNoCursadas(int id){
    ArrayList <Materia> materias=new ArrayList();
    try{
        String sql="SELECT inscripcion.idMateria,nombre,año FROM inscripcion JOIN materia ON (inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno NOT ?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        Materia materia;
        while(rs.next()){
            materia=new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("anioMateria"));
            materia.setActivo(rs.getBoolean("estado"));
            materias.add(materia);
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones"+ex.getMessage());
    }
    return materias;
}

public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
    
    //probar restriccion de integridad referencial   
    String sql = "DELETE FROM inscripcion JOIN alumno ON(inscripcion.idAlumno = alumno.idAlumno) JOIN materia ON(inscripcion.idMateria = materia.idMmateria) WHERE idAlumno = ? AND idMateria = ?";
    PreparedStatement  ps= null;    
    try {
          
             ps = con.prepareStatement(sql);
            ps.setInt(idMateria, idAlumno);
             int borrado = ps.executeUpdate();
             if(borrado ==1){
                 JOptionPane.showMessageDialog(null,"Inscripcion eliminada");
                   }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion a la Base De Datos");
        }
        
                
        
public void actualizarNota(int idAlumno, int idMateria, double nota){
    String sql="UPDATE inscripcion SET nota=? WHERE idMateria=? AND idAlumno=?";
    PreparedStatement ps=null;
    try{
        ps=con.prepareStatement(sql);
        ps.setDouble(1, nota);
        ps.setInt(2, idMateria);
        ps.setInt(3, idAlumno);
        int exito=ps.executeUpdate();
        if(exito==1){
            JOptionPane.showMessageDialog(null, "Inscripción modificada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "La inscripción no existe");
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
    }
}

public List obtenerAlumnosXMateria(int idMateria){
    return inscripcion;
}

}
//public List obtenerInscripcionesPorAlumno(int id){
//return inscripcion;
//}
//
//
////TreeSet de materias
//public List obtenerMateriasCursadas(int id){
//    return lista;
//}
//
//public List obtenerMateriasNoCursadas(int id){
//return lista;
//}
//
//public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
//
//}
//
//public void actualizarNota(int idAlumno, int idMateria, double nota){
//    
//}
//
//public List obtenerAlumnosXMateria(int idMateria){
//return lista;
//}
//}
