/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author ALESSO
 */
public class DetalleHistorial {
    private int idDetalleHistorial;
    private int idHistorial;
    private int Especialidad;
    private String Diagnostico;
    private int Examen;
    private int Receta;
    private String Fecha;

    public DetalleHistorial(){}

    public DetalleHistorial(int Especialidad, String Diagnostico, String Fecha) {
        this.Especialidad = Especialidad;
        this.Diagnostico = Diagnostico;
        this.Fecha = Fecha;
    }
    
    public DetalleHistorial(int idHistorial, int Especialidad, String Diagnostico, int Examen, int Receta, String Fecha) {
        this.idHistorial = idHistorial;
        this.Especialidad = Especialidad;
        this.Diagnostico = Diagnostico;
        this.Examen = Examen;
        this.Receta = Receta;
        this.Fecha = Fecha;
    }

    public DetalleHistorial(int idDetalleHistorial, int idHistorial, int Especialidad, String Diagnostico, int Examen, int Receta, String Fecha) {
        this.idDetalleHistorial = idDetalleHistorial;
        this.idHistorial = idHistorial;
        this.Especialidad = Especialidad;
        this.Diagnostico = Diagnostico;
        this.Examen = Examen;
        this.Receta = Receta;
        this.Fecha = Fecha;
    }

    
    
    public int getIdDetalleHistorial() {
        return idDetalleHistorial;
    }

    public void setIdDetalleHistorial(int idDetalleHistorial) {
        this.idDetalleHistorial = idDetalleHistorial;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(int Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public int getExamen() {
        return Examen;
    }

    public void setExamen(int Examen) {
        this.Examen = Examen;
    }

    public int getReceta() {
        return Receta;
    }

    public void setReceta(int Receta) {
        this.Receta = Receta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
