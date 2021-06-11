/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Dell
 */
public class detalleatencion {
    private int idDetalleAtencion;
    private String detalle;
    private String FechaProgramacion;
    private String Estado;
    private double precio;
    private int cantidad;
    private int idAtencion;
    private int idEspecialidad;
    private int idTipoAtencion;
    private int idLocal;

    public int getIdDetalleAtencion() {
        return idDetalleAtencion;
    }

    public void setIdDetalleAtencion(int idDetalleAtencion) {
        this.idDetalleAtencion = idDetalleAtencion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFechaProgramacion() {
        return FechaProgramacion;
    }

    public void setFechaProgramacion(String FechaProgramacion) {
        this.FechaProgramacion = FechaProgramacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }
    
    
}
