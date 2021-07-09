/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidades.Atencion;
import entidades.DetalleHistorial;
import entidades.DetalleReceta;
import entidades.Receta;
import modelo.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.persona;
import entidades.telefono;
import java.text.SimpleDateFormat;
import java.lang.reflect.*;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.DaoAtencion;
import modelo.DaoHistorial;
import modelo.DaoRecetas;

/**
 *
 * @author Dell
 */
@WebServlet(name = "RecetaAgregar", urlPatterns = {"/RecetaAgregar"})
public class RecetaAgregar extends HttpServlet {

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
            String idPaciente = request.getParameter("CodePac");
            String idDoctor = request.getParameter("CodeDoc");
            String CodeAnt = request.getParameter("CodeAtencio");
            String diagnostico = request.getParameter("diagnostico");
            String carritoRecetas = request.getParameter("carritoRecetas");
            Gson gson = new Gson();
            Type ListaDetalleReceta = new TypeToken<List<DetalleReceta>>() {
            }.getType();
            List<DetalleReceta> ItemsDetReceta = gson.fromJson(carritoRecetas, ListaDetalleReceta);
//            gson=carritoRecetas;
            SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hm = new SimpleDateFormat("HH:mm");            
            Date date = new Date();            
            String FechaAtencion = ymd.format(date);
            String HoraFin = hm.format(date);
            Atencion ate = new Atencion(Integer.parseInt(CodeAnt),FechaAtencion,HoraFin,diagnostico,"Confirmado");
            DaoAtencion objant = new DaoAtencion();
            String part1=objant.ActualizarAtencion(ate);
            
            
            Receta rec1 = new Receta(Integer.parseInt(idDoctor),Integer.parseInt(idPaciente),FechaAtencion,"Emitido");
            System.out.println(rec1);
            DaoRecetas objrec = new DaoRecetas();
            String part2=objrec.RecetaAgregar(rec1);
            
            for (int i = 0; i < ItemsDetReceta.size(); i++) {
//                ItemsDetReceta;
                String Descrip=(ItemsDetReceta.get(i).getDescripcion());
                int Cant=(ItemsDetReceta.get(i).getCantidad());
                String Obser=(ItemsDetReceta.get(i).getObservacion());
                String Est=(ItemsDetReceta.get(i).getEstado());
                DetalleReceta detrec = new DetalleReceta(Descrip,Cant,Obser,Est);
                objrec.DetalleRecetaAgregar(Integer.parseInt(idPaciente), Integer.parseInt(idDoctor), detrec);
                System.out.println(detrec.toString());
            }            
            DetalleHistorial dh = new DetalleHistorial(Integer.parseInt(idDoctor),diagnostico,FechaAtencion);
            DaoHistorial dah = new DaoHistorial();
            dah.DetalleHistorialAgregarReceta(Integer.parseInt(idDoctor),dh);
            HttpSession session= request.getSession(true);
            session.setAttribute("creado2", idPaciente);
            response.sendRedirect("principal.jsp");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

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
        System.out.println(response);
        System.out.println(request);
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
