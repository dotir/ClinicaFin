/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import entidades.DetalleVenta;
import entidades.Venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author ALESSO
 */
public class DaoVentas {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
     //obtener todos los medicamentos
    public ArrayList<DetalleVenta> obtenerMedicamento(int Medicamento, int TipoMedicamento) {
        ArrayList<DetalleVenta> obj = new ArrayList<DetalleVenta>();
        Statement stmt = null;
        String searchQuery
                = "SELECT P.idProducto, M.Nombre, P.Cantidad, P.PrecioUnidad FROM producto P INNER JOIN medicamento M ON M.idMedicamento=P.idMedicamento WHERE  M.idMedicamento='"+ Medicamento +"' AND P.idTipoPresentacion='"+ TipoMedicamento +"'";
        System.out.println(searchQuery);
        try {
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
                DetalleVenta bean = new DetalleVenta();
                int idProducto = Integer.parseInt(rs.getString("P.idProducto"));
                bean.setProducto(idProducto);
                String NombreProducto = rs.getString("M.Nombre");
                bean.setNombreProducto(NombreProducto);
                int Cantidad = Integer.parseInt(rs.getString("P.Cantidad"));
                bean.setCantidad(Cantidad);
                double precio = rs.getDouble("P.PrecioUnidad");
                bean.setPrecio(precio);
                obj.add(bean);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj;
    }

    public String VentaAgregar(Venta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int idDoctor = bean.getIdUProfecionalClinica();
            int idPaciente = bean.getIdUPaciente();
            String Fecha = bean.getFecha();
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `ventamedicamento` (`idVenta`, `idProfesionalClinica`, `idUPaciente`, `Fecha`, `Subtotal`, `Igv`, `Total`) VALUES (NULL, '" + idDoctor + "', '" + idPaciente + "', '" + Fecha + "', '', '', '')";
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
            Respond = "Venta Agregada";
        } else {
            Respond = "Venta No Agregada";
        }
        return Respond;
    }
//  
    public String VentaActulizarProducto(DetalleVenta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int idProducto = bean.getProducto();
            int Cant = bean.getCantidad();
            String sql = "UPDATE producto SET`Cantidad=(SELECT (SELECT P.Cantidad FROM producto P WHERE P.idProducto='"+ idProducto +"')-'"+Cant+"') WHERE idProducto='"+ idProducto +"'";
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
            Respond = "Venta Agregada";
        } else {
            Respond = "Venta No Agregada";
        }
        return Respond;
    }
//  
    public String VentaActualizarPrecio(Venta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int idDoctor = bean.getIdUProfecionalClinica();
            int idPaciente = bean.getIdUPaciente();
            String Fecha = bean.getFecha();
            double SubTotal = bean.getSubTotal();
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `ventamedicamento` (`idVenta`, `idProfesionalClinica`, `idUPaciente`, `Fecha`, `Subtotal`, `Igv`, `Total`) VALUES (NULL, '" + idDoctor + "', '" + idPaciente + "', '" + Fecha + "', '', '', '')";
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
            Respond = "Venta Agregada";
        } else {
            Respond = "Venta No Agregada";
        }
        return Respond;
    }
//  
    public DetalleVenta DetalleVentaAgregar(int idUP, int idUD, DetalleVenta bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try
        {
            int idProducto=bean.getProducto();
            int Cantidad=bean.getCantidad();
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql="INSERT INTO `detalleventamedicamento` (`idDetalleVenta`, `idVenta`, `idProducto`, `Cantidad`) VALUES (NULL, (SELECT MAX(R.idReceta) FROM RECETA R WHERE R.idUDoctor='"+ idUD +"' AND R.idUPaciente='" + idUP + "'), '"+ idProducto +"', '"+ Cantidad +"')";
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
}
