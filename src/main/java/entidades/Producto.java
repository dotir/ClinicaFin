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
public class Producto {
    private int idProducto;
    private int idMedicamento;
    private String Medicamento;
    private int CantidadIngreso;
    private int CantidadPresentacion;
    private int idTIpoPresentacion;
    private String TipoPresentacion;
    private int Cantidad;
    private double PrecioUnidad;
    private double CantidadMedida;
    private int idUnidadMedida;
    private String UnidadMedida;
    private String FechaIngreso;
    private String FechaCaducidad;

    public Producto(int idMedicamento, int CantidadIngreso, int CantidadPresentacion, int idTIpoPresentacion, double PrecioUnidad, double CantidadMedida, int idUnidadMedida, String FechaCaducidad) {
        this.idMedicamento = idMedicamento;
        this.CantidadIngreso = CantidadIngreso;
        this.CantidadPresentacion = CantidadPresentacion;
        this.idTIpoPresentacion = idTIpoPresentacion;
        this.PrecioUnidad = PrecioUnidad;
        this.CantidadMedida = CantidadMedida;
        this.idUnidadMedida = idUnidadMedida;
        this.FechaCaducidad = FechaCaducidad;
    }

    
    
    
    public Producto(int idProducto, int idMedicamento, int CantidadIngreso, int CantidadPresentacion, String TipoPresentacion, int Cantidad, double PrecioUnidad, double CantidadMedida, String UnidadMedida, String FechaIngreso, String FechaCaducidad) {
        this.idProducto = idProducto;
        this.idMedicamento = idMedicamento;
        this.CantidadIngreso = CantidadIngreso;
        this.CantidadPresentacion = CantidadPresentacion;
        this.TipoPresentacion = TipoPresentacion;
        this.Cantidad = Cantidad;
        this.PrecioUnidad = PrecioUnidad;
        this.CantidadMedida = CantidadMedida;
        this.UnidadMedida = UnidadMedida;
        this.FechaIngreso = FechaIngreso;
        this.FechaCaducidad = FechaCaducidad;
    }

    public Producto(int idProducto, String Medicamento, int CantidadIngreso, int CantidadPresentacion, String TipoPresentacion, int Cantidad, double PrecioUnidad, double CantidadMedida, String UnidadMedida, String FechaIngreso, String FechaCaducidad) {
        this.idProducto = idProducto;
        this.Medicamento = Medicamento;
        this.CantidadIngreso = CantidadIngreso;
        this.CantidadPresentacion = CantidadPresentacion;
        this.TipoPresentacion = TipoPresentacion;
        this.Cantidad = Cantidad;
        this.PrecioUnidad = PrecioUnidad;
        this.CantidadMedida = CantidadMedida;
        this.UnidadMedida = UnidadMedida;
        this.FechaIngreso = FechaIngreso;
        this.FechaCaducidad = FechaCaducidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getMedicamento() {
        return Medicamento;
    }

    public void setMedicamento(String Medicamento) {
        this.Medicamento = Medicamento;
    }

    public int getCantidadIngreso() {
        return CantidadIngreso;
    }

    public void setCantidadIngreso(int CantidadIngreso) {
        this.CantidadIngreso = CantidadIngreso;
    }

    public int getCantidadPresentacion() {
        return CantidadPresentacion;
    }

    public void setCantidadPresentacion(int CantidadPresentacion) {
        this.CantidadPresentacion = CantidadPresentacion;
    }

    public int getIdTIpoPresentacion() {
        return idTIpoPresentacion;
    }

    public void setIdTIpoPresentacion(int idTIpoPresentacion) {
        this.idTIpoPresentacion = idTIpoPresentacion;
    }

    public String getTipoPresentacion() {
        return TipoPresentacion;
    }

    public void setTipoPresentacion(String TipoPresentacion) {
        this.TipoPresentacion = TipoPresentacion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnidad() {
        return PrecioUnidad;
    }

    public void setPrecioUnidad(double PrecioUnidad) {
        this.PrecioUnidad = PrecioUnidad;
    }

    public double getCantidadMedida() {
        return CantidadMedida;
    }

    public void setCantidadMedida(double CantidadMedida) {
        this.CantidadMedida = CantidadMedida;
    }

    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getFechaCaducidad() {
        return FechaCaducidad;
    }

    public void setFechaCaducidad(String FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }

    
}
