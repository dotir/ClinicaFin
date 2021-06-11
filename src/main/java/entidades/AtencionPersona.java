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
public class AtencionPersona{
    private int idAtencion;
    private int IdUsuarioCliente;
    private int IdDetalleAtencion;
    private String Nombre_Paciente;
    private String Apellido_Paciente;
    private String Apellido_Medico;
    private Date FechaAtencion;
    private Date FechaProgramada;
    private double subtotal;
    private double igv;
    private double total;
    private String TipoAtencion;
    private String NombreLocal;
    private String Detalle;
    private String HoraInicio;
    private String HoraFin;
    private String Estado;
    
    private String Tipo_Receta;
    private String Descripcion;
    private String Unidades;

    //PARA EL DETALLE DE ATENCION
    public AtencionPersona(int idAtencion, int IdUsuarioCliente, String Detalle, String HoraInicio, String HoraFin, String Estado) {
        this.idAtencion = idAtencion;
        this.IdUsuarioCliente = IdUsuarioCliente;
        this.Detalle = Detalle;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.Estado = Estado;
    }
    
    //PARA LA RECETA

    public AtencionPersona(int idAtencion, String Tipo_Receta, String Descripcion, String Unidades) {
        this.idAtencion = idAtencion;
        this.Tipo_Receta = Tipo_Receta;
        this.Descripcion = Descripcion;
        this.Unidades = Unidades;
    }

    
    // PARA LLENAR DETALLE DE ATENCINON
    
    public AtencionPersona(int idAtencion, int IdDetalleAtencion, String TipoAtencion, String NombreLocal, String Detalle, String HoraInicio, String HoraFin, String Estado) {
        this.idAtencion = idAtencion;
        this.IdDetalleAtencion = IdDetalleAtencion;
        this.TipoAtencion = TipoAtencion;
        this.NombreLocal = NombreLocal;
        this.Detalle = Detalle;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.Estado = Estado;
    }

    public AtencionPersona(int idAtencion, int IdDetalleAtencion) {
        this.idAtencion = idAtencion;
        this.IdDetalleAtencion = IdDetalleAtencion;
    }
    
    
    
   public AtencionPersona(int idAtencion, int IdUsuarioCliente, String Nombre_Paciente, String Apellido_Paciente, String Apellido_Medico, Date FechaAtencion, Date FechaProgramada, double subtotal, double igv, double total) {
        this.idAtencion = idAtencion;
        this.IdUsuarioCliente = IdUsuarioCliente;
        this.Nombre_Paciente = Nombre_Paciente;
        this.Apellido_Paciente = Apellido_Paciente;
        this.Apellido_Medico = Apellido_Medico;
        this.FechaAtencion = FechaAtencion;
        this.FechaProgramada = FechaProgramada;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }
   public AtencionPersona(int idAtencion, int IdUsuarioCliente, int IdDetalleAtencion, String Nombre_Paciente, String Apellido_Paciente, String Apellido_Medico, Date FechaAtencion, Date FechaProgramada, double subtotal, double igv, double total) {
        this.idAtencion = idAtencion;
        this.IdUsuarioCliente = IdUsuarioCliente;
        this.IdDetalleAtencion =IdDetalleAtencion;
        this.Nombre_Paciente = Nombre_Paciente;
        this.Apellido_Paciente = Apellido_Paciente;
        this.Apellido_Medico = Apellido_Medico;
        this.FechaAtencion = FechaAtencion;
        this.FechaProgramada = FechaProgramada;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public AtencionPersona(int idAtencion, int IdUsuarioCliente, int IdDetalleAtencion, String Nombre_Paciente, String Apellido_Paciente, String Apellido_Medico, Date FechaAtencion, Date FechaProgramada, double subtotal, double igv, double total, String TipoAtencion, String NombreLocal, String Detalle, String HoraInicio, String HoraFin, String Estado, String Tipo_Receta, String Descripcion, String Unidades) {
        this.idAtencion = idAtencion;
        this.IdUsuarioCliente = IdUsuarioCliente;
        this.IdDetalleAtencion = IdDetalleAtencion;
        this.Nombre_Paciente = Nombre_Paciente;
        this.Apellido_Paciente = Apellido_Paciente;
        this.Apellido_Medico = Apellido_Medico;
        this.FechaAtencion = FechaAtencion;
        this.FechaProgramada = FechaProgramada;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.TipoAtencion = TipoAtencion;
        this.NombreLocal = NombreLocal;
        this.Detalle = Detalle;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.Estado = Estado;
        this.Tipo_Receta = Tipo_Receta;
        this.Descripcion = Descripcion;
        this.Unidades = Unidades;
    }

    public int getIdDetalleAtencion() {
        return IdDetalleAtencion;
    }

    public void setIdDetalleAtencion(int IdDetalleAtencion) {
        this.IdDetalleAtencion = IdDetalleAtencion;
    }

    

    public String getTipo_Receta() {
        return Tipo_Receta;
    }

    public void setTipo_Receta(String Tipo_Receta) {
        this.Tipo_Receta = Tipo_Receta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUnidades() {
        return Unidades;
    }

    public void setUnidades(String Unidades) {
        this.Unidades = Unidades;
    }

   
   
   
    public String getTipoAtencion() {
        return TipoAtencion;
    }

    public void setTipoAtencion(String TipoAtencion) {
        this.TipoAtencion = TipoAtencion;
    }

    public String getNombreLocal() {
        return NombreLocal;
    }

    public void setNombreLocal(String NombreLocal) {
        this.NombreLocal = NombreLocal;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    

    public int getIdUsuarioCliente() {
        return IdUsuarioCliente;
    }

    public void setIdUsuarioCliente(int IdUsuarioCliente) {
        this.IdUsuarioCliente = IdUsuarioCliente;
    }

    public AtencionPersona(){}
    
    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public String getNombre_Paciente() {
        return Nombre_Paciente;
    }

    public void setNombre_Paciente(String Nombre_Paciente) {
        this.Nombre_Paciente = Nombre_Paciente;
    }

    public String getApellido_Paciente() {
        return Apellido_Paciente;
    }

    public void setApellido_Paciente(String Apellido_Paciente) {
        this.Apellido_Paciente = Apellido_Paciente;
    }

    public String getApellido_Medico() {
        return Apellido_Medico;
    }

    public void setApellido_Medico(String Apellido_Medico) {
        this.Apellido_Medico = Apellido_Medico;
    }

    public Date getFechaAtencion() {
        return FechaAtencion;
    }

    public void setFechaAtencion(Date FechaAtencion) {
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
