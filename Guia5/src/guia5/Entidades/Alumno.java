
package guia5.Entidades;

import java.time.LocalDate;


public class Alumno {

    public int idAlumno;
    private String apellido;
    private String nombre;
    private LocalDate fecha;
    private boolean activo;
    
    public Alumno(){
    }

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fecha, boolean activo) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha = fecha;
        this.activo = activo;
    }

    public Alumno(String apellido, String nombre, LocalDate fecha, boolean activo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha = fecha;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

}

