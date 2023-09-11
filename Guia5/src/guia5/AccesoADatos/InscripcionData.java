
package guia5.AccesoADatos;

import guia5.Entidades.*;
import java.sql.*;
import java.util.*;
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
