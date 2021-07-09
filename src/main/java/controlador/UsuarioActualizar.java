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
import entidades.usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "UsuarioActualizar", urlPatterns = {"/UsuarioActualizar"})
public class UsuarioActualizar extends HttpServlet {

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
        int idperson=Integer.parseInt(request.getParameter("idpersona"));
        String nombre=request.getParameter("nombre");
        String apellidop=request.getParameter("apellidop");
        String apellidom=request.getParameter("apellidom");
        String fechan=request.getParameter("fechanac");
        String tipodocu=request.getParameter("tdoumento");
        String ndocu=request.getParameter("ndoumento");
        String ncelular=request.getParameter("ncelular");
        String direccion=request.getParameter("direccion");
        String distrito=request.getParameter("distrito");
        String provincia=request.getParameter("provincia");
        String departamento=request.getParameter("departamento");
        String correo=request.getParameter("correo");
        String contrasena=request.getParameter("contrasena");
        String Confircontrasena=request.getParameter("Confircontrasena");
        if(contrasena==Confircontrasena){
            contrasena=Confircontrasena;
        }
        DaoUsuario objagregarpa= new DaoUsuario();
        persona objPersona = new persona(idperson,nombre,apellidop,apellidom,direccion,correo);
        objagregarpa.ActualizarU(objPersona, contrasena, ncelular);
        HttpSession session= request.getSession(true);
        session.setAttribute("creado", nombre);
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
