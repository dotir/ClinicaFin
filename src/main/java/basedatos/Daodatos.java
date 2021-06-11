package basedatos;

import static basedatos.DaoDirecciones.currenctCon;
import static basedatos.DaoDirecciones.rs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public ArrayList<String> obtenerDoctores(){
        
        Statement stmt = null;
        ArrayList<String> objdoctores = new ArrayList<String>();

        String searchQuery =
                "SELECT * FROM persona where idTipoPersona=2";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objdoctores.add(rs.getString("Nombre")+" "+rs.getString("ApellidoPaterno")+" "+rs.getString("ApellidoMaterno"));
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
    
    
    
}
