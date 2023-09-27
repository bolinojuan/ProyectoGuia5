
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
         ps.executeUpdate();
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

    public ArrayList obtenerInscripciones(){
        ArrayList<Inscripcion> inscripcion=new ArrayList();
        String sql = "SELECT * FROM inscripcion";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            Inscripcion insc;  
            while(rs.next()){
                insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
                insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
                insc.setNota(rs.getDouble("nota"));
                inscripcion.add(insc);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexion a Base de Datos "+ex.getMessage());
        }

        return inscripcion;
    }


    public ArrayList obtenerInscripcionesPorAlumno(int id) {
        
        
        ArrayList<Inscripcion> inscripcionAlumno = new ArrayList<>();

        String sql = "SELECT  idInscripcion,inscripcion.idAlumno,idMateria,nota FROM inscripcion JOIN alumno ON (inscripcion.idAlumno=alumno.idAlumno) WHERE alumno.idAlumno = ? AND estado =1";

        

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            AlumnoData alumnodata = new AlumnoData();
            
            Alumno alumno = alumnodata.buscarAlumno(id);
            
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();

           

                MateriaData MatDat = new MateriaData();

                //Alumno a;
               // a=AluDat.buscarAlumno(rs.getInt("inscripcion.idAlumno"));
                            
                
                Materia mat;
                mat=MatDat.buscarMateria(rs.getInt("idMateria"));
                
                ins.setAlumno(alumno);

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
    public ArrayList obtenerMateriasCursadas(int id){
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

    public ArrayList obtenerMateriasNoCursadas(int id){
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


        String sql = "DELETE FROM inscripcion WHERE inscripcion.idAlumno=? AND inscripcion.idMateria=?";  

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ps.setInt(2,idMateria);
            int borrado = ps.executeUpdate();
            if(borrado ==1){
                JOptionPane.showMessageDialog(null,"Inscripcion eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion a la Base De Datos"+ex.getMessage());
        }
    }       
        
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql="UPDATE inscripcion SET inscripcion.nota=? WHERE inscripcion.idMateria=? AND inscripcion.idAlumno=?";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idMateria);
            ps.setInt(3, idAlumno);
            int exito=ps.executeUpdate();
            
            System.out.println(exito);
//            if(exito==1){
//                JOptionPane.showMessageDialog(null, "Inscripción modificada exitosamente");
//            
//             }else{
//           JOptionPane.showMessageDialog(null, "No se ha modificado la nota");
//}
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage());
        }
    }

    public ArrayList obtenerAlumnosXMateria(int idMateria){
        String sql="SELECT * FROM  alumno WHERE estado=1 AND idAlumno IN(SELECT idInscripcion FROM inscripcion JOIN materia ON(inscripcion.idMateria=materia.idMateria) WHERE materia.idMateria = ?)";
        //String sql ="SELECT * FROM  alumno JOIN inscripcion ON(alumno.idAlumno=inscripcion.idAlumno) WHERE inscripcion.idMateria = ? AND alumno.estado=1";

        ArrayList <Alumno> listado = new ArrayList<>();
        Alumno alum ;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMateria);

            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                alum=new Alumno();
                alum.setIdAlumno(rs.getInt("idAlumno"));
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



