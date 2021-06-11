/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.doctor;
import entidades.persona;

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
                "SELECT * FROM persona p inner join especialidad e on "
                + "p.idEspecialidad=e.idEspecialidad  where idTipoPersona=2 ";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");      
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
    
    public ArrayList<doctor> obtenerDoctoresdet(){
        ArrayList<doctor> obj_doctores = new ArrayList<doctor>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM persona p inner join especialidad e on p.idEspecialidad=e.idEspecialidad "
                + " where idTipoPersona=2 ";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");      
            while(rs.next()){    
                doctor bean = new doctor();

                String idDoctor = rs.getString("p.idPersona");
                bean.setIdDoctor(idDoctor);

                String Nombre = rs.getString("p.Nombre");
                bean.setNombre(Nombre);
                String ApellidoPaterno= rs.getString("p.ApellidoPaterno");
                bean.setApellidosP(ApellidoPaterno);
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setApellidoM(ApellidoMaterno);
                String dni = rs.getString("p.NroDocumento");
                bean.setDni(dni);
                String fecha_nacimiento = rs.getString("p.FechaNacimiento");
                bean.setFecha_nacimiento(fecha_nacimiento);
                String correo = rs.getString("p.Correo");
                bean.setCorreo(correo);
                String Nombrees = rs.getString("e.Nombre");     
                bean.setEspecialidad(Nombrees);
                String DetalleEs = rs.getString("e.Detalle");     
                bean.setDetalle(DetalleEs);
                
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
    
    
    
    public ArrayList<doctor> obtenerDoctoresdetNomb(String Nrodni){
        ArrayList<doctor> obj_doctores = new ArrayList<doctor>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM persona p inner join especialidad e on p.idEspecialidad=e.idEspecialidad "
                + "where idTipoPersona=2 AND p.NroDocumento LIKE '%"+Nrodni+"%' ";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");      
            while(rs.next()){    
                doctor bean = new doctor();

                String idDoctor = rs.getString("p.idPersona");
                bean.setIdDoctor(idDoctor);

                String Nombre = rs.getString("p.Nombre");
                bean.setNombre(Nombre);
                String ApellidoPaterno= rs.getString("p.ApellidoPaterno");
                bean.setApellidosP(ApellidoPaterno);
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setApellidoM(ApellidoMaterno);
                String dni = rs.getString("p.NroDocumento");
                bean.setDni(dni);
                String fecha_nacimiento = rs.getString("p.FechaNacimiento");
                bean.setFecha_nacimiento(fecha_nacimiento);
                String correo = rs.getString("p.Correo");
                bean.setCorreo(correo);
                String Nombrees = rs.getString("e.Nombre");     
                bean.setEspecialidad(Nombrees);
                String DetalleEs = rs.getString("e.Detalle");     
                bean.setDetalle(DetalleEs);
                
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
        PreparedStatement ps4 = null;
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
            String sql="INSERT INTO `persona` (`idPersona`,`Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `FechaNacimiento`, `TipoDocumento`, `NroDocumento`, `id_Direccion`, `Correo`, `Profesion`, `idEspecialidad`, `Estado`, `idTipoPersona`) VALUES (NULL, '"+
                    nombre+"', '"+apellidop+"', '"+apellidom+"','1996-12-22','"+tipodocu+"','"+ndocu+"','"+c.cantidaddi()+"','"+correo+"',NULL,'"+cdes+"','1','2')";
            String sql2="INSERT INTO `usuario` (`idUsuario`,`Nombre`,`Contrasena`, `idPersona`) VALUES (NULL, '"+nombre+"', '"+contrasena+"','"+(c.cantidad()+1)+"')";
            String sql3="INSERT INTO `telefono` (`idTelefono`, `NroTelefono`, `Detalle(Propiedad)`, `idPersona`) VALUES (NULL, '"+celular+"', '', '"+(c.cantidad()+1)+"')";
            String sql4="INSERT INTO `direccion` (`ID_Direccion`, `Id_Dist`, `Descripcion`) VALUES (NULL, '330', '"+direccion+"')";
            
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
            System.out.println(sql3);
            System.out.println(sql4);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
            ps3 = cn.prepareStatement(sql3);
            ps4 = cn.prepareStatement(sql4);
            ps4.execute();
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
    
        //Actualizarusuario
    public doctor ActualizarDoctor(doctor bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
//        PreparedStatement ps3 = null;
        Statement stmt = null;
        try
        {
            int idu = Integer.parseInt(bean.getIdDoctor());
            String nombre = bean.getNombre();
            String apellidop = bean.getApellidosP();
            String apellidom = bean.getApellidoM();
            String fecha_nacimiento = bean.getFecha_nacimiento() ;
            String Especialidad = bean.getEspecialidad();
            String ndocu = bean.getDni();
            String correo =  bean.getCorreo();
            String detalle = bean.getDetalle();
            String sql = "UPDATE `persona` SET `Nombre` ='" + nombre + "',`ApellidoPaterno` ='" 
                        + apellidop + "', `ApellidoMaterno` ='" + apellidom + "', `NroDocumento` ='" 
                        + ndocu + "', `FechaNacimiento` ='" + fecha_nacimiento + "', `Correo` ='" 
                        + correo + "' where idPersona='" + idu + "'";
            String sql2 = "UPDATE `especialidad` SET `Detalle` ='" + detalle + "' WHERE Nombre='" + Especialidad + "'";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
//            System.out.println(sql3);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
//            ps3 = cn.prepareStatement(sql3);
            ps.execute();
            ps2.execute();
//            ps3.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
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
