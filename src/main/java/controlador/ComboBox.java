/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DaoDirecciones;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ComboBox", urlPatterns = {"/ComboBox"})
public class ComboBox extends HttpServlet {

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
        DaoDirecciones csd = new DaoDirecciones();

        String op = request.getParameter("operation");

        if (op.equals("ubdepartamento")) {
            ArrayList<String> clist = csd.obtenerProvincia();
            Gson json = new Gson();
            String DepartamentoList = json.toJson(clist);
            response.getWriter().write(DepartamentoList);
        }
//
//            if (op.equals("ubprovincia")) {
//                int id = Integer.parseInt(request.getParameter("id"));
//                ArrayList<String> slist = csd.obtenerProvincia_Dep(id);
//                Gson json = new Gson();
//                String ProvinciaList = json.toJson(slist);
//                response.setContentType("text/html");
//                response.getWriter().write(ProvinciaList);
//            }
//
//            if (op.equals("ubdistrito")) {
//                int id = Integer.parseInt(request.getParameter("id"));
//                ArrayList<String> citylist = csd.obtenerDistrito_pro(id);
//                Gson json = new Gson();
//                String DistritoList = json.toJson(citylist);
//                response.setContentType("text/html");
//                response.getWriter().write(DistritoList);
//            }
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
