/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.HelperSelect;
import static modelo.DaoAtencion.currenctCon;
import static modelo.DaoAtencion.rs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class DaoDirecciones {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public ArrayList<HelperSelect> obtenerDepartamento(){
        
        Statement stmt = null;
        ArrayList<HelperSelect> objdepartamento = new ArrayList<HelperSelect>();
        String searchQuery =
                "SELECT UD.idDepa,UD.departamento FROM ubdepartamento UD";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){   
                objdepartamento.add(new HelperSelect(rs.getInt("UD.idDepa"), rs.getString("UD.departamento")));
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
        return objdepartamento;
    }
    
    public ArrayList<String> obtenerProvincia(){
        
        Statement stmt = null;
        ArrayList<String> objProvincia = new ArrayList<String>();

        String searchQuery =
                "SELECT * FROM ubprovincia";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objProvincia.add(rs.getString("provincia"));
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
        return objProvincia;
    }
    
    public ArrayList<String> obtenerDistrito(){
        
        Statement stmt = null;
        ArrayList<String> objdistrito = new ArrayList<String>();

        String searchQuery =
                "SELECT * FROM ubdistrito";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objdistrito.add(rs.getString("distrito"));
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
        return objdistrito;
    }
    
    
    
    
    
    public ArrayList<String> obtenerProvincia_Dep(int dep){
        
        Statement stmt = null;
        ArrayList<String> objProvincia = new ArrayList<String>();

        String searchQuery =
                "SELECT p.idProv, p.provincia FROM ubprovincia  p where p.idDepa='"+dep+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objProvincia.add(rs.getString("provincia"));
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
        return objProvincia;
    }
    
    public ArrayList<String> obtenerDistrito_pro(int pro){
        
        Statement stmt = null;
        ArrayList<String> objdistrito = new ArrayList<String>();

        String searchQuery =
                "SELECT d.idDist, d.distrito FROM ubdistrito d where d.idProv='"+pro+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();

            while(rs.next()){     
                objdistrito.add(rs.getString("distrito"));
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
        return objdistrito;
    }
    
    
    
}
