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
public class ubdistrito {
    private int id_Distrito;
    private String Distrito;
    private int id_Provincia;

    public int getId_Distrito() {
        return id_Distrito;
    }

    public void setId_Distrito(int id_Distrito) {
        this.id_Distrito = id_Distrito;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public int getId_Provincia() {
        return id_Provincia;
    }

    public void setId_Provincia(int id_Provincia) {
        this.id_Provincia = id_Provincia;
    }

    public ubdistrito(int id_Distrito, String Distrito, int id_Provincia) {
        this.id_Distrito = id_Distrito;
        this.Distrito = Distrito;
        this.id_Provincia = id_Provincia;
    }
    public ubdistrito(){}
}
