/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

/**
 *
 * @author Dell
 */
@WebServlet(name = "UsuarioRegistro", urlPatterns = {"/UsuarioRegistro"})
public class UsuarioRegistro extends HttpServlet {

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
        
        String nombre=request.getParameter("nombre");
        String apellidop=request.getParameter("apellidop");
        String apellidom=request.getParameter("apellidom");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String fechan=sdf.format(request.getParameter("fechanac"));
        String fechan="1990-12-12";
        
//        String fechaa=sdf.format(request.getParameter("fechanac"));
                
        String tipodocu=request.getParameter("tdoumento");
        String ndocu=request.getParameter("ndoumento");
        String ncelular=request.getParameter("ncelular");
        String direccion=request.getParameter("direccion");
        String distrito=request.getParameter("distrito");
        String provincia=request.getParameter("provincia");
        String departamento=request.getParameter("departamento");
        String correo=request.getParameter("correo");
        String contraseña=request.getParameter("contrasena");
        
        DaoUsuario objagregarpa = new DaoUsuario();
        persona objPersona = new persona(nombre, apellidop, apellidom, fechan, tipodocu, ndocu, direccion, distrito, provincia, departamento, correo, true);
//        telefono objtelefono = new telefono();
        objagregarpa.RegistroP(objPersona, contraseña, ncelular);
        
        response.sendRedirect("index.jsp");
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
