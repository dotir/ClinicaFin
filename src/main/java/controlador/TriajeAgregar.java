/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.HistorialClinico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Triaje;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import modelo.DaoHistorial;
import modelo.DaoTriaje;

/**
 *
 * @author ALESSO
 */
@WebServlet(name = "TriajeAgregar", urlPatterns = {"/TriajeAgregar"})
public class TriajeAgregar extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            String idPersona = request.getParameter("idPersona123");
            String idPClinica = request.getParameter("idPClinica12");
            String Edad = request.getParameter("Edad");
            String Peso = request.getParameter("Peso");
            String Sintomas = request.getParameter("Sintomas");
            String TensionArterial = request.getParameter("TensionArterial");
            String FrecuenciaCardiaca = request.getParameter("FrecuenciaCardiaca");
            String Temperatura = request.getParameter("Temperatura");
            String SaturacionDeOxigeno = request.getParameter("SaturacionDeOxigeno");
            String PatologiaPrevia = request.getParameter("PatologiaPrevia");
            SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            String FechaAtencion = ymd.format(date);
            String HoraFin = hm.format(date);
            Triaje tri = new Triaje(Integer.parseInt(idPClinica),FechaAtencion,HoraFin,Edad,Peso,Sintomas,TensionArterial,FrecuenciaCardiaca,Temperatura,SaturacionDeOxigeno,PatologiaPrevia);
            DaoTriaje dt = new DaoTriaje();
            dt.TriajeAgregar(tri);
            DaoHistorial dh = new DaoHistorial();
            HistorialClinico hc= new HistorialClinico(Integer.parseInt(idPersona),FechaAtencion);
            dh.HistorialAgregar(hc);
            HttpSession session= request.getSession(true);
            session.setAttribute("creado", idPersona);
            response.sendRedirect("principal.jsp");

//                int idUProfesionalClinica, String Fecha, String Hora, String Edad, String Peso, String Sintomas, String TensionArterial, String FrecuenciaCardiaca, String Temperatura, String SaturacionOxigeno, String PatologiaPrevia

        } catch (Exception e) {
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
