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
public class Tratamiento {
    private int id_tratamiento;
    private String Nombre_tratamiento;
    private String Tipo_tratamiento;
    private int id_Tipo_tratamiento;
    private int Precio_tratamiento;
    private int Cantidad_Tratamiento;

    public Tratamiento(){
        
    }
    
    public Tratamiento(int id_tratamiento, String Nombre_tratamiento, String Tipo_tratamiento, int Precio_tratamiento) {
        this.id_tratamiento = id_tratamiento;
        this.Nombre_tratamiento = Nombre_tratamiento;
        this.Tipo_tratamiento = Tipo_tratamiento;
        this.Precio_tratamiento = Precio_tratamiento;
    }

    public Tratamiento(int id_tratamiento, String Nombre_tratamiento, String Tipo_tratamiento, int Precio_tratamiento, int Cantidad_Tratamiento) {
        this.id_tratamiento = id_tratamiento;
        this.Nombre_tratamiento = Nombre_tratamiento;
        this.Tipo_tratamiento = Tipo_tratamiento;
        this.Precio_tratamiento = Precio_tratamiento;
        this.Cantidad_Tratamiento = Cantidad_Tratamiento;
    }

    
    
    public int getCantidad_Tratamiento() {
        return Cantidad_Tratamiento;
    }

    public void setCantidad_Tratamiento(int Cantidad_Tratamiento) {
        this.Cantidad_Tratamiento = Cantidad_Tratamiento;
    }

    
    
    
    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getNombre_tratamiento() {
        return Nombre_tratamiento;
    }

    public void setNombre_tratamiento(String Nombre_tratamiento) {
        this.Nombre_tratamiento = Nombre_tratamiento;
    }

    public String getTipo_tratamiento() {
        return Tipo_tratamiento;
    }

    public void setTipo_tratamiento(String Tipo_tratamiento) {
        this.Tipo_tratamiento = Tipo_tratamiento;
    }

    public int getId_Tipo_tratamiento() {
        return id_Tipo_tratamiento;
    }

    public void setId_Tipo_tratamiento(int id_Tipo_tratamiento) {
        this.id_Tipo_tratamiento = id_Tipo_tratamiento;
    }

    public int getPrecio_tratamiento() {
        return Precio_tratamiento;
    }

    public void setPrecio_tratamiento(int Precio_tratamiento) {
        this.Precio_tratamiento = Precio_tratamiento;
    }
 
    
    
}
