
package guia5.AccesoADatos;

import guia5.Entidades.Alumno;
import java.sql.*;
import java.util.*;

public class AlumnoData {

    private Connection con;
    
    
    
    public AlumnoData(){
    }
    
    
    //metodos
    public void guardarAlumno(Alumno alumno){
    
    }

    public Alumno buscarAlumno(int id){
    return id;
    }

      public Alumno buscarPorDni(int dni){
      return dni ;
      }
    
      public List listarAlumno(){
      return //TreeSet;
      }

     public void modificarAlumno(Alumno alumno){
     
     }

     
     public void eliminarAlumno(int id){
     
     }
}
