/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import entidades.Venta;
import entidades.DetalleLaboratorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DaoLaboratorios;

/**
 *
 * @author ALESSO
 */
@WebServlet(name = "SeleccionarExamenPrecio", urlPatterns = {"/SeleccionarExamenPrecio"})
public class SeleccionarExamenPrecio extends HttpServlet {

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
            int idtipoexamen = Integer.parseInt(request.getParameter("idtipoexamen"));
            int Examen = Integer.parseInt(request.getParameter("Examen"));
//            String dniPac = request.getParameter("dniPac");

//            Venta venta = new Venta();
            DaoLaboratorios DaoRec=new DaoLaboratorios();
            ArrayList<DetalleLaboratorio> ListReceta = new ArrayList<DetalleLaboratorio>();
            ListReceta = DaoRec.obtenerExamenes(idtipoexamen,Examen);
            String json = new Gson().toJson(ListReceta);
            response.getWriter().write(json);
            
        } catch (Exception e) {
            System.err.println(e.toString());
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
