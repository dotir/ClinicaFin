package modelo;

import entidades.AtencionPersona;
import entidades.DetalleReceta;
import static modelo.DaoAtencion.currenctCon;
import static modelo.DaoAtencion.rs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.Receta;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class DaoRecetas {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public String RecetaAgregar(Receta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int idDoctor = bean.getIdUDoctor();
            int idPaciente = bean.getIdUPaciente();
            String Fecha = bean.getFecha();
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `receta` (`idReceta`, `idUDoctor`, `idUPaciente`, `Fecha`, `Estado`) VALUES (NULL, '" + idDoctor + "', '" + idPaciente + "', '" + Fecha + "', 'Emitida')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            a = ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (a == false) {
            Respond = "Receta Agregada";
        } else {
            Respond = "Receta No Agregada";
        }
        return Respond;
    }
//    
    public DetalleReceta DetalleRecetaAgregar(int idUP, int idUD, DetalleReceta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try
        {
            String Descripcion=bean.getDescripcion();
            int Cantidad=bean.getCantidad();
            String Observaciones=bean.getObservacion();
            String Estado=bean.getEstado();
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql="INSERT INTO `detallereceta` (`idDetalleReceta`, `idReceta`, `Descripcion`, `Cantidad`, `Observaciones`, `Estado`) VALUES (NULL, (SELECT MAX(R.idReceta) FROM RECETA R WHERE R.idUDoctor='"+ idUD +"' AND R.idUPaciente='" + idUP + "'), '"+Descripcion+"', '"+ Cantidad +"', '"+ Observaciones +"', '"+ Estado +"')";
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
//    
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
    
     public ArrayList<Receta> obtenerRecetasVentas(){

        ArrayList<Receta> obj_receta = new ArrayList<Receta>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT R.idReceta, R.idUDoctor, PD.Nombre, PD.ApellidoPaterno, PD.ApellidoMaterno, PP.idPersona, PP.NroDocumento, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno, PP.NroDocumento, R.Fecha, R.Estado FROM receta R INNER JOIN persona PP ON PP.idPersona = R.idUPaciente INNER JOIN persona PD ON PD.idPersona = R.idUDoctor INNER JOIN detallereceta DR ON R.idReceta=DR.idReceta WHERE DR.Observaciones<>'Examen' GROUP BY R.idReceta";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                Receta bean = new Receta();
                
                int idReceta  = Integer.parseInt(rs.getString("R.idReceta"));
                bean.setIdReceta(idReceta);
                
                int IdUDoctor  = Integer.parseInt(rs.getString("R.idUDoctor"));
                bean.setIdUDoctor(IdUDoctor);
                
                String NombreDoc  = rs.getString("PD.Nombre");
                String ApellidoPaDoc  = rs.getString("PD.ApellidoPaterno");
                String ApellidoMaDoc  = rs.getString("PD.ApellidoMaterno");
                bean.setNombreDoctor(ApellidoPaDoc + " " + ApellidoMaDoc + ", " + NombreDoc);
                
                
                String dniPac  = rs.getString("PP.NroDocumento");
                bean.setDni(dniPac);
                
                int IdUPaciente  = Integer.parseInt(rs.getString("PP.idPersona"));
                bean.setIdUPaciente(IdUPaciente);
                
                String NombrePac  = rs.getString("PP.Nombre");
                String ApellidoPaPac  = rs.getString("PP.ApellidoPaterno");
                String ApellidoMaPac  = rs.getString("PP.ApellidoMaterno");
                bean.setNombrePaciente(ApellidoPaPac + " " + ApellidoMaPac + ", " + NombrePac);
                
                String FechaRec = rs.getString("R.Fecha");
                bean.setFecha(FechaRec);
                
                String EstadoRec = rs.getString("R.Estado");
                bean.setEstado(EstadoRec);
                
                
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
     
     public ArrayList<Receta> obtenerRecetasVentasLike(int dni){

        ArrayList<Receta> obj_receta = new ArrayList<Receta>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT R.idReceta, R.idUDoctor, PD.Nombre, PD.ApellidoPaterno, PD.ApellidoMaterno, PP.idPersona, PP.NroDocumento, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno, PP.NroDocumento, R.Fecha, R.Estado FROM receta R INNER JOIN persona PP ON PP.idPersona = R.idUPaciente INNER JOIN persona PD ON PD.idPersona = R.idUDoctor INNER JOIN detallereceta DR ON R.idReceta=DR.idReceta WHERE PP.NroDocumento LIKE '%"+ dni +"%' AND DR.Observaciones<>'Examen' GROUP BY R.idReceta";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                Receta bean = new Receta();
                
                int idReceta  = Integer.parseInt(rs.getString("R.idReceta"));
                bean.setIdReceta(idReceta);
                
                int IdUDoctor  = Integer.parseInt(rs.getString("R.idUDoctor"));
                bean.setIdUDoctor(IdUDoctor);
                
                String NombreDoc  = rs.getString("PD.Nombre");
                String ApellidoPaDoc  = rs.getString("PD.ApellidoPaterno");
                String ApellidoMaDoc  = rs.getString("PD.ApellidoMaterno");
                bean.setNombreDoctor(ApellidoPaDoc + " " + ApellidoMaDoc + ", " + NombreDoc);
                
                
                String dniPac  = rs.getString("PP.NroDocumento");
                bean.setDni(dniPac);
                
                int IdUPaciente  = Integer.parseInt(rs.getString("PP.idPersona"));
                bean.setIdUPaciente(IdUPaciente);
                
                String NombrePac  = rs.getString("PP.Nombre");
                String ApellidoPaPac  = rs.getString("PP.ApellidoPaterno");
                String ApellidoMaPac  = rs.getString("PP.ApellidoMaterno");
                bean.setNombrePaciente(ApellidoPaPac + " " + ApellidoMaPac + ", " + NombrePac);
                
                String FechaRec = rs.getString("R.Fecha");
                bean.setFecha(FechaRec);
                
                String EstadoRec = rs.getString("R.Estado");
                bean.setEstado(EstadoRec);
                
                
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
    
     public ArrayList<Receta> obtenerRecetasLaboratorio(){

        ArrayList<Receta> obj_receta = new ArrayList<Receta>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT R.idReceta, R.idUDoctor, PD.Nombre, PD.ApellidoPaterno, PD.ApellidoMaterno, PP.idPersona, PP.NroDocumento, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno, PP.NroDocumento, R.Fecha, R.Estado FROM receta R INNER JOIN persona PP ON PP.idPersona = R.idUPaciente INNER JOIN persona PD ON PD.idPersona = R.idUDoctor INNER JOIN detallereceta DR ON R.idReceta = DR.idReceta WHERE DR.Observaciones = 'Examen' GROUP BY R.idReceta";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                Receta bean = new Receta();
                
                int idReceta  = Integer.parseInt(rs.getString("R.idReceta"));
                bean.setIdReceta(idReceta);
                
                int IdUDoctor  = Integer.parseInt(rs.getString("R.idUDoctor"));
                bean.setIdUDoctor(IdUDoctor);
                
                String NombreDoc  = rs.getString("PD.Nombre");
                String ApellidoPaDoc  = rs.getString("PD.ApellidoPaterno");
                String ApellidoMaDoc  = rs.getString("PD.ApellidoMaterno");
                bean.setNombreDoctor(ApellidoPaDoc + " " + ApellidoMaDoc + ", " + NombreDoc);
                
                
                String dniPac  = rs.getString("PP.NroDocumento");
                bean.setDni(dniPac);
                
                int IdUPaciente  = Integer.parseInt(rs.getString("PP.idPersona"));
                bean.setIdUPaciente(IdUPaciente);
                
                String NombrePac  = rs.getString("PP.Nombre");
                String ApellidoPaPac  = rs.getString("PP.ApellidoPaterno");
                String ApellidoMaPac  = rs.getString("PP.ApellidoMaterno");
                bean.setNombrePaciente(ApellidoPaPac + " " + ApellidoMaPac + ", " + NombrePac);
                
                String FechaRec = rs.getString("R.Fecha");
                bean.setFecha(FechaRec);
                
                String EstadoRec = rs.getString("R.Estado");
                bean.setEstado(EstadoRec);
                
                
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
    
     public ArrayList<Receta> obtenerRecetasLaboratorioLike(int dni){

        ArrayList<Receta> obj_receta = new ArrayList<Receta>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT R.idReceta, R.idUDoctor, PD.Nombre, PD.ApellidoPaterno, PD.ApellidoMaterno, PP.idPersona, PP.NroDocumento, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno, PP.NroDocumento, R.Fecha, R.Estado FROM receta R INNER JOIN persona PP ON PP.idPersona = R.idUPaciente INNER JOIN persona PD ON PD.idPersona = R.idUDoctor INNER JOIN detallereceta DR ON R.idReceta = DR.idReceta WHERE PP.NroDocumento LIKE '%"+ dni +"%' AND DR.Observaciones = 'Examen' GROUP BY R.idReceta";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                Receta bean = new Receta();
                
                int idReceta  = Integer.parseInt(rs.getString("R.idReceta"));
                bean.setIdReceta(idReceta);
                
                int IdUDoctor  = Integer.parseInt(rs.getString("R.idUDoctor"));
                bean.setIdUDoctor(IdUDoctor);
                
                String NombreDoc  = rs.getString("PD.Nombre");
                String ApellidoPaDoc  = rs.getString("PD.ApellidoPaterno");
                String ApellidoMaDoc  = rs.getString("PD.ApellidoMaterno");
                bean.setNombreDoctor(ApellidoPaDoc + " " + ApellidoMaDoc + ", " + NombreDoc);
                
                
                String dniPac  = rs.getString("PP.NroDocumento");
                bean.setDni(dniPac);
                
                int IdUPaciente  = Integer.parseInt(rs.getString("PP.idPersona"));
                bean.setIdUPaciente(IdUPaciente);
                
                String NombrePac  = rs.getString("PP.Nombre");
                String ApellidoPaPac  = rs.getString("PP.ApellidoPaterno");
                String ApellidoMaPac  = rs.getString("PP.ApellidoMaterno");
                bean.setNombrePaciente(ApellidoPaPac + " " + ApellidoMaPac + ", " + NombrePac);
                
                String FechaRec = rs.getString("R.Fecha");
                bean.setFecha(FechaRec);
                
                String EstadoRec = rs.getString("R.Estado");
                bean.setEstado(EstadoRec);
                
                
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
    
     public ArrayList<DetalleReceta> obtenerDetalleRecetasVentas(int idReceta){

        ArrayList<DetalleReceta> obj_receta = new ArrayList<DetalleReceta>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT DR.idDetalleReceta,DR.idReceta,DR.Descripcion,DR.Cantidad,DR.Observaciones,DR.Estado FROM detallereceta DR WHERE DR.idReceta LIKE '%" + idReceta + "%' AND DR.Observaciones<>'Examen'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                DetalleReceta bean = new DetalleReceta();
                
                int idDetalleReceta  = Integer.parseInt(rs.getString("DR.idDetalleReceta"));
                bean.setIdDetalleReceta(idDetalleReceta);
                
                int idReceta1  = Integer.parseInt(rs.getString("DR.idReceta"));
                bean.setIdReceta(idReceta1);
                
                String Descripcion  = rs.getString("DR.Descripcion");
                bean.setDescripcion(Descripcion);
                
                
                int Cantidad  = Integer.parseInt(rs.getString("DR.Cantidad"));
                bean.setCantidad(Cantidad);
                
                String Observacion  = rs.getString("DR.Observaciones");
                bean.setObservacion(Observacion);
                String Estado  = rs.getString("DR.Estado");
                bean.setEstado(Estado);
                                
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
    
     public ArrayList<DetalleReceta> obtenerDetalleRecetasLaboratorio(int idReceta){

        ArrayList<DetalleReceta> obj_receta = new ArrayList<DetalleReceta>();
        Statement stmt = null;
        
        String searchQuery =
                "SELECT DR.idDetalleReceta,DR.idReceta,DR.Descripcion,DR.Cantidad,DR.Observaciones,DR.Estado FROM detallereceta DR WHERE DR.idReceta LIKE '%" + idReceta + "%' AND DR.Observaciones='Examen'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                DetalleReceta bean = new DetalleReceta();
                
                int idDetalleReceta  = Integer.parseInt(rs.getString("DR.idDetalleReceta"));
                bean.setIdDetalleReceta(idDetalleReceta);
                
                int idReceta1  = Integer.parseInt(rs.getString("DR.idReceta"));
                bean.setIdReceta(idReceta1);
                
                String Descripcion  = rs.getString("DR.Descripcion");
                bean.setDescripcion(Descripcion);
                
                
                int Cantidad  = Integer.parseInt(rs.getString("DR.Cantidad"));
                bean.setCantidad(Cantidad);
                
                String Observacion  = rs.getString("DR.Observaciones");
                bean.setObservacion(Observacion);
                String Estado  = rs.getString("DR.Estado");
                bean.setEstado(Estado);
                                
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
