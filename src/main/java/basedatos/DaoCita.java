/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import static basedatos.DaoUsuario.currenctCon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.cita;
import modelo.persona;

/**
 *
 * @author Dell
 */
public class DaoCita {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public int cantidadCitas(){
        int cant=0;
        Statement stmt = null;
        boolean more=false;
        persona objpersona = new persona();
        String searchQuery =
                "SELECT count(*) as cantidad FROM cita;";
        
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
    public int cantidadAtencion(){
        int cant=0;
        Statement stmt = null;
        boolean more=false;
        persona objpersona = new persona();
        String searchQuery =
                "SELECT count(*) as cantidad FROM atencion;";
        
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
    
    //obtener todas las citas
    public ArrayList<cita> obtenerCita(){
        ArrayList<cita> obj_citas = new ArrayList<cita>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM cita";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            
            while(rs.next()){    
                cita bean = new cita();
                
                int id_cita = Integer.parseInt(rs.getString("idCita"));
                bean.setIdCita(id_cita);
                System.out.println("id"+id_cita);
                String detalle = rs.getString("Detalle");
                bean.setDetalle(detalle);
                Date Fecha = rs.getDate("Fecha");
                bean.setFecha(Fecha);
                int idEspecialidad = Integer.parseInt(rs.getString("idEspecialidad"));
                bean.setIdEspecialidad(idEspecialidad);
                int IdUsuarioCliente=Integer.parseInt(rs.getString("IdUsuarioCliente"));
                bean.setIdUsuarioCliente(IdUsuarioCliente);
                int IdUsuarioProfesional=Integer.parseInt(rs.getString("IdUsuarioProfesional"));
                bean.setIdUsuarioProfesional(IdUsuarioProfesional);
                
                obj_citas.add(bean);
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
        return obj_citas;
    }
    
    
    //obtener todas las citas de pacientes
    public ArrayList<cita> obtenerCitaPacientes(int id){
        int posicion = 0;
        ArrayList<cita> obj_citas = new ArrayList<cita>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM cita where idUsuarioCliente='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                cita bean = new cita();
                
                int id_cita = Integer.parseInt(rs.getString("idCita"));
                bean.setIdCita(id_cita);
                String detalle = rs.getString("Detalle");
                bean.setDetalle(detalle);
                Date Fecha = rs.getDate("Fecha");
                bean.setFecha(Fecha);
                int idEspecialidad = Integer.parseInt(rs.getString("idEspecialidad"));
                bean.setIdEspecialidad(idEspecialidad);
                int IdUsuarioCliente=Integer.parseInt(rs.getString("IdUsuarioCliente"));
                bean.setIdUsuarioCliente(IdUsuarioCliente);
                int IdUsuarioProfesional=Integer.parseInt(rs.getString("IdUsuarioProfesional"));
                bean.setIdUsuarioProfesional(IdUsuarioProfesional);
                
                obj_citas.add(bean);
                posicion++;
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
        return obj_citas;
    }
    
    //obtener tofas las citas de doctores
    public ArrayList<cita> obtenerCitadoctores(int id){
        ArrayList<cita> obj_citas = new ArrayList<cita>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM cita where idUsuarioProfesional='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            
            while(rs.next()){    
                cita bean = new cita();
                
                int id_cita = Integer.parseInt(rs.getString("idCita"));
                bean.setIdCita(id_cita);
                String detalle = rs.getString("Detalle");
                bean.setDetalle(detalle);
                Date Fecha = rs.getDate("Fecha");
                bean.setFecha(Fecha);
                int idEspecialidad = Integer.parseInt(rs.getString("idEspecialidad"));
                bean.setIdEspecialidad(idEspecialidad);
                int IdUsuarioCliente=Integer.parseInt(rs.getString("IdUsuarioCliente"));
                bean.setIdUsuarioCliente(IdUsuarioCliente);
                int IdUsuarioProfesional=Integer.parseInt(rs.getString("IdUsuarioProfesional"));
                bean.setIdUsuarioProfesional(IdUsuarioProfesional);
                
                obj_citas.add(bean);
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
        return obj_citas;
    }
    
    
    
    //registroCita
    public cita RegistroCita(cita bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        Statement stmt = null;
        try
        {
            
            int IdEspecialidad=bean.getIdEspecialidad();
            String detalle=bean.getDetalle();
            Date fecha=bean.getFecha();
            int IdUsuarioCliente=bean.getIdUsuarioCliente();
            int idUsuarioProfesional = bean.getIdUsuarioProfesional();

            String sql="INSERT INTO `atencion` (`idAtencion`,`Fecha`, `idEmpleado`, `Total`, `Subtotal`, `IGV`, `idUsuario`, `idPersona`) VALUES ('"+
                    (cantidadAtencion()+1)+"', '"+fecha+"', '"+idUsuarioProfesional+"', '100','100','1','"+IdUsuarioCliente+"','"+idUsuarioProfesional+"')";
            String sql2="INSERT INTO `detalleatencion` (`idDetalleAtencion`, `Detalle`, `FechaProgramacion`, `Estado`, `Precio`, `Cantidad`, `idAtencion`, `idEspecialidad`, `idTipoAtencion`, `idLocal`) VALUES ('"+
                    (cantidadAtencion()+1)+"', '"+detalle+"', '"+fecha+"','activo','100','1','"+(cantidadAtencion()+1)+"','"+IdEspecialidad+"','2','1')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
            ps.execute();
            ps2.execute();
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
