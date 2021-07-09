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
public class TratamientoStock {
    private int id_tratamiento;
    private String Nombre_tratamiento;
    private String Tipo_tratamiento;
    private int id_Tipo_tratamiento;
    private double Precio_tratamiento;
    private int Cantidad_Tratamiento;
    
    private int idProducto;
    private String NombreMedicamento;
    private int Cantidad_ingreso_presentacion;
    private int Cantidad_Presentacion;
    private String TipoPresentacion;
    private int idTipoPresentacion;
    private int Cantidad;
    private double Cantidad_Medida;
    private String UnidadMedidad;
    private int idUnidadMedidad;
    private String Fecha_Ingreso;
    private String Fecha_Caducidad;

    public TratamientoStock(){
        
    }
    
    public TratamientoStock(String Nombre_tratamiento, int idProducto, int Cantidad_ingreso_presentacion, int Cantidad_Presentacion, String TipoPresentacion, int Cantidad, int Cantidad_Medida, String UnidadMedidad, String Fecha_Ingreso, String Fecha_Caducidad) {
        this.Nombre_tratamiento = Nombre_tratamiento;
        this.idProducto = idProducto;
        this.Cantidad_ingreso_presentacion = Cantidad_ingreso_presentacion;
        this.Cantidad_Presentacion = Cantidad_Presentacion;
        this.TipoPresentacion = TipoPresentacion;
        this.Cantidad = Cantidad;
        this.Cantidad_Medida = Cantidad_Medida;
        this.UnidadMedidad = UnidadMedidad;
        this.Fecha_Ingreso = Fecha_Ingreso;
        this.Fecha_Caducidad = Fecha_Caducidad;
    }

    public TratamientoStock(int id_tratamiento, String Nombre_tratamiento, String Tipo_tratamiento, double Precio_tratamiento, int Cantidad_Tratamiento) {
        this.id_tratamiento = id_tratamiento;
        this.Nombre_tratamiento = Nombre_tratamiento;
        this.Tipo_tratamiento = Tipo_tratamiento;
        this.Precio_tratamiento = Precio_tratamiento;
        this.Cantidad_Tratamiento = Cantidad_Tratamiento;
    }

    public TratamientoStock(String Nombre_tratamiento, String Tipo_tratamiento, double Precio_tratamiento) {
        this.Nombre_tratamiento = Nombre_tratamiento;
        this.Tipo_tratamiento = Tipo_tratamiento;
        this.Precio_tratamiento = Precio_tratamiento;
    }

    public TratamientoStock(int id_tratamiento, String Nombre_tratamiento) {
        this.id_tratamiento = id_tratamiento;
        this.Nombre_tratamiento = Nombre_tratamiento;
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

    public double getPrecio_tratamiento() {
        return Precio_tratamiento;
    }

    public void setPrecio_tratamiento(double Precio_tratamiento) {
        this.Precio_tratamiento = Precio_tratamiento;
    }

    public int getCantidad_Tratamiento() {
        return Cantidad_Tratamiento;
    }

    public void setCantidad_Tratamiento(int Cantidad_Tratamiento) {
        this.Cantidad_Tratamiento = Cantidad_Tratamiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreMedicamento() {
        return NombreMedicamento;
    }

    public void setNombreMedicamento(String NombreMedicamento) {
        this.NombreMedicamento = NombreMedicamento;
    }

    public int getCantidad_ingreso_presentacion() {
        return Cantidad_ingreso_presentacion;
    }

    public void setCantidad_ingreso_presentacion(int Cantidad_ingreso_presentacion) {
        this.Cantidad_ingreso_presentacion = Cantidad_ingreso_presentacion;
    }

    public int getCantidad_Presentacion() {
        return Cantidad_Presentacion;
    }

    public void setCantidad_Presentacion(int Cantidad_Presentacion) {
        this.Cantidad_Presentacion = Cantidad_Presentacion;
    }

    public String getTipoPresentacion() {
        return TipoPresentacion;
    }

    public void setTipoPresentacion(String TipoPresentacion) {
        this.TipoPresentacion = TipoPresentacion;
    }

    public int getIdTipoPresentacion() {
        return idTipoPresentacion;
    }

    public void setIdTipoPresentacion(int idTipoPresentacion) {
        this.idTipoPresentacion = idTipoPresentacion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getCantidad_Medida() {
        return Cantidad_Medida;
    }

    public void setCantidad_Medida(double Cantidad_Medida) {
        this.Cantidad_Medida = Cantidad_Medida;
    }

    public String getUnidadMedidad() {
        return UnidadMedidad;
    }

    public void setUnidadMedidad(String UnidadMedidad) {
        this.UnidadMedidad = UnidadMedidad;
    }

    public int getIdUnidadMedidad() {
        return idUnidadMedidad;
    }

    public void setIdUnidadMedidad(int idUnidadMedidad) {
        this.idUnidadMedidad = idUnidadMedidad;
    }

    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(String Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }

    public String getFecha_Caducidad() {
        return Fecha_Caducidad;
    }

    public void setFecha_Caducidad(String Fecha_Caducidad) {
        this.Fecha_Caducidad = Fecha_Caducidad;
    }

}
