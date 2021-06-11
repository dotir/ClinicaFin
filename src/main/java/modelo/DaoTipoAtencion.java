/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.tipoatencion;

/**
 *
 * @author ALESSO
 */
public class DaoTipoAtencion {
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public ArrayList<tipoatencion> obtenerTipoAtencion(){
        ArrayList<tipoatencion> obj_tipo_atencion = new ArrayList<tipoatencion>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT `idTipoAtencion`,`TipoAtencion` FROM `tipoatencion`";
        
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
    
}
