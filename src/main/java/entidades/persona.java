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
public class persona {
    private int idPersona;

    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String FechaNac;
    
    private String Usuario;
    private String contrasena;
    
    private String tipoDocumento;
    private String NroDocumento;
    private String Direccion;
    private String Distrito;
    private String Provincia;
    private String Departamento;
    private String correo;
//    private String profesion;
    private int idEspcialidad;
    private String TipoEspcialidad;
    private boolean estado;
    private int idTipoPersona;
    private String tipoPersona;
    private String PerEstado;

    public persona() {
    }

    public persona(int idPersona, String Nombre, String ApellidoP, String ApellidoM, String Direccion, String correo) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Direccion = Direccion;
        this.correo = correo;
    }

    
    
    
    public persona(int idPersona, String Nombre, String ApellidoP, String ApellidoM, String FechaNac, String NroDocumento, String Direccion, String correo) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.FechaNac = FechaNac;
        this.NroDocumento = NroDocumento;
        this.Direccion = Direccion;
        this.correo = correo;
    }

    public persona(int idPersona, String Nombre) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
    }    
    
    public persona(int idPersona, String Nombre, String ApellidoP, String ApellidoM, String FechaNac, String NroDocumento, String Direccion, String Distrito, String Provincia, String Departamento, String correo, boolean estado, String tipoPersona) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.FechaNac = FechaNac;
        this.NroDocumento = NroDocumento;
        this.Direccion = Direccion;
        this.Distrito = Distrito;
        this.Provincia = Provincia;
        this.Departamento = Departamento;
        this.correo = correo;
        this.estado = estado;
        this.tipoPersona = tipoPersona;
    }
    
    public persona(String Nombre, String ApellidoP, String ApellidoM, String FechaNac, String tipoDocumento, String NroDocumento, String Direccion, String Distrito, String Provincia, String Departamento, String correo, boolean estado) {
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.FechaNac = FechaNac;
        this.tipoDocumento = tipoDocumento;
        this.NroDocumento = NroDocumento;
        this.Direccion = Direccion;
        this.Distrito = Distrito;
        this.Provincia = Provincia;
        this.Departamento = Departamento;
        this.correo = correo;
        this.estado = estado;
    }

    public persona(int idPersona, String Nombre, String ApellidoP, String ApellidoM, String FechaNac, String tipoDocumento, String NroDocumento, String Direccion, String correo, boolean estado) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.FechaNac = FechaNac;
        this.tipoDocumento = tipoDocumento;
        this.NroDocumento = NroDocumento;
        this.Direccion = Direccion;
        this.correo = correo;
        this.estado = estado;
    }

    public persona(String Nombre, String ApellidoP, String ApellidoM, String FechaNac, String Usuario, String contrasena, String tipoDocumento, String NroDocumento, String Direccion, String Distrito, String Provincia, String Departamento, String correo) {
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.FechaNac = FechaNac;
        this.Usuario = Usuario;
        this.contrasena = contrasena;
        this.tipoDocumento = tipoDocumento;
        this.NroDocumento = NroDocumento;
        this.Direccion = Direccion;
        this.Distrito = Distrito;
        this.Provincia = Provincia;
        this.Departamento = Departamento;
        this.correo = correo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEspcialidad() {
        return idEspcialidad;
    }

    public void setIdEspcialidad(int idEspcialidad) {
        this.idEspcialidad = idEspcialidad;
    }

    public String getTipoEspcialidad() {
        return TipoEspcialidad;
    }

    public void setTipoEspcialidad(String TipoEspcialidad) {
        this.TipoEspcialidad = TipoEspcialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getPerEstado() {
        return PerEstado;
    }

    public void setPerEstado(String PerEstado) {
        this.PerEstado = PerEstado;
    }

   
}
