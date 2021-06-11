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
public class doctor {
    
    private String nombre;
    private String apellidosP;
    private String apellidoM;
    private String especialidad;

    public doctor(String nombre, String apellidosP, String apellidoM, String especialidad) {
        this.nombre = nombre;
        this.apellidosP = apellidosP;
        this.apellidoM = apellidoM;
        this.especialidad = especialidad;
    }

    public doctor() {
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
