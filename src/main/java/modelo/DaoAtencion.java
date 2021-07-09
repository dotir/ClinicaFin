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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import entidades.detalleatencion;
import entidades.persona;
import entidades.Atencion;
import entidades.AtencionPersona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
     //Actualizar Atencion
     public String ActualizarAtencion(Atencion bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond="";
        boolean a=false;
        try {

            int ida = bean.getIdAtencion();
            String FechaAtencion = bean.getFechaAtencion();
            String HoraFin = bean.getHoraFin();
            String Diagnostico = bean.getDiagnostico();
            String Estado = "Confirmado";

            String sql = "UPDATE atencion A SET A.FechaAtencion='" + FechaAtencion + "', A.HoraFin='" + HoraFin + "',A.Diagnostico='" + Diagnostico + "',A.Estado='" + Estado + "' WHERE A.idAtencion='" + ida + "'";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            System.out.println(ps.toString());
            a = ps.execute();
            
            System.out.println(ps.execute());
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
//                if(ps2 != null) ps2.close();
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (a==false){
                Respond="Cita atendida exitosamente";
            }else{
            Respond="No se pudo tener la cita";
        }
        return Respond;
    }
       //registroCita
    public Atencion RegistrarCita(Atencion bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        Statement stmt = null;
        try
        {
//            public Atencion(int IdUMedico, int IdUPaciente, int IdTipoAtencion,
//            Date FechaProgramada, String HoraInicio, boolean Emergencia, String Estado) 
            int idMedico = bean.getIdUMedico();
            int idPaciente = bean.getIdUPaciente();
            int idLocal = bean.getIdLocal();
            int idTipoAtencion = bean.getIdTipoAtencion();
            Date fechap = bean.getFechaProgramada();
            String HoraInicio=bean.getHoraInicio();
            double Subtotal=bean.getSubtotal();
            double IGV = Subtotal*0.18;
            double Total =Subtotal+IGV;
//            boolean flat = bean.isEmergencia();
            int Emergencia=0;
            if (bean.isEmergencia() ==false){
                Emergencia=0;
            }else{
                Emergencia=1;
            }
                

            
            String Estado="Reservado";
//            String fechaa = bean.getFechaAtencion();
            
            String sql = "INSERT INTO `atencion`"
                    + " (`idAtencion`, `IdLocal`, `idUMedico`, `idUPaciente`,"
                    + " `idTipoAtencion`, `FechaAtencion`, `FechaProgramada`,"
                    + " `HoraInicio`, `HoraFin`, `Diagnostico`, `Emergencia`,"
                    + " `Estado`, `Subtotal`, `IGV`, `Total`)"
                    + " VALUES"
                    + " (NULL, '" + idLocal + "', '" + idMedico + "', '" + idPaciente + "',"
                    + " '" + idTipoAtencion + "', '" + fechap + "', '" + fechap + "',"
                    + " '" + HoraInicio + "', '', '', '" + Emergencia + "',"
                    + " '" + Estado + "', '" + Subtotal + "', '" + IGV + "', '" + Total + "')";
//                    + " (NULL, '"+ idLocal+"', '" + idMedico + "', '"+ idPaciente +"',"
//                    + " '"+ idTipoAtencion+ "', '', '"+ fechap+ "',"
//                    + " '"+ HoraInicio+ "', '', '', '"+ Emergencia+ "',"
//                    + " '"+ Estado+ "', '"+ Subtotal+ "', '"+ IGV+ "', '"+ Total+ "')";
//                    + "(NULL, (Select idUsuario from usuario where idPersona='"+idUsuarioClinica+"'), (Select idUsuario from usuario where idPersona='"+idUsuarioCliente+"'),'"+fechaa+"','"+fechap+"','100','1','101')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            ps.execute();

        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
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
     
         //obtener todas las citas con nombres de doctores.
    public ArrayList<Atencion> obtenerCitaPacientes(int id){

        ArrayList<Atencion> obj_citas = new ArrayList<Atencion>();
        Statement stmt = null;
        
        String searchQuery ="SELECT"
                + " A.idAtencion, PD.Nombre, PD.ApellidoPaterno, PD.ApellidoMaterno,"
                + " E.Nombre, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno,"
                + " TA.TipoAtencion, L.NombreLocal, A.FechaProgramada, A.HoraInicio,"
                + " A.Total"
                + " FROM atencion A"
                + " INNER JOIN persona PP ON A.idUPaciente = PP.idPersona"
                + " INNER JOIN persona PD ON A.idUMedico = PD.idPersona"
                + " INNER JOIN especialidad E ON E.idEspecialidad = PD.idEspecialidad"
                + " INNER JOIN tipoatencion TA ON TA.idTipoAtencion = A.idTipoAtencion"
                + " INNER JOIN LOCAL L ON L.idLocal=A.IdLocal"
                + " WHERE PP.idPersona='" + id + "'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
//            
            while(rs.next()){    
                Atencion bean = new Atencion();
                
                int idAtencion  = Integer.parseInt(rs.getString("A.idAtencion"));
                bean.setIdAtencion(idAtencion);
                String Nombre_Medico  = (rs.getString("PD.Nombre"));
                String Apellido1_Medico  = (rs.getString("PD.ApellidoPaterno"));
                String Apellido2_Medico  = (rs.getString("PD.ApellidoMaterno"));
                bean.setNombreMedico(Nombre_Medico + " " + Apellido1_Medico + " " + Apellido2_Medico);
                String Especialidad = rs.getString("E.Nombre");
                bean.setEspecialidad(Especialidad);
                
                String Nombre_Paciente  = (rs.getString("PP.Nombre"));
                String Apellido1_Paciente  = (rs.getString("PP.ApellidoPaterno"));
                String Apellido2_Paciente  = (rs.getString("PP.ApellidoMaterno"));
                bean.setNombrePaciente(Nombre_Paciente + " " + Apellido1_Paciente + " " + Apellido2_Paciente);

                String TipoAtencion = rs.getString("TA.TipoAtencion");
                bean.setTipoAtencion(TipoAtencion);
                
                String NombreLocal = rs.getString("L.NombreLocal");
                bean.setLocal(NombreLocal);
                
                Date FechaProgramada= rs.getDate("A.FechaProgramada");
                bean.setFechaProgramada((java.sql.Date) FechaProgramada);
                String HoraInicio = rs.getString("A.HoraInicio");
                bean.setHoraInicio(HoraInicio);
                double Total = rs.getDouble("A.Total");
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
    
    
    //obtener todas las citas de pacientes
//    public ArrayList<detalleatencion> obtenerCitaPacientes(int id){
//
//        ArrayList<detalleatencion> obj_citas = new ArrayList<detalleatencion>();
//        Statement stmt = null;
//        
//        String searchQuery =
//                "SELECT * FROM atencion a inner join usuario u on a.idUsuarioCliente=u.idUsuario WHERE u.idPersona='"+id+"'";
//        
//        System.out.println(searchQuery);
//        
//        try{
//            
//            currenctCon = ConnectionManager.getConn();
//            stmt = currenctCon.createStatement();
//            rs = stmt.executeQuery(searchQuery);
////            boolean more= rs.next();
////            
//            while(rs.next()){    
//                detalleatencion bean = new detalleatencion();
//                
//                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
//                bean.setIdAtencion(idAtencion);
//                int idUsuarioClinica  = Integer.parseInt(rs.getString("idUsuarioClinica"));
//                bean.setIdUsuarioClinica(idUsuarioClinica);
//                int idUsuarioCliente  = Integer.parseInt(rs.getString("idUsuarioCliente"));
//                bean.setIdUsuarioCliente(idUsuarioCliente);
//                String FechaAtencion=rs.getString("FechaAtencion");
//                bean.setFechaAtencion(FechaAtencion);
//                Date FechaProgramada= rs.getDate("FechaProgramada");
//                bean.setFechaProgramada((java.sql.Date) FechaProgramada);
//                double Subtotal = rs.getDouble("Subtotal");
//                bean.setSubtotal(Subtotal);
//                double IGV = rs.getDouble("IGV");
//                bean.setIgv(IGV);
//                double Total = rs.getDouble("Total");
//                bean.setTotal(Total);
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

//    //obtener tofas las citas de doctores
//    public ArrayList<detalleatencion> obtenerCitadoctores(int id){
//        ArrayList<detalleatencion> obj_citas = new ArrayList<detalleatencion>();
//        Statement stmt = null;
//        
//
//        String searchQuery =
//                "SELECT * FROM atencion where idUsuarioClinica='"+id+"'";
//        
//        System.out.println(searchQuery);
//        
//        try{
//            
//            currenctCon = ConnectionManager.getConn();
//            stmt = currenctCon.createStatement();
//            rs = stmt.executeQuery(searchQuery);
////            boolean more= rs.next();
////            
//            
//            while(rs.next()){    
//                detalleatencion bean = new detalleatencion();
//                
//                int idAtencion  = Integer.parseInt(rs.getString("idAtencion"));
//                bean.setIdAtencion(idAtencion);
//                int idUsuarioClinica  = Integer.parseInt(rs.getString("idUsuarioClinica"));
//                bean.setIdUsuarioClinica(idUsuarioClinica);
//                int idUsuarioCliente  = Integer.parseInt(rs.getString("idUsuarioCliente"));
//                bean.setIdUsuarioCliente(idUsuarioCliente);
//                String FechaAtencion=rs.getString("FechaAtencion");
//                bean.setFechaAtencion(FechaAtencion);
//                Date FechaProgramada= rs.getDate("FechaProgramada");
//                bean.setFechaProgramada((java.sql.Date) FechaProgramada);
//                double Subtotal = rs.getDouble("Subtotal");
//                bean.setSubtotal(Subtotal);
//                double IGV = rs.getDouble("IGV");
//                bean.setIgv(IGV);
//                double Total = rs.getDouble("Total");
//                bean.setTotal(Total);
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
    

//    public detalleatencion RegistroDetalleCita(detalleatencion bean) {
//        Connection cn = null;
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//  
//        Statement stmt = null;
//        try
//        {
//            int idUsuarioClinica = bean.getIdUsuarioClinica();
//            int idLocal = bean.getIdLocal();
//            int idTipoAtencion=bean.getIdTipoAtencion();
//            Date fechap = bean.getFechaProgramada();
//            String fechaa = bean.getFechaAtencion();
//            String Hora_inicio =bean.getHoraInicio();
//            String Hora_fin=bean.getHoraFin();
//            
//            
//            String sql="INSERT INTO `detalleatencion` (`idDetalleAtencion`, `idAtencion`, `idTipoAtencion`, `idLocal`, `Detalle`, `HoraInicio`, `HoraFin`, `Precio`, `Estado`) VALUES "
//                    + "(NULL, (select MAX(a.idAtencion) from atencion a), '"+idTipoAtencion+"','"+idLocal+"','', '"+Hora_inicio+"' , '"+Hora_fin+"' ,'101','activo')";
//            cn = ConnectionManager.getConn();
//            System.out.println(sql);
//            ps = cn.prepareStatement(sql);
//            ps.execute();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                if(rs != null) rs.close();
//                if(ps != null) ps.close();
//                if(cn != null) cn.close();
//            }
//            catch(Exception e2)
//            {
//                e2.printStackTrace();
//            }
//        }
//        return bean;
//    }
//    
    public AtencionPersona RegistrarDetalleAtencion(AtencionPersona bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
  
        Statement stmt = null;
        try
        {
            int idAte = bean.getIdAtencion();
            int idDetAte = bean.getIdDetalleAtencion();
            String TipoAtencion = bean.getTipoAtencion();
            String NombreLocal=bean.getNombreLocal();
            String HoraIni = bean.getHoraInicio();
            String Detalle = bean.getDetalle();
            String Estado =bean.getEstado();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String Hora_fin=bean.getHoraFin();
            Date date = new Date();
            
            
            String sql="INSERT INTO `detalleatencion` (`idDetalleAtencion`, `idAtencion`, `idTipoAtencion`, `idLocal`, `Detalle`, `HoraInicio`, `HoraFin`, `Precio`, `Estado`) VALUES "
                    + "('"+idDetAte+"', '"+idAte+"', (select t.idTipoAtencion from tipoatencion t where t.TipoAtencion='"+TipoAtencion+"'), (select l.idLocal from local l where l.NombreLocal='"+NombreLocal+"'),'"+Detalle+"', '"+HoraIni+"' , '"+dateFormat.format(date)+"' ,'101','activo')";
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
     public ArrayList<Atencion> obtenerCitadoctoresdet(int id){
        ArrayList<Atencion> obj_citas = new ArrayList<Atencion>();
        Statement stmt = null;
        

         String searchQuery = "SELECT"
                 + " A.idAtencion, PP.idPersona, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno,"
                 + " TA.TipoAtencion, L.NombreLocal, A.FechaProgramada, A.HoraInicio,"
                 + " A.Emergencia, A.Estado"
                 + " FROM atencion A"
                 + " INNER JOIN persona PP ON A.idUPaciente = PP.idPersona"
                 + " INNER JOIN persona PD ON A.idUMedico = PD.idPersona"
                 + " INNER JOIN especialidad E ON E.idEspecialidad = PD.idEspecialidad"
                 + " INNER JOIN tipoatencion TA ON TA.idTipoAtencion = A.idTipoAtencion"
                 + " INNER JOIN LOCAL L ON L.idLocal = A.IdLocal"
                 + " WHERE PD.idPersona ='" + id + "' AND A.Estado='Reservado'";
        System.out.println(searchQuery);
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

            
            while(rs.next()){    
                Atencion bean = new Atencion();
                int idAtencion  = Integer.parseInt(rs.getString("A.idAtencion"));
                bean.setIdAtencion(idAtencion);
                
                int idPAciente = rs.getInt("PP.idPersona");
                bean.setIdUPaciente(idPAciente);
                String Nombre_Paciente  = rs.getString("PP.Nombre");
                String Apellido1_Paciente  = rs.getString("PP.ApellidoPaterno");
                String Apellido2_Paciente  = rs.getString("PP.ApellidoMaterno");
                bean.setNombrePaciente(Nombre_Paciente + " " + Apellido1_Paciente + " " + Apellido2_Paciente);
                
                String TipoAtencion = rs.getString("TA.TipoAtencion");
                bean.setTipoAtencion(TipoAtencion);
                String NombreLocal = rs.getString("L.NombreLocal");
                bean.setLocal(NombreLocal);
                Date FechaProgramada= rs.getDate("A.FechaProgramada");
                bean.setFechaProgramada((java.sql.Date) FechaProgramada);
                String HoraInicio = rs.getString("A.HoraInicio");
                bean.setHoraInicio(HoraInicio);
                boolean EMERGENCIA = rs.getBoolean("A.Emergencia");
                bean.setEmergencia(EMERGENCIA);
                String Estado = rs.getString("A.Estado");
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
    
     //obtener tofas las citas de doctores CON DETALLES
     public ArrayList<Atencion> obtenerCitadoctoresdetNombrePac(String Nombre){
        ArrayList<Atencion> obj_citas = new ArrayList<Atencion>();
        Statement stmt = null;
        

         String searchQuery = "SELECT A.idAtencion, PP.idPersona, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno, TA.TipoAtencion, L.NombreLocal, A.FechaProgramada, A.HoraInicio, A.Emergencia, A.Estado FROM atencion A INNER JOIN persona PP ON A.idUPaciente = PP.idPersona INNER JOIN persona PD ON A.idUMedico = PD.idPersona INNER JOIN especialidad E ON E.idEspecialidad = PD.idEspecialidad INNER JOIN tipoatencion TA ON TA.idTipoAtencion = A.idTipoAtencion INNER JOIN LOCAL L ON L.idLocal = A.IdLocal WHERE (PP.Nombre LIKE '%" + Nombre + "%' OR PP.ApellidoPaterno LIKE '%" + Nombre + "%' OR PP.ApellidoMaterno LIKE '%" + Nombre + "%') GROUP BY PP.Nombre,PP.ApellidoPaterno,PP.ApellidoMaterno";
        System.out.println(searchQuery);
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

            
            while(rs.next()){    
                Atencion bean = new Atencion();
                int idAtencion  = Integer.parseInt(rs.getString("A.idAtencion"));
                bean.setIdAtencion(idAtencion);
                
                int idPAciente = rs.getInt("PP.idPersona");
                bean.setIdUPaciente(idPAciente);
                String Nombre_Paciente  = rs.getString("PP.Nombre");
                String Apellido1_Paciente  = rs.getString("PP.ApellidoPaterno");
                String Apellido2_Paciente  = rs.getString("PP.ApellidoMaterno");
                bean.setNombrePaciente(Nombre_Paciente + " " + Apellido1_Paciente + " " + Apellido2_Paciente);
                
                String TipoAtencion = rs.getString("TA.TipoAtencion");
                bean.setTipoAtencion(TipoAtencion);
                String NombreLocal = rs.getString("L.NombreLocal");
                bean.setLocal(NombreLocal);
                Date FechaProgramada= rs.getDate("A.FechaProgramada");
                bean.setFechaProgramada((java.sql.Date) FechaProgramada);
                String HoraInicio = rs.getString("A.HoraInicio");
                bean.setHoraInicio(HoraInicio);
                boolean EMERGENCIA = rs.getBoolean("A.Emergencia");
                bean.setEmergencia(EMERGENCIA);
                String Estado = rs.getString("A.Estado");
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
//     public ArrayList<Atencion> obtenerCitadoctoresdetNombrePac(String Nombre, int dni){
//        ArrayList<Atencion> obj_citas = new ArrayList<Atencion>();
//        Statement stmt = null;
//        
//
//         String searchQuery = "SELECT A.idAtencion, PP.idPersona, PP.Nombre, PP.ApellidoPaterno, PP.ApellidoMaterno, TA.TipoAtencion, L.NombreLocal, A.FechaProgramada, A.HoraInicio, A.Emergencia, A.Estado FROM atencion A INNER JOIN persona PP ON A.idUPaciente = PP.idPersona INNER JOIN persona PD ON A.idUMedico = PD.idPersona INNER JOIN especialidad E ON E.idEspecialidad = PD.idEspecialidad INNER JOIN tipoatencion TA ON TA.idTipoAtencion = A.idTipoAtencion INNER JOIN LOCAL L ON L.idLocal = A.IdLocal WHERE (PP.Nombre LIKE '%" + Nombre + "%' OR PP.ApellidoPaterno LIKE '%" + Nombre + "%' OR PP.ApellidoMaterno LIKE '" + Nombre + "') AND PP.NroDocumento LIKE '%" + dni + "%' GROUP BY PP.Nombre,PP.ApellidoPaterno,PP.ApellidoMaterno'";
//        System.out.println(searchQuery);
//        try{
//            
//            currenctCon = ConnectionManager.getConn();
//            stmt = currenctCon.createStatement();
//            rs = stmt.executeQuery(searchQuery);
//
//            
//            while(rs.next()){    
//                Atencion bean = new Atencion();
//                int idAtencion  = Integer.parseInt(rs.getString("A.idAtencion"));
//                bean.setIdAtencion(idAtencion);
//                
//                int idPAciente = rs.getInt("PP.idPersona");
//                bean.setIdUPaciente(idPAciente);
//                String Nombre_Paciente  = rs.getString("PP.Nombre");
//                String Apellido1_Paciente  = rs.getString("PP.ApellidoPaterno");
//                String Apellido2_Paciente  = rs.getString("PP.ApellidoMaterno");
//                bean.setNombrePaciente(Nombre_Paciente + " " + Apellido1_Paciente + " " + Apellido2_Paciente);
//                
//                String TipoAtencion = rs.getString("TA.TipoAtencion");
//                bean.setTipoAtencion(TipoAtencion);
//                String NombreLocal = rs.getString("L.NombreLocal");
//                bean.setLocal(NombreLocal);
//                Date FechaProgramada= rs.getDate("A.FechaProgramada");
//                bean.setFechaProgramada((java.sql.Date) FechaProgramada);
//                String HoraInicio = rs.getString("A.HoraInicio");
//                bean.setHoraInicio(HoraInicio);
//                boolean EMERGENCIA = rs.getBoolean("A.Emergencia");
//                bean.setEmergencia(EMERGENCIA);
//                String Estado = rs.getString("A.Estado");
//                bean.setEstado(Estado);
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
    
    
    
     //obtener todas los detalles de atencicon del cliente solo con idatencion y id atencion detalle
     //modificar todo esto
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
