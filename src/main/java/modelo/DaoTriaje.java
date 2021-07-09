/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Triaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ALESSO
 */
public class DaoTriaje {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    public String TriajeAgregar(Triaje bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        String Respond = "";
        boolean a=false;
        try {
            int idDoctor = bean.getIdUProfesionalClinica();
            String Fecha = bean.getFecha();
            String hora = bean.getHora();
            String Edad = bean.getEdad();
            String Peso = bean.getPeso();
            String Sintomas = bean.getSintomas();
            String TensionArterial = bean.getTensionArterial();
            String FrecuenciaCardiaca = bean.getFrecuenciaCardiaca();
            String Temperatura = bean.getTemperatura();
            String SaturacionOxigeno = bean.getSaturacionOxigeno();
            String PatologiaPrevia = bean.getPatologiaPrevia();
            
//            String Estado1 = "Emitida";
//            select da.idDetalleAtencion from detalleatencion da where da.idAtencion=1
            String sql = "INSERT INTO `triage`"
                    + " (`idTriage`, `idUProfesionalClinica`, `Fecha`, `Hora`, `Edad`,"
                    + " `Peso`, `Sintomas`, `TensionArterial`, `FrecuenciaCardiaca`,"
                    + " `Temperatura`, `SaturacionOxigeno`, `PatologiaPrevia`)"
                    + " VALUES"
                    + " (NULL, '"+idDoctor+"', '"+Fecha+"', '"+hora+"', '"+Edad+"',"
                    + " '"+Peso+"', '"+Sintomas+"', '"+TensionArterial+"', '"+FrecuenciaCardiaca+"',"
                    + " '"+Temperatura+"', '"+SaturacionOxigeno+"', '"+PatologiaPrevia+"')";
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
//   SELECT T.idTriage, P.Nombre,P.ApellidoPaterno,P.ApellidoMaterno,T.Edad,T.Peso,T.Sintomas  FROM triage T INNER JOIN historialclinico HC ON T.idTriage=HC.idTriage INNER JOIN PERSONA P ON P.idPersona=HC.idUPaciente
    public ArrayList<Triaje> obtenerTriaje() {
        ArrayList<Triaje> obj_paciente = new ArrayList<Triaje>();
        Statement stmt = null;

        String searchQuery
                = "SELECT T.idTriage, P.Nombre,P.ApellidoPaterno,P.ApellidoMaterno,T.Edad,T.Peso,T.Sintomas, T.Fecha FROM triage T INNER JOIN historialclinico HC ON T.idTriage=HC.idTriage INNER JOIN PERSONA P ON P.idPersona=HC.idUPaciente";
//                "SELECT * FROM persona p INNER JOIN especialidad e ON p.idEspecialidad = e.idEspecialidad WHERE idTipoPersona = 3 ";

        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                Triaje bean = new Triaje();

                String idTriaje = rs.getString("T.idTriage");
                bean.setIdTriaje(Integer.parseInt(idTriaje));

                String Nombre = rs.getString("P.Nombre");
                String ApellidoPaterno = rs.getString("P.ApellidoPaterno");
                String ApellidoMaterno = rs.getString("P.ApellidoMaterno");
                bean.setNombrePac(ApellidoPaterno+ " " + ApellidoMaterno + ", " +Nombre);
                String Edad = rs.getString("T.Edad");
                bean.setEdad(Edad);
                String Peso = rs.getString("T.Peso");
                bean.setPeso(Peso);
                String Sintomas = rs.getString("T.Sintomas");
                bean.setSintomas(Sintomas);

                String Fecha = rs.getString("T.Fecha");
                bean.setFecha(Fecha);

                obj_paciente.add(bean);
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
        return obj_paciente;
    }
    
    
}
