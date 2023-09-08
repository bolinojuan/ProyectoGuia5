
package guia5.AccesoADatos;

import guia5.Entidades.Inscripcion;
import java.sql.*;
import java.util.*;


public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;
    
    public InscripcionData(){
    }

//metodos    
public void guardarInscripcion(Inscripcion insc){
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
