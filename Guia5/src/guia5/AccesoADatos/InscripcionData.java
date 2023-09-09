
package guia5.AccesoADatos;

import guia5.Entidades.Inscripcion;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;
    
    public InscripcionData(){
    }

//metodos    
public void guardarInscripcion(Inscripcion insc){
    String sql="INSERT INTO inscripcion (nota,idAlumno,idMateria) VALUES (?,?,?)";
    try{
     PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
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

}

public List obtenerInscripcionesPorAlumno(int id){
return id;
}


//TreeSet de materias
public List obtenerMateriasCursadas(int id){
    return id;
}

public List obtenerMateriasNoCursadas(int id){
return id;
}

public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){

}

public void actualizarNota(int idAlumno, int idMateria, double nota){
    
}

//TreeSet Alumno paso una materia y me devuelve la cantidad de alumnos inscriptos en ella
public List obtenerAlumnosXMateria(){
return alumno;
}
}
