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
public class adjuntoreceta {
    private int idAdjuntoReceta;
    private String receta;
    private int idFarmacia;

    public int getIdAdjuntoReceta() {
        return idAdjuntoReceta;
    }

    public void setIdAdjuntoReceta(int idAdjuntoReceta) {
        this.idAdjuntoReceta = idAdjuntoReceta;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }
    
    
}
