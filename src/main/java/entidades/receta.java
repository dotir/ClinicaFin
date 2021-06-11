/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Dell
 */
public class receta {
    private int idReceta;
    private int idDetalleAtencion;
    private String Tipo_Receta;
    private String descripcion;
    private String unidades;

    //BUSCAR RECETA

    public receta(int idReceta, int idDetalleAtencion, String Tipo_Receta, String descripcion, String unidades) {
        this.idReceta = idReceta;
        this.idDetalleAtencion = idDetalleAtencion;
        this.Tipo_Receta = Tipo_Receta;
        this.descripcion = descripcion;
        this.unidades = unidades;
    }
       
    
    public receta (){}
    
    //AGREGAR RECETA
    

    public receta(int idDetalleAtencion, String Tipo_Receta, String descripcion, String unidades) {
        this.idDetalleAtencion = idDetalleAtencion;
        this.Tipo_Receta = Tipo_Receta;
        this.descripcion = descripcion;
        this.unidades = unidades;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getIdDetalleAtencion() {
        return idDetalleAtencion;
    }

    public void setIdDetalleAtencion(int idDetalleAtencion) {
        this.idDetalleAtencion = idDetalleAtencion;
    }

    public String getTipo_Receta() {
        return Tipo_Receta;
    }

    public void setTipo_Receta(String Tipo_Receta) {
        this.Tipo_Receta = Tipo_Receta;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

   
}
