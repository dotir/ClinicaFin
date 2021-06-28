package modelo;

import entidades.doctor;
import entidades.AtencionPersona;
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
import entidades.usuario;

/**
 *
 * @author Dell
 */
public class Daodatos {
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public ArrayList<String> obtenerEspecialidad(){
        
        Statement stmt = null;
        ArrayList<String> objespecialidad = new ArrayList<String>();

        String searchQuery =
                "SELECT * FROM especialidad";
        
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
    
}
