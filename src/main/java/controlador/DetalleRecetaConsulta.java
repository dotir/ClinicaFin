/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import entidades.Receta;
import entidades.DetalleReceta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DaoRecetas;

/**
 *
 * @author ALESSO
 */
@WebServlet(name = "DetalleRecetaConsulta", urlPatterns = {"/DetalleRecetaConsulta"})
public class DetalleRecetaConsulta extends HttpServlet {

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
            String CodeRec = request.getParameter("CodeRec");
            String NombrePac = request.getParameter("NombrePac");
            String idUPaciente = request.getParameter("idUPaciente");
            String Inter = request.getParameter("Inter");
//            Receta rec = new Receta(CodeRec,NombrePac);
//            DaoRecetas DaoRec=new DaoRecetas();
//            ArrayList<DetalleReceta> ListReceta = new ArrayList<DetalleReceta>();
//            ListReceta = DaoRec.obtenerDetalleRecetasVentas(CodeRec);
//            String json = new Gson().toJson(ListReceta);
            HttpSession session = request.getSession(true);
            session.setAttribute("CodeRec", CodeRec);
            session.setAttribute("NombrePac", NombrePac);
            session.setAttribute("idUPaciente", idUPaciente);
            if ("1".equals(Inter)) {
                response.sendRedirect("rdetlaboratorio.jsp");
            } else {
                response.sendRedirect("rdetventa.jsp");
            }

//            response.getWriter().write(json);
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
