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
public class doctor {
    
    private String idDoctor;
    private String nombre;
    private String apellidosP;
    private String apellidoM;
    private String dni;
    private String especialidad;
    private String fecha_nacimiento;
    private String correo;
    private String detalle;

    public doctor(String nombre, String apellidosP, String apellidoM, String especialidad) {
        this.nombre = nombre;
        this.apellidosP = apellidosP;
        this.apellidoM = apellidoM;
        this.especialidad = especialidad;
    }

    public doctor(String nombre, String apellidosP, String apellidoM, String dni, String especialidad) {
        this.nombre = nombre;
        this.apellidosP = apellidosP;
        this.apellidoM = apellidoM;
        this.dni = dni;
        this.especialidad = especialidad;
    }

    public doctor(String nombre, String apellidosP, String apellidoM, String dni, String fecha_nacimiento, String correo, String especialidad, String detalle) {
        this.nombre = nombre;
        this.apellidosP = apellidosP;
        this.apellidoM = apellidoM;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.especialidad = especialidad;
        this.detalle = detalle;
    }

    public doctor(String idDoctor, String nombre, String apellidosP, String apellidoM, String dni, String fecha_nacimiento, String correo, String especialidad, String detalle) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.apellidosP = apellidosP;
        this.apellidoM = apellidoM;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.especialidad = especialidad;
        this.detalle = detalle;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
    
    public doctor() {
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidosP() {
        return apellidosP;
    }

    public void setApellidosP(String apellidosP) {
        this.apellidosP = apellidosP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
