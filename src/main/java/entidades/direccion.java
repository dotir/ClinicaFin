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
public class direccion {
    private int id_direccion;
    private int id_dist;
    private String Descripcion;

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_dist() {
        return id_dist;
    }

    public void setId_dist(int id_dist) {
        this.id_dist = id_dist;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public direccion(int id_direccion, int id_dist, String Descripcion) {
        this.id_direccion = id_direccion;
        this.id_dist = id_dist;
        this.Descripcion = Descripcion;
    }   
    
    public direccion(){}
}
