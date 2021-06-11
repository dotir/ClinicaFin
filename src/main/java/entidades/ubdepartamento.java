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
public class ubdepartamento {
    private int id_Departamento;
    private String Departamento;

    public ubdepartamento(int id_Departamento, String Departamento) {
        this.id_Departamento = id_Departamento;
        this.Departamento = Departamento;
    }
    public ubdepartamento(){}

    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
}
