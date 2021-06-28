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
import entidades.TratamientoStock;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class DaoTratamiento {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    
    
     //obtener todos los medicamentos
     public ArrayList<TratamientoStock> obtenerMedicamento(){
        ArrayList<TratamientoStock> obj_tratamiento = new ArrayList<TratamientoStock>();
        Statement stmt = null;
        String searchQuery =
                    "SELECT t.idTratamiento,t.Nombre,TT.Descripcion,T.Precio"
                    + " FROM tratamiento t"
                    + " INNER JOIN tipotratamiento TT ON tt.idTipoTratamiento = t.IdTipoTratamiento";
        System.out.println(searchQuery);        
        try{
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);            
            while(rs.next()){    
                TratamientoStock bean = new TratamientoStock();                
                int idTratamiento  = Integer.parseInt(rs.getString("t.idTratamiento"));
                bean.setId_tratamiento(idTratamiento);
                String NombreTratamiento  = rs.getString("t.Nombre");
                bean.setNombre_tratamiento(NombreTratamiento);
                String TipoTratamiento  = rs.getString("TT.Descripcion");
                bean.setTipo_tratamiento(TipoTratamiento);                
                double precio = rs.getDouble("T.Precio");
                bean.setPrecio_tratamiento(precio);
                obj_tratamiento.add(bean);
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
        return obj_tratamiento;
    }
    
    public TratamientoStock RegistroMedicamento(TratamientoStock bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
  
        Statement stmt = null;
        try
        {
            String Nombre = bean.getNombre_tratamiento();
            String TipoTratamiento = bean.getTipo_tratamiento();
            double monto=bean.getPrecio_tratamiento();
            
            
            String sql = "INSERT INTO `tratamiento` (`idTratamiento`, `Nombre`, `IdTipoTratamiento`, `Precio`)"
                    + " VALUES (NULL, '" + Nombre + "',"
                    + " (select tt.idTipoTratamiento from tipotratamiento tt where tt.Descripcion='" + TipoTratamiento + "'),"
                    + " '" + monto + "')";
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
}
