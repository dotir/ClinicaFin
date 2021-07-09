package modelo;

import entidades.doctor;
import entidades.AtencionPersona;
import entidades.HelperSelect;
import static modelo.DaoDirecciones.currenctCon;
import static modelo.DaoDirecciones.rs;
import static modelo.DaoTipoAtencion.currenctCon;
import static modelo.DaoTipoAtencion.rs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.tipoatencion;
import entidades.*;

/**
 *
 * @author Dell
 */
public class Daodatos {
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    //cambios ok
    public ArrayList<HelperSelect> obtenerEspecialidad(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();

        String searchQuery =
                "SELECT * FROM especialidad";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objespecialidad.add(new HelperSelect(rs.getInt("idEspecialidad"),rs.getString("Nombre")));
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
        return objespecialidad;
    }
    
    public ArrayList<HelperSelect> obtenerDoctorEspecialidad(int id){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String Nombre;
        String ApellidoP;
        String ApellidoM;

        String searchQuery =
                "SELECT *"
                + " FROM persona P"
                + " INNER JOIN especialidad E ON E.idEspecialidad=P.idEspecialidad"
                + " WHERE E.idEspecialidad='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                Nombre=rs.getString("P.Nombre");
                ApellidoP=rs.getString("P.ApellidoPaterno");
                ApellidoM=rs.getString("P.ApellidoMaterno");
                objespecialidad.add(new HelperSelect(rs.getInt("P.idPersona"),Nombre + " " + ApellidoP + " " + ApellidoM));
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
        return objespecialidad;
    }
    
    public ArrayList<HelperSelect> obtenerMedicamentos(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT M.idMedicamento, M.Nombre FROM medicamento M";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("M.idMedicamento"), rs.getString("M.Nombre")));
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
        return objespecialidad;
    }
    
    public ArrayList<HelperSelect> obtenerPresentacionCant(int id){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT TP.idTipoPresentacion,TP.Nombre, P.Cantidad_Presentacion,P.Cantidad_Medida,UM.Nombre FROM tipopresentacion TP INNER JOIN producto P ON TP.idTipoPresentacion=P.idTipoPresentacion INNER JOIN unidadmedida UM ON UM.idUnidadMedida=P.idUnidadMedidad WHERE P.idMedicamento='"+id +"'";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("TP.idTipoPresentacion"), rs.getString("P.Cantidad_Presentacion") +" " + rs.getString("TP.Nombre")+ " " + rs.getString("P.Cantidad_Medida")+ " " + rs.getString("UM.Nombre")));
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
        return objespecialidad;
    }
    
    public int obtenerCantMax(int id1,int id2){
        
        Statement stmt = null;
//        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        int result=0;
        String searchQuery ="SELECT P.Cantidad FROM producto P WHERE P.idMedicamento='"+id1 +"' AND P.idTipoPresentacion='"+id2 +"'";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                result=rs.getInt("P.Cantidad");
//                objespecialidad.add(new HelperSelect(rs.getInt("TP.idTipoPresentacion"), rs.getString("P.Cantidad_Presentacion") +" " + rs.getString("TP.Nombre")+ " " + rs.getString("P.Cantidad_Medida")+ " " + rs.getString("UM.Nombre")));
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
        return result;
    }
    
    public ArrayList<HelperSelect> obtenerTipoPresentacion(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT TP.idTipoPresentacion, TP.Nombre FROM tipopresentacion TP";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("TP.idTipoPresentacion"), rs.getString("TP.Nombre")));
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
        return objespecialidad;
    }
    
    public ArrayList<HelperSelect> obtenerUnidadMedida(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT UM.idUnidadMedida,UM.Nombre FROM unidadmedida UM";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("UM.idUnidadMedida"), rs.getString("UM.Nombre")));
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
        return objespecialidad;
    }
    
