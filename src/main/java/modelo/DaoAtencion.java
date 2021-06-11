/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import entidades.detalleatencion;
import entidades.persona;
import entidades.AtencionPersona;

/**
 *
 * @author Dell
 */
public class DaoAtencion {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
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
    
     public int obteneridDetalletencion(int id){
        int cant=0;
        Statement stmt = null;
        boolean more=false;
        persona objpersona = new persona();
        String searchQuery =
                "SELECT count(*) as cantidad FROM detalleatencion";
        
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
//    public ArrayList<atencion> obtenerCita(){
//        ArrayList<cita> obj_citas = new ArrayList<cita>();
//        Statement stmt = null;
//        
//
//        String searchQuery =
//                "SELECT * FROM atencion";
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
//                atencion bean = new atencion();
//                
//                int id_cita = Integer.parseInt(rs.getString("idCita"));
//                bean.setIdCita(id_cita);
//                System.out.println("id"+id_cita);
//                String detalle = rs.getString("Detalle");
//                bean.setDetalle(detalle);
//                Date Fecha = rs.getDate("Fecha");
//                bean.setFecha(Fecha);
//                int idEspecialidad = Integer.parseInt(rs.getString("idEspecialidad"));
//                bean.setIdEspecialidad(idEspecialidad);
//                int IdUsuarioCliente=Integer.parseInt(rs.getString("IdUsuarioCliente"));
//                bean.setIdUsuarioCliente(IdUsuarioCliente);
//                int IdUsuarioProfesional=Integer.parseInt(rs.getString("IdUsuarioProfesional"));
//                bean.setIdUsuarioProfesional(IdUsuarioProfesional);
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
    
    
    //obtener todas las citas de pacientes
    public ArrayList<detalleatencion> obtenerCitaPacientes(int id){

        ArrayList<detalleatencion> obj_citas = new ArrayList<detalleatencion>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT * FROM atencion a inner join usuario u on a.idUsuarioCliente=u.idUsuario WHERE u.idPersona='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                detalleatencion bean = new detalleatencion();
                
                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
                bean.setIdAtencion(idAtencion);
                int idUsuarioClinica  = Integer.parseInt(rs.getString("idUsuarioClinica"));
                bean.setIdUsuarioClinica(idUsuarioClinica);
                int idUsuarioCliente  = Integer.parseInt(rs.getString("idUsuarioCliente"));
                bean.setIdUsuarioCliente(idUsuarioCliente);
                Timestamp FechaAtencion=rs.getTimestamp("FechaAtencion");
                bean.setFechaAtencion(FechaAtencion);
                Date FechaProgramada= rs.getDate("FechaProgramada");
                bean.setFechaProgramada(FechaProgramada);
                double Subtotal = rs.getDouble("Subtotal");
                bean.setSubtotal(Subtotal);
                double IGV = rs.getDouble("IGV");
                bean.setIgv(IGV);
                double Total = rs.getDouble("Total");
                bean.setTotal(Total);
                
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
    
    //obtener tofas las citas de doctores
    public ArrayList<detalleatencion> obtenerCitadoctores(int id){
        ArrayList<detalleatencion> obj_citas = new ArrayList<detalleatencion>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM atencion where idUsuarioClinica='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            
            while(rs.next()){    
                detalleatencion bean = new detalleatencion();
                
                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
                bean.setIdAtencion(idAtencion);
                int idUsuarioClinica  = Integer.parseInt(rs.getString("idUsuarioClinica"));
                bean.setIdUsuarioClinica(idUsuarioClinica);
                int idUsuarioCliente  = Integer.parseInt(rs.getString("idUsuarioCliente"));
                bean.setIdUsuarioCliente(idUsuarioCliente);
                Timestamp FechaAtencion=rs.getTimestamp("FechaAtencion");
                bean.setFechaAtencion(FechaAtencion);
                Date FechaProgramada= rs.getDate("FechaProgramada");
                bean.setFechaProgramada(FechaProgramada);
                double Subtotal = rs.getDouble("Subtotal");
                bean.setSubtotal(Subtotal);
                double IGV = rs.getDouble("IGV");
                bean.setIgv(IGV);
                double Total = rs.getDouble("Total");
                bean.setTotal(Total);

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
    public detalleatencion RegistroCita(detalleatencion bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        Statement stmt = null;
        try
        {
            int idUsuarioClinica = bean.getIdUsuarioClinica();
            int idUsuarioCliente = bean.getIdUsuarioCliente();
            Date fechap = bean.getFechaProgramada();
            Timestamp fechaa = bean.getFechaAtencion();
            
            String sql="INSERT INTO `atencion` (`idAtencion`, `idUsuarioClinica`, `idUsuarioCliente`, `FechaAtencion`, `FechaProgramada`, `Subtotal`, `IGV`, `Total`) VALUES "
                    + "(NULL, '"+idUsuarioClinica+"', (Select idUsuario from usuario where idPersona="+idUsuarioCliente+"),'"+fechaa+"','"+fechap+"','100','1','101')";
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
    
    public detalleatencion RegistroDetalleCita(detalleatencion bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
  
        Statement stmt = null;
        try
        {
            int idUsuarioClinica = bean.getIdUsuarioClinica();
            int idLocal = bean.getIdLocal();
            int idTipoAtencion=bean.getIdTipoAtencion();
            Date fechap = bean.getFechaProgramada();
            Timestamp fechaa = bean.getFechaAtencion();
            String Hora_inicio =bean.getHoraInicio();
            String Hora_fin=bean.getHoraFin();
            
            
            String sql="INSERT INTO `detalleatencion` (`idDetalleAtencion`, `idAtencion`, `idTipoAtencion`, `idLocal`, `Detalle`, `HoraInicio`, `HoraFin`, `Precio`, `Estado`) VALUES "
                    + "(NULL, (select MAX(a.idAtencion) from atencion a), '"+idTipoAtencion+"','"+idLocal+"','', '"+Hora_inicio+"' , '"+Hora_fin+"' ,'101','activo')";
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
    
    
     //obtener tofas las citas de doctores CON DETALLES
    public ArrayList<AtencionPersona> obtenerCitadoctoresdet(int id){
        ArrayList<AtencionPersona> obj_citas = new ArrayList<AtencionPersona>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT A.idAtencion, A.idUsuarioCliente, p.Nombre Nombre_Paciente, DA.idDetalleAtencion, "
                        + "P.ApellidoPaterno Apellido_Paciente, P2.ApellidoPaterno Apellido_Medico,"
                        + " A.FechaAtencion, A.FechaProgramada, A.Subtotal, A.IGV, A.Total,"
                        + " TPA.TipoAtencion, L.NombreLocal, DA.Detalle, DA.HoraInicio,"
                        + " DA.HoraFin, DA.Estado "
                        + "FROM atencion A"
                        + " INNER JOIN USUARIO UP ON UP.idUsuario = A.idUsuarioClinica"
                        + " INNER JOIN USUARIO UC ON UC.idUsuario = A.idUsuarioCliente"
                        + " INNER JOIN PERSONA P ON P.idPersona = UC.idPersona"
                        + " INNER JOIN PERSONA P2 ON P2.idPersona = UP.idPersona"
                        + " INNER JOIN detalleatencion DA ON A.idAtencion=DA.idAtencion"
                        + " INNER JOIN tipoatencion TPA ON TPA.idTipoAtencion=DA.idTipoAtencion"
                        + " INNER JOIN local L ON L.idLocal=DA.idLocal"
                        + " WHERE    idUsuarioClinica ='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

            
            while(rs.next()){    
                AtencionPersona bean = new AtencionPersona();
                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
                bean.setIdAtencion(idAtencion);
                int idUsuarioCliente  = Integer.parseInt(rs.getString("idUsuarioCliente"));
                bean.setIdUsuarioCliente(idUsuarioCliente);
                int idDetalleAtencion  = Integer.parseInt(rs.getString("idDetalleAtencion"));
                bean.setIdDetalleAtencion(idDetalleAtencion);
                String Nombre_Paciente  = rs.getString("Nombre_Paciente");
                bean.setNombre_Paciente(Nombre_Paciente);
                String Apellido_Paciente  = rs.getString("Apellido_Paciente");
                bean.setApellido_Paciente(Apellido_Paciente);
                String Apellido_Medico  = rs.getString("Apellido_Medico");
                bean.setApellido_Medico(Apellido_Medico);
                
               
                Date FechaAtencion=rs.getDate("FechaAtencion");
                bean.setFechaAtencion(FechaAtencion);
                Date FechaProgramada= rs.getDate("FechaProgramada");
                bean.setFechaProgramada(FechaProgramada);
                double Subtotal = rs.getDouble("Subtotal");
                bean.setSubtotal(Subtotal);
                double IGV = rs.getDouble("IGV");
                bean.setIgv(IGV);
                double Total = rs.getDouble("Total");
                bean.setTotal(Total);
                
                String TipoAtencion = rs.getString("TipoAtencion");
                bean.setTipoAtencion(TipoAtencion);
                String NombreLocal = rs.getString("NombreLocal");
                bean.setNombreLocal(NombreLocal);
                String Detalle = rs.getString("Detalle");
                bean.setDetalle(Detalle);
                String HoraInicio = rs.getString("HoraInicio");
                bean.setHoraInicio(HoraInicio);
                String HoraFin = rs.getString("HoraFin");
                bean.setHoraFin(HoraFin);
                String Estado = rs.getString("Estado");
                bean.setEstado(Estado);

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
    
    
     //obtener todas los detalles de atencicon del cliente solo con idatencion y id atencion detalle
    public ArrayList<AtencionPersona> obtenerDetalleAtencion(int idAte , int idDetalleAte){
        ArrayList<AtencionPersona> obj_citas = new ArrayList<AtencionPersona>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT DE.idAtencion, DE.idDetalleAtencion, TA.TipoAtencion,L.NombreLocal,"
                + " DE.Detalle, DE.HoraInicio, DE.HoraFin, DE.Precio, DE.Estado"
                + " FROM detalleatencion DE"
                + " INNER JOIN tipoatencion TA ON TA.idTipoAtencion=DE.idTipoAtencion"
                + " INNER JOIN LOCAL L ON L.idLocal=DE.idLocal"
                + " WHERE DE.idAtencion='"+ idAte +"' AND DE.idDetalleAtencion='"+ idDetalleAte +"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

            
            while(rs.next()){    
                AtencionPersona bean = new AtencionPersona();
                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
                bean.setIdAtencion(idAtencion);
                int idDetalleAtencion  = Integer.parseInt(rs.getString("idDetalleAtencion"));
                bean.setIdDetalleAtencion(idDetalleAtencion);
                
                String TipoAtencion = rs.getString("TipoAtencion");
                bean.setTipoAtencion(TipoAtencion);
                String NombreLocal = rs.getString("NombreLocal");
                bean.setNombreLocal(NombreLocal);
                String Detalle = rs.getString("Detalle");
                bean.setDetalle(Detalle);
                String HoraInicio = rs.getString("HoraInicio");
                bean.setHoraInicio(HoraInicio);
                String HoraFin = rs.getString("HoraFin");
                bean.setHoraFin(HoraFin);
                String Estado = rs.getString("Estado");
                bean.setEstado(Estado);

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
    
    
    //actualizar atencion detalle
    public AtencionPersona ActualizarAtencionDetalle(AtencionPersona bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        PreparedStatement ps2 = null;
//        PreparedStatement ps3 = null;
        Statement stmt = null;
        try
        {
            
            int ida=bean.getIdAtencion();
            int IdUsuarioClien=bean.getIdUsuarioCliente();
            String Detalle=bean.getDetalle();
            String HoraInicio=bean.getHoraInicio();
            String HoraFin=bean.getHoraFin();
            bean.setEstado("1");
            String Estado =bean.getEstado();
            String sql="UPDATE `detalleatencion` SET `Detalle` ='"+Detalle+"',`HoraInicio` ='"+HoraInicio+"', `HoraFin` ='"+HoraFin+"', `Estado` ='"+Estado+"' where idAtencion='"+ida+"'";
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
//                if(ps2 != null) ps2.close();
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
