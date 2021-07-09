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
public class DetalleLaboratorio {
    private int idDetalleLaboratoio;
    private int idLaboratoio;
    private int idExamen;
    private String Examen;
    private String DesExamen;
    private double PrecioExamen;
    private String Resultado;
    private String FechaEntrega;
    private String Estado;
    private double Precio;

    public DetalleLaboratorio(){}
    
    public DetalleLaboratorio(int idDetalleLaboratoio, int idLaboratoio, String Examen, double PrecioExamen, String Estado) {
        this.idDetalleLaboratoio = idDetalleLaboratoio;
        this.idLaboratoio = idLaboratoio;
        this.Examen = Examen;
        this.PrecioExamen = PrecioExamen;
        this.Estado = Estado;
    }

    public DetalleLaboratorio(int idExamen, String DesExamen, String FechaEntrega, String Estado) {
        this.idExamen = idExamen;
        this.DesExamen = DesExamen;
        this.FechaEntrega = FechaEntrega;
        this.Estado = Estado;
    }

    
    
    
    public int getIdDetalleLaboratoio() {
        return idDetalleLaboratoio;
    }

    public void setIdDetalleLaboratoio(int idDetalleLaboratoio) {
        this.idDetalleLaboratoio = idDetalleLaboratoio;
    }

    public int getIdLaboratoio() {
        return idLaboratoio;
    }

    public void setIdLaboratoio(int idLaboratoio) {
        this.idLaboratoio = idLaboratoio;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getExamen() {
        return Examen;
    }

    public void setExamen(String Examen) {
        this.Examen = Examen;
    }

    public String getDesExamen() {
        return DesExamen;
    }

    public void setDesExamen(String DesExamen) {
        this.DesExamen = DesExamen;
    }

    public double getPrecioExamen() {
        return PrecioExamen;
    }

    public void setPrecioExamen(double PrecioExamen) {
        this.PrecioExamen = PrecioExamen;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    
    
      
}
