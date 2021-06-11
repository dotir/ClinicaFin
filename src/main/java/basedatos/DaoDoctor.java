/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.doctor;
import modelo.persona;

/**
 *
 * @author Dell
 */
public class DaoDoctor {
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public ArrayList<doctor> obtenerDoctores(){
        ArrayList<doctor> obj_doctores = new ArrayList<doctor>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM persona p inner join especialidad e on p.idEspecialidad=e.idEspecialidad  where idTipoPersona=2 ";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            
            while(rs.next()){    
                doctor bean = new doctor();

                String Nombre = rs.getString("p.Nombre");
                bean.setNombre(Nombre);
                String ApellidoPaterno= rs.getString("p.ApellidoPaterno");
                bean.setApellidosP(ApellidoPaterno);
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setApellidoM(ApellidoMaterno);
                String Nombrees = rs.getString("e.Nombre");     
                bean.setEspecialidad(Nombrees);
                
                obj_doctores.add(bean);
            }
 
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    rs=null;
                }  
            }
            if(stmt != null){
                try{
                    stmt.close();
                }catch(Exception e){
                    stmt=null;
                }  
            }
            if(currenctCon != null){
                try{
                    currenctCon.close();
                }catch(Exception e){
                    currenctCon=null;
                }  
            }
        }
        return obj_doctores;
    }
    
    
    
    public persona RegistroDoctor(persona bean,doctor bean2,String contra,String celular) {
        
       
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Statement stmt = null;
        //obtener cantidad;
        DaoUsuario c= new DaoUsuario();
        Daodatos e= new Daodatos();
       
        try
        {
            String nombre=bean.getNombre();
            String apellidop=bean.getApellidoP();
            String apellidom=bean.getApellidoM();
            String fechan=bean.getFechaNac();
            String tipodocu=bean.getTipoDocumento();
            String ndocu=bean.getNroDocumento();
            String direccion=bean.getDireccion();
            String distrito=bean.getDistrito();
            String provincia=bean.getProvincia();
            String departamento=bean.getDepartamento();
            String correo=bean.getCorreo();
            String contrasena=contra;
            String especialidad=bean2.getEspecialidad();
            bean.setEstado(true);
            int cdes=e.obtenerCodEspecialidad(especialidad);
            String sql="INSERT INTO `persona` (`idPersona`,`Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `FechaNacimiento`, `TipoDocumento`, `NroDocumento`, `Direccion`, `Distrito`, `Provincia`, `Departamento`, `Correo`, `Profesion`, `idEspecialidad`, `Estado`, `idTipoPersona`) VALUES ('"+(c.cantidad()+1)+"', '"+
                    nombre+"', '"+apellidop+"', '"+apellidom+"','1996-12-22','"+tipodocu+"','"+ndocu+"','"+direccion+"','AREQUIPA','AREQUIPA','AREQUIPA','"+correo+"',NULL,'"+cdes+"','1','2')";
            String sql2="INSERT INTO `usuario` (`idUsuario`,`Nombre`,`Contraseña`, `idPersona`) VALUES ('"+(c.cantidad()+1)+"', '"+nombre+"', '"+contrasena+"','"+(c.cantidad()+1)+"')";
            String sql3="INSERT INTO `telefono` (`idTelefono`, `NroTelefono`, `Detalle(Propiedad)`, `idPersona`) VALUES ('"+(c.cantidad()+1)+"', '"+celular+"', '', '"+(c.cantidad()+1)+"')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
            System.out.println(sql3);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
            ps3 = cn.prepareStatement(sql3);
            ps.execute();
            ps2.execute();
            ps3.execute();
        }
        catch (SQLException ex) {
            Logger.getLogger(DaoDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            try
            {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(ps2 != null) ps2.close();
                if(cn != null) cn.close();
            }
            catch(Exception e2)
            {
                e2.printStackTrace();
            }
        }

        return bean;
    }
    
    
}
