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
public class Venta {
    private int idVenta;
    private int idUPaciente;
    private int idUProfecionalClinica;
    private int idLocal;
    private String Fecha;
    private double SubTotal;
    private double IGV;
    private double Total;

    public Venta(){}

    public Venta(int idUPaciente, int idUProfecionalClinica, String Fecha) {
        this.idUPaciente = idUPaciente;
        this.idUProfecionalClinica = idUProfecionalClinica;
        this.Fecha = Fecha;
    }
    
    
    
    public Venta(int idVenta, int idUPaciente, int idUProfecionalClinica, int idLocal, String Fecha, double SubTotal, double IGV, double Total) {
        this.idVenta = idVenta;
        this.idUPaciente = idUPaciente;
        this.idUProfecionalClinica = idUProfecionalClinica;
        this.idLocal = idLocal;
        this.Fecha = Fecha;
        this.SubTotal = SubTotal;
        this.IGV = IGV;
        this.Total = Total;
    }

    
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdUPaciente() {
        return idUPaciente;
    }

    public void setIdUPaciente(int idUPaciente) {
        this.idUPaciente = idUPaciente;
    }

    public int getIdUProfecionalClinica() {
        return idUProfecionalClinica;
    }

    public void setIdUProfecionalClinica(int idUProfecionalClinica) {
        this.idUProfecionalClinica = idUProfecionalClinica;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
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
