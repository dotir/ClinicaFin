/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.DetalleHistorial;
import entidades.HistorialClinico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ALESSO
 */
public class DaoHistorial {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    public String HistorialAgregar(HistorialClinico bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int IdUPaciente = bean.getIdUPaciente();
            String Fecha = bean.getFecha();
            
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `historialclinico` (`idHistorial`, `idUPaciente`, `idTriage`, `Fecha`) VALUES (NULL, '"+IdUPaciente+"', (SELECT MAX(T.idTriage) FROM TRIAGE T), '"+Fecha+"')";
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
            Respond = "TRiaje Agregada";
        } else {
            Respond = "Triaje No Agregada";
        }
        return Respond;
    }
//   
    
    public String DetalleHistorialAgregarReceta(int hc,DetalleHistorial bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int IdUPaciente = hc;
            String Diagnostico = bean.getDiagnostico();
            int Espacialidad = bean.getEspecialidad();
            String Fecha = bean.getFecha();
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `detallehistorial`"
                    + " (`idDetalleHistorial`, `idHistorial`, `Especialidad`,"
                    + " `Diagnostico`, `Examenes`, `Receta`, `Fecha`)"
                    + " VALUES"
                    + " ('', '(SELECT MAX(H.idHistorial) FROM historialclinico H WHERE H.idUPaciente='"+IdUPaciente+"')', (SELECT P.idEspecialidad FROM persona P WHERE P.idPersona='"+Espacialidad+"'),"
                    + " '"+Diagnostico+"', '', '(SELECT MAX(R.idReceta) FROM receta R)', '"+Fecha+"')";
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
            Respond = "TRiaje Agregada";
        } else {
            Respond = "Triaje No Agregada";
        }
        return Respond;
    }
//   
    
}
