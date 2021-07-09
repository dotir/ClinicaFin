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
public class DetalleVenta {

    private int idVenta;
    private int idDetalleVenta;
    private int Producto;
    private String NombreProducto;
    private int Cantidad;
    private double Precio;

    public DetalleVenta(){}
    
    public DetalleVenta(int idVenta, int idDetalleVenta, int Producto, int Cantidad, double Precio) {
        this.idVenta = idVenta;
        this.idDetalleVenta = idDetalleVenta;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    public DetalleVenta(int Producto, String NombreProducto, double Precio) {
        this.Producto = Producto;
        this.NombreProducto = NombreProducto;
        this.Precio = Precio;
    }

    public DetalleVenta(int Producto, int Cantidad) {
        this.Producto = Producto;
        this.Cantidad = Cantidad;
    }

    
    
    public DetalleVenta(int idVenta, int idDetalleVenta, String NombreProducto, int Cantidad, double Precio) {
        this.idVenta = idVenta;
        this.idDetalleVenta = idDetalleVenta;
        this.NombreProducto = NombreProducto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

}
