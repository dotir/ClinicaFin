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
public class Laboratorio {
    private int idLaboratorio;
    private int idUPaciente;
    private int idUProfesionalClinica;
    private String Fecha;
    private String Estado;
    private double SubTotal;
    private double IGV;
    private double Total;

    public Laboratorio(){}

    public Laboratorio(int idUPaciente, int idUProfesionalClinica, String Fecha, String Estado) {
        this.idUPaciente = idUPaciente;
        this.idUProfesionalClinica = idUProfesionalClinica;
        this.Fecha = Fecha;
        this.Estado = Estado;
    }

    public Laboratorio(int idUPaciente, int idUProfesionalClinica, String Fecha, String Estado, double SubTotal) {
        this.idUPaciente = idUPaciente;
        this.idUProfesionalClinica = idUProfesionalClinica;
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.SubTotal = SubTotal;
    }
    
    
    
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdUPaciente() {
        return idUPaciente;
    }

    public void setIdUPaciente(int idUPaciente) {
        this.idUPaciente = idUPaciente;
    }

    public int getIdUProfesionalClinica() {
        return idUProfesionalClinica;
    }

    public void setIdUProfesionalClinica(int idUProfesionalClinica) {
        this.idUProfesionalClinica = idUProfesionalClinica;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
}
