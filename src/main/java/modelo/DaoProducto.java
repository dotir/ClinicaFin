/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Producto;
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
public class DaoProducto {

    static Connection currenctCon = null;
    static ResultSet rs = null;

    //obtener todos los medicamentos
    public ArrayList<TratamientoStock> obtenerMedicamento() {
        ArrayList<TratamientoStock> obj_tratamiento = new ArrayList<TratamientoStock>();
        Statement stmt = null;
        String searchQuery
                = "SELECT t.idTratamiento,t.Nombre,TT.Descripcion,T.Precio"
                + " FROM tratamiento t"
                + " INNER JOIN tipotratamiento TT ON tt.idTipoTratamiento = t.IdTipoTratamiento";
        System.out.println(searchQuery);
        try {
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
                TratamientoStock bean = new TratamientoStock();
                int idTratamiento = Integer.parseInt(rs.getString("t.idTratamiento"));
                bean.setId_tratamiento(idTratamiento);
                String NombreTratamiento = rs.getString("t.Nombre");
                bean.setNombre_tratamiento(NombreTratamiento);
                String TipoTratamiento = rs.getString("TT.Descripcion");
                bean.setTipo_tratamiento(TipoTratamiento);
                double precio = rs.getDouble("T.Precio");
                bean.setPrecio_tratamiento(precio);
                obj_tratamiento.add(bean);
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
        return obj_tratamiento;
    }

    public Producto RegistroProducto(Producto prod) {
        Connection cn = null;
//        ResultSet rs = null;
        PreparedStatement ps = null;
//        Statement stmt = null;
            int CodeMedicamento = prod.getIdMedicamento();
            int CantidadIngreso = prod.getCantidadIngreso();
            int TipoPresentacion = prod.getIdTIpoPresentacion();
            int CantidadPresentacion = prod.getCantidadPresentacion();
            double PrecioUnidad = prod.getPrecioUnidad();
            double CantidadUM = prod.getCantidadMedida();
            int UnidadMedida = prod.getIdUnidadMedida();
            String FechaCaducidad = prod.getFechaCaducidad();
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String FechaIngreso=dateFormat.format(date);
//System.out.println("Fecha: "+dateFormat.format(date));
        try {
            String sql = "INSERT INTO `producto` "
                    + "(`idProducto`, `idMedicamento`, `Cantidad_ingreso_presentacion`, `Cantidad_Presentacion`, "
                    + "`idTipoPresentacion`, `Cantidad`, `PrecioUnidad`, `Cantidad_Medida`, `idUnidadMedidad`, "
                    + "`fecha_Ingreso`, `Fecha_Caducidad`)"
                    + " VALUES"
                    + " (NULL, '" + CodeMedicamento + "', '" + CantidadIngreso + "', '" + CantidadPresentacion + "',"
                    + " '" + TipoPresentacion + "', '" + CantidadIngreso + "', '" + PrecioUnidad + "', '" + CantidadUM + "', '" + UnidadMedida + "',"
                    + " '" + FechaIngreso + "', '" + FechaCaducidad + "')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            ps.execute();
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
        return prod;
    }
    
    public String RegistroMedicamento(String Nombre) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try {
            String sql = "INSERT INTO `medicamento` (`idMedicamento`, `Nombre`) VALUES (NULL, '" + Nombre + "')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            ps.execute();
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
        return Nombre;
    }

    public ArrayList<TratamientoStock> obtenerProductoStock() {
        ArrayList<TratamientoStock> obj_tratamiento = new ArrayList<TratamientoStock>();
        Statement stmt = null;
        String searchQuery
                = "SELECT"
                + " P.idProducto, M.Nombre, P.Cantidad_ingreso_presentacion, P.Cantidad_Presentacion,"
                + " TP.Nombre, P.Cantidad, P.PrecioUnidad, P.Cantidad_Medida, UM.Nombre, P.fecha_Ingreso,"
                + " P.Fecha_Caducidad"
                + " FROM producto P"
                + " INNER JOIN medicamento M ON M.idMedicamento=P.idMedicamento"
                + " INNER JOIN tipopresentacion TP ON TP.idTipoPresentacion=P.idTipoPresentacion"
                + " INNER JOIN unidadmedida UM ON UM.idUnidadMedida=P.idUnidadMedidad"
                + " WHERE P.Cantidad<>0";
        System.out.println(searchQuery);
        try {
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
                TratamientoStock bean = new TratamientoStock();
                int idProducto = Integer.parseInt(rs.getString("P.idProducto"));
                bean.setIdProducto(idProducto);
                String NombreMedicamento = rs.getString("M.Nombre");
                bean.setNombreMedicamento(NombreMedicamento);
                int CantidadIngreso = Integer.parseInt(rs.getString("P.Cantidad_ingreso_presentacion"));
                bean.setCantidad_ingreso_presentacion(CantidadIngreso);
                
                int Cantidad_Presentacion = Integer.parseInt(rs.getString("P.Cantidad_Presentacion"));
                bean.setCantidad_Presentacion(Cantidad_Presentacion);
                String TipoPresentacion = rs.getString("TP.Nombre");
//                bean.setTipoPresentacion(TipoPresentacion);
                
                bean.setTipoPresentacion("de " + Cantidad_Presentacion + " " + TipoPresentacion);
                
                int Cantidad = Integer.parseInt(rs.getString("P.Cantidad"));
                bean.setCantidad(Cantidad);
                double PrecioUnidad = Double.parseDouble(rs.getString("P.PrecioUnidad"));
                bean.setPrecio_tratamiento(PrecioUnidad);
                double Cantidad_Medida = Double.parseDouble(rs.getString("P.Cantidad_Medida"));
                bean.setCantidad_Medida(Cantidad_Medida);
                String UnidadMedida = rs.getString("UM.Nombre");
                
                bean.setUnidadMedidad(Cantidad_Medida + " " + UnidadMedida);
                
                String FechaIngreso = rs.getString("P.fecha_Ingreso");
                bean.setFecha_Ingreso(FechaIngreso);
                String FechaCaducidad = rs.getString("P.Fecha_Caducidad");
                bean.setFecha_Caducidad(FechaCaducidad);
                obj_tratamiento.add(bean);
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
        return obj_tratamiento;
    }

}
