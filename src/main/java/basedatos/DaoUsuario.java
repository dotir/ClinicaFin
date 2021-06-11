package basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.persona;
import modelo.telefono;
import modelo.usuario;
/**
 *
 * @author Dell
 */
public class DaoUsuario {
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    //login 
    public persona login(String usuario,String contraseña){       
        Statement stmt = null;
        boolean more=false;
        persona objpersona = new persona();
        String searchQuery =
                "SELECT * FROM usuario a inner join persona p on a.idPersona=p.idPersona "
                + "inner join tipopersona tp on p.idTipoPersona=tp.idTipoPersona"
                + " where p.NroDocumento='"+
                usuario+"' AND a.Contrasena='"+
                contraseña+"';";
        
        System.out.println(searchQuery);
        
        try{
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more= rs.next();
            
            do{              
                objpersona.setIdPersona(Integer.parseInt(rs.getString("idPersona")));
                objpersona.setNombre(rs.getString("Nombre"));
                objpersona.setApellidoP(rs.getString("ApellidoPaterno"));
                objpersona.setApellidoM(rs.getString("ApellidoMaterno"));
                objpersona.setNroDocumento(rs.getString("NroDocumento"));
                objpersona.setDireccion(rs.getString("Direccion"));
                objpersona.setCorreo(rs.getString("Correo"));
                objpersona.setTipoPersona(rs.getString("Tipo"));
            }while(rs.next());
            
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
        return objpersona;
    }
    
    //obtener telefono
    public telefono obtenerTelefono(int id){       
        Statement stmt = null;
        boolean more=false;
        telefono objtelefono = new telefono();
        String searchQuery =
                "SELECT * FROM persona p inner join telefono t on p.idPersona=t.idPersona"
                + " where p.idPersona='"+
                id+"';";
        
        System.out.println(searchQuery);
        
        try{
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more= rs.next();
            
            do{              
                objtelefono.setIdTelefono(Integer.parseInt(rs.getString("idTelefono")));
                objtelefono.setNrotelefono(rs.getString("NroTelefono"));
                objtelefono.setDetalle(rs.getString("Detalle(Propiedad)"));
                objtelefono.setIdPersona(Integer.parseInt(rs.getString("idPersona")));
;
            }while(rs.next());
            
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
        return objtelefono;
    }
    //obtener contraseña
    public usuario obtenerContrasena(String id){       
        Statement stmt = null;
        boolean more=false;
        usuario objpersona = new usuario();
        String searchQuery =
                "SELECT * FROM usuario a inner join persona p on a.idPersona=p.idPersona "
                + "inner join tipopersona tp on p.idTipoPersona=tp.idTipoPersona"
                + " where p.NroDocumento='"+
                id+"';";
        
        System.out.println(searchQuery);
        
        try{
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more= rs.next();
            
            do{              
                objpersona.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
                objpersona.setNombre(rs.getString("Nombre"));
                objpersona.setContraseña(rs.getString("Contrasena"));
                objpersona.setIdPersona(Integer.parseInt(rs.getString("idPersona")));

            }while(rs.next());
            
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
        return objpersona;
    }
    
    //cantidad de personas
    public int cantidad(){
        int cant=0;
        Statement stmt = null;
        boolean more=false;
        persona objpersona = new persona();
        String searchQuery =
                "SELECT count(*) as cantidad FROM persona;";
        
        System.out.println(searchQuery);
        
        try{
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more= rs.next();
            
            do{               
                cant=Integer.parseInt(rs.getString("cantidad"));
                
            }while(rs.next());
            
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
        return cant;
    }
    
    //registroPaciente
    public persona RegistroP(persona bean,String contra,String celular) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Statement stmt = null;
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
            bean.setEstado(true);
            String sql="INSERT INTO `persona` (`idPersona`,`Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `FechaNacimiento`, `TipoDocumento`, `NroDocumento`, `Direccion`, `Distrito`, `Provincia`, `Departamento`, `Correo`, `Profesion`, `idEspecialidad`, `Estado`, `idTipoPersona`) VALUES ('"+(cantidad()+1)+"', '"+
                    nombre+"', '"+apellidop+"', '"+apellidom+"','1996-12-22','"+tipodocu+"','"+ndocu+"','"+direccion+"','AREQUIPA','AREQUIPA','AREQUIPA','"+correo+"',NULL,NULL,'1','3')";
            String sql2="INSERT INTO `usuario` (`idUsuario`,`Nombre`,`Contraseña`, `idPersona`) VALUES ('"+(cantidad()+1)+"', '"+nombre+"', '"+contrasena+"','"+(cantidad()+1)+"')";
            String sql3="INSERT INTO `telefono` (`idTelefono`, `NroTelefono`, `Detalle(Propiedad)`, `idPersona`) VALUES ('"+(cantidad()+1)+"', '"+celular+"', '', '"+(cantidad()+1)+"')";
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
    
    //Actualizarusuario
    public persona ActualizarU(persona bean,String contra,String celular) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Statement stmt = null;
        try
        {
            int idu=bean.getIdPersona();
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
            bean.setEstado(true);
            String sql="UPDATE `persona` SET `Nombre` ='"+nombre+"',`ApellidoPaterno` ='"+apellidop+"', `ApellidoMaterno` ='"+apellidom+"', `TipoDocumento` ='"+tipodocu+"', `NroDocumento` ='"+ndocu+"',, `Direccion` ='"+direccion+"', `Correo` ='"+correo+"' where idPersona='"+idu+"'";
            String sql2="UPDATE`usuario` SET `idUsuario` ='"+idu+"',`Nombre` ='"+nombre+"',`Contraseña` ='"+contrasena+"' where idPersona='"+idu+"'";
            String sql3="UPDATE `telefono` SET `NroTelefono` ='"+celular+"' where idPersona='"+idu+"'";
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
