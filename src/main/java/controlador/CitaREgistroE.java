/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DaoAtencion;
import modelo.Daodatos;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.detalleatencion;
import entidades.Atencion;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CitaREgistroE", urlPatterns = {"/CitaREgistroE"})
public class CitaREgistroE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int paciente= Integer.parseInt(request.getParameter("idper"));
            int especialidad=Integer.parseInt(request.getParameter("especialidad"));
            int doctor=Integer.parseInt(request.getParameter("doctor"));
            int local=Integer.parseInt(request.getParameter("idlocal"));
            Date fecha=Date.valueOf(request.getParameter("fecha"));
//            String hora_inicio=request.getParameter("hora_inicio");
            String hora_inicio=request.getParameter("hora_fin");

    //        String detalle=request.getParameter("detalle");
//            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            int idTipoAtencion = Integer.parseInt(request.getParameter("tatencion"));            
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            SimpleDateFormat hr = new SimpleDateFormat("hh:mm");
//            SimpleDateFormat da = new SimpleDateFormat("dd");
////            String Horas=hr.format(hora_fin);
//            SimpleDateFormat mi = new SimpleDateFormat("MM");
//            String dia=da.format(fecha);
//            String Mes=mi.format(fecha);
//            String fechaa=sdf.format(stamp);

//            String hora_inicio=request.getParameter("hora_fin");
        
            
            Daodatos d = new Daodatos();
            double Subtotal = d.obtenerCostoEspecialidad(especialidad);
            boolean Emergencia=false;
            
            DaoAtencion res=new DaoAtencion();
            Atencion a =new Atencion(local,doctor,paciente,idTipoAtencion,fecha,hora_inicio,Emergencia,"Reservado",Subtotal);

            res.RegistrarCita(a);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
//
//        
//        detalleatencion obcita = new detalleatencion(doctor, idpersona, fechaa, fecha, 0, 1, 0);
//        detalleatencion obdetcita = new detalleatencion(idTipoAtencion, local, hora_inicio, hora_fin);
//            detalleatencion obcitaEnf = new detalleatencion(79, idpersona, fechaa, fecha, 0, 1, 0);
//            detalleatencion obdetcitaEnf = new detalleatencion(idTipoAtencion, local, hora_inicio, hora_fin);
////        (NULL, (select MAX(a.idAtencion) from atencion a), "+idTipoAtencion+",'"+idLocal+"','',"+Hora_inicio+","+Hora_fin+",'101','activo')
//        DaoAtencion obregistrarCita = new DaoAtencion();
////aqui hacer el if para ver si es presencial o virtual
//
//        if (idTipoAtencion == 1) {
//
//            obregistrarCita.RegistroCita(obcita);
//            obregistrarCita.RegistroDetalleCita(obdetcita);
//            obregistrarCita.RegistroCita(obcitaEnf);
//            obregistrarCita.RegistroDetalleCita(obdetcitaEnf);
//        } else {
//            obregistrarCita.RegistroCita(obcita);
//            obregistrarCita.RegistroDetalleCita(obdetcita);
//        }


        response.sendRedirect("principal.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
