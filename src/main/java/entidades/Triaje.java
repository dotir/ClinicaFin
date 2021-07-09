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
public class Triaje {
    private int idTriaje;
    private int idUProfesionalClinica;
    private String NombrePac;
    private String Fecha;
    private String Hora;
    private String Edad;
    private String Peso;
    private String Sintomas;
    private String TensionArterial;
    private String FrecuenciaCardiaca;
    private String Temperatura;
    private String SaturacionOxigeno;
    private String PatologiaPrevia;
    
    public Triaje(){}

    public Triaje(int idUProfesionalClinica, String Fecha, String Hora, String Edad, String Peso, String Sintomas, String TensionArterial, String FrecuenciaCardiaca, String Temperatura, String SaturacionOxigeno, String PatologiaPrevia) {
        this.idUProfesionalClinica = idUProfesionalClinica;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Edad = Edad;
        this.Peso = Peso;
        this.Sintomas = Sintomas;
        this.TensionArterial = TensionArterial;
        this.FrecuenciaCardiaca = FrecuenciaCardiaca;
        this.Temperatura = Temperatura;
        this.SaturacionOxigeno = SaturacionOxigeno;
        this.PatologiaPrevia = PatologiaPrevia;
    }

    public int getIdTriaje() {
        return idTriaje;
    }

    public void setIdTriaje(int idTriaje) {
        this.idTriaje = idTriaje;
    }

    public int getIdUProfesionalClinica() {
        return idUProfesionalClinica;
    }

    public void setIdUProfesionalClinica(int idUProfesionalClinica) {
        this.idUProfesionalClinica = idUProfesionalClinica;
    }

    public String getNombrePac() {
        return NombrePac;
    }

    public void setNombrePac(String NombrePac) {
        this.NombrePac = NombrePac;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String Sintomas) {
        this.Sintomas = Sintomas;
    }

    public String getTensionArterial() {
        return TensionArterial;
    }

    public void setTensionArterial(String TensionArterial) {
        this.TensionArterial = TensionArterial;
    }

    public String getFrecuenciaCardiaca() {
        return FrecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(String FrecuenciaCardiaca) {
        this.FrecuenciaCardiaca = FrecuenciaCardiaca;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String Temperatura) {
        this.Temperatura = Temperatura;
    }

    public String getSaturacionOxigeno() {
        return SaturacionOxigeno;
    }

    public void setSaturacionOxigeno(String SaturacionOxigeno) {
        this.SaturacionOxigeno = SaturacionOxigeno;
    }

    public String getPatologiaPrevia() {
        return PatologiaPrevia;
    }

    public void setPatologiaPrevia(String PatologiaPrevia) {
        this.PatologiaPrevia = PatologiaPrevia;
    }

    
    
   
        
}
