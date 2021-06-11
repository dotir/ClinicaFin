/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Dell
 */
public class atencion {
    private int idAtencion;
    private int idUsuarioClinica;
    private int idUsuarioCliente;
    private Timestamp FechaAtencion;
    private Date FechaProgramada;
    private double subtotal;
    private double igv;
    private double total;

    public atencion( int idUsuarioClinica, int idUsuarioCliente, Timestamp FechaAtencion, Date FechaProgramada, double subtotal, double igv, double total) {
       
        this.idUsuarioClinica = idUsuarioClinica;
        this.idUsuarioCliente = idUsuarioCliente;
        this.FechaAtencion = FechaAtencion;
        this.FechaProgramada = FechaProgramada;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public atencion() {
    }
    
    

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdUsuarioClinica() {
        return idUsuarioClinica;
    }

    public void setIdUsuarioClinica(int idUsuarioClinica) {
        this.idUsuarioClinica = idUsuarioClinica;
    }

    public int getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(int idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public Timestamp getFechaAtencion() {
        return FechaAtencion;
    }

    public void setFechaAtencion(Timestamp FechaAtencion) {
        this.FechaAtencion = FechaAtencion;
    }

    public Date getFechaProgramada() {
        return FechaProgramada;
    }

    public void setFechaProgramada(Date FechaProgramada) {
        this.FechaProgramada = FechaProgramada;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
