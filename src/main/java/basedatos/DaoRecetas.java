package basedatos;

import static basedatos.DaoCita.currenctCon;
import static basedatos.DaoCita.rs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.cita;
import modelo.citaadjuntos;

/**
 *
 * @author Dell
 */
public class DaoRecetas {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public ArrayList<citaadjuntos> obtenerReceta(){
        ArrayList<citaadjuntos> obj_citas = new ArrayList<citaadjuntos>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM citaadjuntos";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            
            while(rs.next()){    
                citaadjuntos bean = new citaadjuntos();
                
                int idCitaAdjuntos = Integer.parseInt(rs.getString("idCitaAdjuntos"));
                bean.setIdCitaAdjunto(idCitaAdjuntos);
                String Adjuntos = rs.getString("Adjuntos");
                bean.setAdjuntos(Adjuntos);
                String Detalles = rs.getString("Detalles");
                bean.setDetalles(Detalles);
                int idCita = Integer.parseInt(rs.getString("idCita"));
                bean.setIdCita(idCita);
                
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
    
    public ArrayList<citaadjuntos> obtenerRecetaPa(int id){
        ArrayList<citaadjuntos> obj_citas = new ArrayList<citaadjuntos>();
        Statement stmt = null;
        

        String searchQuery =
                "SELECT * FROM citaadjuntos ca inner join cita c on ca.idCita=c.idCita where idUsuarioCliente='"+id+"'";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            
            while(rs.next()){    
                citaadjuntos bean = new citaadjuntos();
                
                int idCitaAdjuntos = Integer.parseInt(rs.getString("idCitaAdjuntos"));
                bean.setIdCitaAdjunto(idCitaAdjuntos);
                String Adjuntos = rs.getString("Adjuntos");
                bean.setAdjuntos(Adjuntos);
                String Detalles = rs.getString("Detalles");
                bean.setDetalles(Detalles);
                int idCita = Integer.parseInt(rs.getString("idCita"));
                bean.setIdCita(idCita);
                
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
}
