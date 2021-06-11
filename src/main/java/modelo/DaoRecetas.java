package modelo;

import entidades.AtencionPersona;
import static modelo.DaoAtencion.currenctCon;
import static modelo.DaoAtencion.rs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.receta;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class DaoRecetas {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public receta IngresarReceta(receta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try
        {
            int idAtencion=bean.getIdDetalleAtencion();
            String Tipo_Receta=bean.getTipo_Receta();
            String Descripcion=bean.getDescripcion();
            String unidades=bean.getUnidades();
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql="INSERT INTO `receta` (`IdDetalleAtencion`,`IdTipoReceta`, `Descripcion`, `unidades`) "
                    + "VALUES ((select da.idDetalleAtencion from detalleatencion da where da.idAtencion='"+1+"'), "
                           + "(SELECT t.IDTipoReceta FROM tiporeceta t WHERE t.Descripcion='"+Tipo_Receta+"'), '"+Descripcion+"','"+unidades+"')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            ps.execute();
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
                if(cn != null) cn.close();
            }
            catch(Exception e2)
            {
                e2.printStackTrace();
            }
        }

        return bean;
    }
    
     public ArrayList<AtencionPersona> obtenerRecetas(int id){

        ArrayList<AtencionPersona> obj_receta = new ArrayList<AtencionPersona>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT A.idAtencion, A.idUsuarioCliente, p.Nombre Nombre_Paciente,"
                    + " P.ApellidoPaterno Apellido_Paciente, P2.ApellidoPaterno Apellido_Medico,"
                    + " TR.Descripcion Tipo_Receta, R.Descripcion, R.unidades"
                    + " FROM atencion A"
                    + " INNER JOIN USUARIO UP ON UP.idUsuario = A.idUsuarioClinica"
                    + " INNER JOIN USUARIO UC ON UC.idUsuario = A.idUsuarioCliente"
                    + " INNER JOIN PERSONA P ON P.idPersona = UC.idPersona"
                    + " INNER JOIN PERSONA P2 ON P2.idPersona = UP.idPersona"
                    + " INNER JOIN detalleatencion DA ON A.idAtencion=DA.idAtencion"
                    + " INNER JOIN tipoatencion TPA ON TPA.idTipoAtencion=DA.idTipoAtencion"
                    + " INNER JOIN local L ON L.idLocal=DA.idLocal"
                    + " INNER JOIN receta R ON DA.idDetalleAtencion=R.IdDetalleAtencion"
                    + " INNER JOIN tiporeceta TR ON TR.IDTipoReceta=R.IdTipoReceta"
                    + " WHERE idUsuarioClinica = '"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                AtencionPersona bean = new AtencionPersona();
                
                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
                bean.setIdAtencion(idAtencion);
                int idUsuarioCliente  = Integer.parseInt(rs.getString("idUsuarioCliente"));
                bean.setIdUsuarioCliente(idUsuarioCliente);
                
                String Nombre_Paciente  = rs.getString("Nombre_Paciente");
                bean.setNombre_Paciente(Nombre_Paciente);
                String Apellido_Paciente  = rs.getString("Apellido_Paciente");
                bean.setApellido_Paciente(Apellido_Paciente);
                String Apellido_Medico  = rs.getString("Apellido_Medico");
                bean.setApellido_Medico(Apellido_Medico);
                String Tipo_Receta  = rs.getString("Tipo_Receta");
                bean.setTipo_Receta(Tipo_Receta);
                
                String descripcion= rs.getString("descripcion");
                bean.setDescripcion(descripcion);
                
                String unidades= rs.getString("unidades");
                bean.setUnidades(unidades);
                
                
                obj_receta.add(bean);
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
        return obj_receta;
    }
    
//    public ArrayList<citaadjuntos> obtenerReceta(){
//        ArrayList<citaadjuntos> obj_citas = new ArrayList<citaadjuntos>();
//        Statement stmt = null;
//        
//
//        String searchQuery =
//                "SELECT * FROM citaadjuntos";
//        
//        System.out.println(searchQuery);
//        
//        try{
//            
//            currenctCon = ConnectionManager.getConn();
//            stmt = currenctCon.createStatement();
//            rs = stmt.executeQuery(searchQuery);
////            boolean more= rs.next();
//            
//            while(rs.next()){    
//                citaadjuntos bean = new citaadjuntos();
//                
//                int idCitaAdjuntos = Integer.parseInt(rs.getString("idCitaAdjuntos"));
//                bean.setIdCitaAdjunto(idCitaAdjuntos);
//                String Adjuntos = rs.getString("Adjuntos");
//                bean.setAdjuntos(Adjuntos);
//                String Detalles = rs.getString("Detalles");
//                bean.setDetalles(Detalles);
//                int idCita = Integer.parseInt(rs.getString("idCita"));
//                bean.setIdCita(idCita);
//                
//                obj_citas.add(bean);
//            }
// 
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        finally{
//            if(rs != null){
//                try{
//                    rs.close();
//                }catch(Exception e){
//                    rs=null;
//                }  
//            }
//            if(stmt != null){
//                try{
//                    stmt.close();
//                }catch(Exception e){
//                    stmt=null;
//                }  
//            }
//            if(currenctCon != null){
//                try{
//                    currenctCon.close();
//                }catch(Exception e){
//                    currenctCon=null;
//                }  
//            }
//        }
//        return obj_citas;
//    }
//    
//    public ArrayList<citaadjuntos> obtenerRecetaPa(int id){
//        ArrayList<citaadjuntos> obj_citas = new ArrayList<citaadjuntos>();
//        Statement stmt = null;
//        
//
//        String searchQuery =
//                "SELECT * FROM citaadjuntos ca inner join cita c on ca.idCita=c.idCita where idUsuarioCliente='"+id+"'";
//        
//        System.out.println(searchQuery);
//        
//        try{
//            
//            currenctCon = ConnectionManager.getConn();
//            stmt = currenctCon.createStatement();
//            rs = stmt.executeQuery(searchQuery);
////            boolean more= rs.next();
//            
//            while(rs.next()){    
//                citaadjuntos bean = new citaadjuntos();
//                
//                int idCitaAdjuntos = Integer.parseInt(rs.getString("idCitaAdjuntos"));
//                bean.setIdCitaAdjunto(idCitaAdjuntos);
//                String Adjuntos = rs.getString("Adjuntos");
//                bean.setAdjuntos(Adjuntos);
//                String Detalles = rs.getString("Detalles");
//                bean.setDetalles(Detalles);
//                int idCita = Integer.parseInt(rs.getString("idCita"));
//                bean.setIdCita(idCita);
//                
//                obj_citas.add(bean);
//            }
// 
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        finally{
//            if(rs != null){
//                try{
//                    rs.close();
//                }catch(Exception e){
//                    rs=null;
//                }  
//            }
//            if(stmt != null){
//                try{
//                    stmt.close();
//                }catch(Exception e){
//                    stmt=null;
//                }  
//            }
//            if(currenctCon != null){
//                try{
//                    currenctCon.close();
//                }catch(Exception e){
//                    currenctCon=null;
//                }  
//            }
//        }
//        return obj_citas;
//    }
}
