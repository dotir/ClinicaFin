/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;





/**
 *
 * @author Dell
 */
public class DetalleReceta {
   private int idDetalleReceta; 
   private int idReceta;  
   private String Descripcion; 
   private int Cantidad; 
   private String Observacion;
   private String Estado; 

   
   public DetalleReceta(){}

    public DetalleReceta(String Descripcion, int Cantidad, String Observacion, String Estado) {
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Observacion = Observacion;
        this.Estado = Estado;
    }
   
   
   
    public DetalleReceta(int idDetalleReceta, int idReceta, String Descripcion, int Cantidad, String Observacion, String Estado) {
        this.idDetalleReceta = idDetalleReceta;
        this.idReceta = idReceta;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Observacion = Observacion;
        this.Estado = Estado;
    }   
   
    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(int idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }


   
}
