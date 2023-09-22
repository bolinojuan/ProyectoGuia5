
package guia5.AccesoADatos;


import guia5.Entidades.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class InscripcionData {

    private Connection con=null;
    private MateriaData matData;
    private AlumnoData aluData;
    private static ArrayList<Inscripcion> inscripcion;
    
    public InscripcionData(){
        con=Conexion.getConexion();
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
        // insc.setIdInscripcion(rs.getInt("idInscripcion"));
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


    public List obtenerInscripcionesPorAlumno(int id) {

        ArrayList<Inscripcion> inscripcionAlumno = new ArrayList<>();

        String sql = "SELECT  idInscripcion,idAlumno,idMateria,nota FROM inscripcion JOIN alumno ON (inscripcion.idAlumno=alumno.idAlumno) WHERE idAlumno = ?";

        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();

                AlumnoData AluDat = new AlumnoData();

                MateriaData MatDat = new MateriaData();

                Alumno a;
                a=AluDat.buscarAlumno(rs.getInt("idAlumno"));
                            
                
                Materia mat;
                mat=MatDat.buscarMateria(rs.getInt("idMateria"));
                
                ins.setAlumno(a);

                ins.setMateria(mat);

                ins.setIdInscripcion(rs.getInt("idInscripcion"));

                ins.setNota(rs.getDouble("nota"));

                inscripcionAlumno.add(ins);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion a Base de Datos");
        }

        return inscripcionAlumno;
    }


//TreeSet de materias
public List obtenerMateriasCursadas(int id){
    ArrayList <Materia> materias=new ArrayList();
    try{
        String sql="SELECT materia.idMateria,materia.nombre,materia.año FROM materia JOIN inscripcion ON (inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno = ? AND estado =1";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        Materia materia;
        while(rs.next()){
            materia=new Materia();
            materia.setIdMateria(rs.getInt("materia.idMateria"));
            materia.setNombre(rs.getString("materia.nombre"));
            materia.setAnioMateria(rs.getInt("materia.año"));
            //materia.setActivo(rs.getBoolean("estado"));
            materias.add(materia);
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones"+ex.getMessage());
    }
    return materias;
}

public List <Materia> obtenerMateriasNoCursadas(int id){
    ArrayList <Materia> materias=new ArrayList();
    
  
        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria NOT IN(SELECT idMateria FROM inscripcion WHERE inscripcion.idAlumno = ?)";

 try{

       
      PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        Materia materia;
        while(rs.next()){
            materia=new Materia();
            materia.setIdMateria(rs.getInt("materia.idMateria"));
            materia.setNombre(rs.getString("materia.nombre"));
            materia.setAnioMateria(rs.getInt("materia.año"));
            //materia.setActivo(rs.getBoolean("estado"));
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
    String sql = "UPDATE materia SET estado =0  WHERE idAlumno = ? AND idMateria = ?";
    PreparedStatement  ps= null;    
    try {
          
             ps = con.prepareStatement(sql);
            ps.setInt(1,idMateria);
            ps.setInt(2, idAlumno);
             int borrado = ps.executeUpdate();
             if(borrado ==1){
                 JOptionPane.showMessageDialog(null,"Inscripcion eliminada");
                   }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion a la Base De Datos");
        
        }
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
    String sql = "SELECT * FROM  materia JOIN inscripcion ON(materia.idMateria=inscripcion.idMateria) JOIN alumno ON(inscripcion.idAlumno=alumno.idAlumno) WHERE idMateria = ?";
    
    ArrayList <Alumno> listado = new ArrayList<>();
    Alumno alum = new Alumno();
        try {
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMateria);
            
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
            alum.setDni(rs.getInt("dni"));
            alum.setNombre(rs.getString("nombre"));
            alum.setApellido(rs.getString("apellido"));
            alum.setFecha((rs.getDate("fechaNacimiento").toLocalDate()));
            alum.setActivo(rs.getBoolean("estado"));
             listado.add(alum);
             }
            ps.close();
           } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error en la conexion a Base De Datos");
        }
    
    
    return listado;
}

}



