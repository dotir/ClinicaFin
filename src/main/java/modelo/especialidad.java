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
public class especialidad {
    private int idEspecialidad;
    private String Nombre;
    private String Detalle;
    private double costo;
    private int idGrupoEspecialidad;

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdGrupoEspecialidad() {
        return idGrupoEspecialidad;
    }

    public void setIdGrupoEspecialidad(int idGrupoEspecialidad) {
        this.idGrupoEspecialidad = idGrupoEspecialidad;
    }
    
    
}