    public int obtenerCostoEspecialidad(int id){
        Statement stmt = null;
        int result=0;
        String searchQuery =
                "SELECT e.Costo"
                + " FROM especialidad e"
                + " where e.idEspecialidad='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            
            while(rs.next()){
                result=rs.getInt("e.Costo");
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
        return result;
    }
    
    public ArrayList<HelperSelect> obtenerTipoExamen(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT TE.idTipoExamen,TE.Descripcion FROM tipoexamen TE";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("TE.idTipoExamen"), rs.getString("TE.Descripcion")));
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
        return objespecialidad;
    }
 
    public ArrayList<HelperSelect> obtenerExamen(int id){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT E.idExamen, E.Descripcion FROM examen E WHERE E.idTipoExamen='" + id +"'";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("E.idExamen"), rs.getString("E.Descripcion")));
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
        return objespecialidad;
    }
 
    //por revisar
    public int obtenerCodEspecialidad(String especialidad){
        
        Statement stmt = null;
        int cod=0;
        String searchQuery =
                "SELECT * FROM especialidad where Nombre='"+especialidad+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                cod=Integer.parseInt(rs.getString("idEspecialidad"));
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
        return cod;
    }
    
    public ArrayList<String> obtenerCodEspecialidadByEspec(String especialidad){
        
        Statement stmt = null;
        ArrayList<String> objespecialidad = new ArrayList<String>();

        String searchQuery =
                "SELECT * FROM especialidad where Nombre='"+especialidad+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objespecialidad.add(rs.getString("Nombre"));
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
        return objespecialidad;
    }
    
    public int obtenerCodDoctor(String doctor){
        
        Statement stmt = null;
        int cod=0;
        String searchQuery =
                "SELECT * FROM persona where Nombre='"+doctor+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                cod=Integer.parseInt(rs.getString("idPersona"));
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
        return cod;
    }
    
    public ArrayList<AtencionPersona> obtenerDoctores(){
        
        Statement stmt = null;
        
        ArrayList<AtencionPersona> objdoctores = new ArrayList<AtencionPersona>();
        ArrayList<usuario> obj1 = new ArrayList<usuario>(); 
        String searchQuery =
                "SELECT * FROM persona where idTipoPersona=2";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            AtencionPersona objdoc;
            while (rs.next()) {
                objdoc=new AtencionPersona();

                objdoc.setIdUsuarioMedico(Integer.parseInt(rs.getString("idPersona")));
                objdoc.setNombre_Medico(rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno"));
                objdoctores.add(objdoc);
//                objdoctores.add(rs.getString("idPersona") + " " + rs.getString("Nombre")+" "+rs.getString("ApellidoPaterno")+" "+rs.getString("ApellidoMaterno"));
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
        return objdoctores;
    }
    
//    public ArrayList<String> obtenerDoctores(){
//        
//        Statement stmt = null;
//        ArrayList<String> objdoctores = new ArrayList<String>();
//        ArrayList<usuario> obj1 = new ArrayList<usuario>(); 
//        String searchQuery =
//                "SELECT * FROM persona where idTipoPersona=2";
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
//                objdoctores.add(rs.getString("idPersona") + " " + rs.getString("Nombre")+" "+rs.getString("ApellidoPaterno")+" "+rs.getString("ApellidoMaterno"));
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
//        return objdoctores;
//    }
//    
    
    
    public ArrayList<String> obtenerLocal(){
        Statement stmt = null;
        ArrayList<String> objlocal = new ArrayList<String>();

        String searchQuery =
                "SELECT NombreLocal FROM local";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objlocal.add(rs.getString("NombreLocal"));
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
        return objlocal;
    }
    
    public int obtenerCodLocal(String local){
        
        Statement stmt = null;
        int cod=0;
        String searchQuery =
                "SELECT * FROM local where NombreLocal='"+local+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                cod=Integer.parseInt(rs.getString("idLocal"));
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
        return cod;
    }
    
    public ArrayList<tipoatencion> obtenerTipoAtencion(){
        ArrayList<tipoatencion> obj_tipo_atencion = new ArrayList<tipoatencion>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT `TipoAtencion` FROM `tipoatencion`";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            
            while(rs.next()){    
                tipoatencion bean = new tipoatencion();
                
                int idTipoAtencion = Integer.parseInt(rs.getString("idTipoAtencion"));
                bean.setIdTipoAtencion(idTipoAtencion);
                String tipoAtencion = rs.getString("tipoAtencion");
                bean.setTipoAtencion(tipoAtencion);
                
                obj_tipo_atencion.add(bean);
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
        
        return obj_tipo_atencion;
    }
    
    
    public ArrayList<String> obtenerdocumentos(){
        Statement stmt = null;
        ArrayList<String> objdocumentos = new ArrayList<String>();

        String searchQuery =
                "SELECT * FROM tipodocumento";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objdocumentos.add(rs.getString("nombre"));
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
        return objdocumentos;
        
    }
    
    public ArrayList<HelperSelect> obtenerDepartamento(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT UD.idDepa,UD.departamento FROM ubdepartamento UD";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("UD.idDepa"), rs.getString("UD.departamento")));
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
        return objespecialidad;
    }
    
    public ArrayList<HelperSelect> obtenerProvincia(int ud){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT UP.idProv,UP.provincia FROM ubprovincia UP WHERE UP.idDepa='"+ud+"'";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("UP.idProv"), rs.getString("UP.provincia")));
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
        return objespecialidad;
    }
 
    public ArrayList<HelperSelect> obtenerDistrito(int up){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objespecialidad = new ArrayList<HelperSelect>();
        String searchQuery ="SELECT UD.idDist,UD.distrito FROM ubdistrito UD WHERE UD.idProv='"+up+"'";
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){
                objespecialidad.add(new HelperSelect(rs.getInt("UD.idDist"), rs.getString("UD.distrito")));
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
        return objespecialidad;
    }
 
    
}
