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
public class HistorialClinico {
    private int idHistorial;
    private int idUPaciente;
    private int idTriaje;
    private String Fecha;

    
    
    private HistorialClinico(){}
    
    public HistorialClinico(int idHistorial, int idURecepcionista, int idUPaciente, int idTriaje, String Fecha) {
        this.idHistorial = idHistorial;
        this.idUPaciente = idUPaciente;
        this.idTriaje = idTriaje;
        this.Fecha = Fecha;
    }

    public HistorialClinico( int idUPaciente, String Fecha) {
        this.idUPaciente = idUPaciente;
        this.Fecha = Fecha;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdUPaciente() {
        return idUPaciente;
    }

    public void setIdUPaciente(int idUPaciente) {
        this.idUPaciente = idUPaciente;
    }

    public int getIdTriaje() {
        return idTriaje;
    }

    public void setIdTriaje(int idTriaje) {
        this.idTriaje = idTriaje;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    

    
    
    
    
}
