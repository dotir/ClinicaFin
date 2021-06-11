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
public class ubprovincia {
    private int id_provincia;
    private String Provincia;
    private int id_Departamento;

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public ubprovincia(int id_provincia, String Provincia, int id_Departamento) {
        this.id_provincia = id_provincia;
        this.Provincia = Provincia;
        this.id_Departamento = id_Departamento;
    }
    public ubprovincia(){}
}
