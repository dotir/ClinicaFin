/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import entidades.DetalleLaboratorio;
import entidades.Laboratorio;
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
public class DaoLaboratorios {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
     //obtener todos los medicamentos
    public ArrayList<DetalleLaboratorio> obtenerExamenes(int Examen, int TipoExamen) {
        ArrayList<DetalleLaboratorio> obj = new ArrayList<DetalleLaboratorio>();
        Statement stmt = null;
        String searchQuery
                = "SELECT E.idExamen, TE.Descripcion,E.Descripcion,E.Precio FROM examen E INNER JOIN tipoexamen TE ON TE.idTipoExamen=E.idTipoExamen WHERE TE.idTipoExamen= '"+Examen+"' AND E.idExamen='"+TipoExamen+"'";
        System.out.println(searchQuery);
        try {
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
                DetalleLaboratorio bean = new DetalleLaboratorio();
                int idExamen  = Integer.parseInt(rs.getString("E.idExamen"));
                bean.setIdExamen(idExamen);
                String NombreExamen = rs.getString("TE.Descripcion");
                String TipoNombreExamen = rs.getString("E.Descripcion");
                bean.setExamen(NombreExamen + " " + TipoNombreExamen);
                double precio = rs.getDouble("E.Precio");
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

    public String LaboratorioAgregar(Laboratorio bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int idDoctor = bean.getIdUProfesionalClinica();
            int idPaciente = bean.getIdUPaciente();
            String Fecha = bean.getFecha();
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `laboratorio` (`idLaboratorio`, `idUProfesionalClinica`, `idUPaciente`, `Fecha`, `Estado`) VALUES (NULL, '" + idDoctor + "', '" + idPaciente + "', '" + Fecha + "', 'Espera')";
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
            Respond = "Receta Agregada";
        } else {
            Respond = "Receta No Agregada";
        }
        return Respond;
    }
//  
    public DetalleLaboratorio DetalleLaboratorioAgregar(int idUP, int idUD, DetalleLaboratorio bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try
        {
            int idExamen=bean.getIdExamen();
            String sql="INSERT INTO `detallelavoratorio` (`idDetalleLab`, `idLaboratorio`, `idExamen`, `Resultado`, `FechaEntrega`, `Estado`) VALUES (NULL, (SELECT MAX(L.idLaboratorio) FROM laboratorio L WHERE L.idUProfesionalClinica='"+ idUD +"' AND L.idUPaciente='" + idUP + "'), '"+ idExamen +"', '', '', 'Espera')";
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
