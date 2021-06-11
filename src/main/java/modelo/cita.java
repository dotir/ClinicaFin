/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class cita {
    private int idCita;
    private String detalle;
    private Date fecha;
    private String HoraInicio;
    private String HoraFinal;
    private int idEspecialidad;
    private int idDetalleAtencion;
    private int idUsuarioCliente;
    private int idUsuarioProfesional;

    public cita(String detalle, Date fecha, int idEspecialidad, int idUsuarioCliente, int idUsuarioProfesional) {
        this.detalle = detalle;
        this.fecha = fecha;
        this.idEspecialidad = idEspecialidad;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idUsuarioProfesional = idUsuarioProfesional;
    }

    public cita() {
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(String HoraFinal) {
        this.HoraFinal = HoraFinal;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdDetalleAtencion() {
        return idDetalleAtencion;
    }

    public void setIdDetalleAtencion(int idDetalleAtencion) {
        this.idDetalleAtencion = idDetalleAtencion;
    }

    public int getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(int idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public int getIdUsuarioProfesional() {
        return idUsuarioProfesional;
    }

    public void setIdUsuarioProfesional(int idUsuarioProfesional) {
        this.idUsuarioProfesional = idUsuarioProfesional;
    }
    
    
}
