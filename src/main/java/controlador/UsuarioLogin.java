/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DaoAdmin;
import modelo.DaoUsuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.persona;
import entidades.telefono;
import entidades.usuario;
import static java.lang.System.out;

@WebServlet(name = "UsuarioLogin", urlPatterns = {"/UsuarioLogin"})
public class UsuarioLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usuario= request.getParameter("usuario").trim();
        String pass= request.getParameter("password").trim();
        //
        //acceso a dotos
        DaoUsuario usuariologin = new DaoUsuario();

        //modelos
        persona objpersona = new persona();
        telefono objtelefono = new telefono();
        usuario objusuario= new usuario();
        //obtiene la clase persona y valida el login
        objpersona=usuariologin.login(usuario,pass);
        //obtiene telefono y contra
        objtelefono=usuariologin.obtenerTelefono(objpersona.getIdPersona());
        objusuario=usuariologin.obtenerContrasena(usuario);
        //numero valida
        String numero=objpersona.getNroDocumento();
        //validador
        //////////////////////////////////////////
        objusuario.setNombre(usuario);
        objusuario.setContraseña(pass);            
       
        
        ///////////////////////////////////////////////
        if (numero.equals(usuario)) {
             //session persona
            HttpSession session= request.getSession(true);

            session.setAttribute("datospersona", objpersona);
            //sesion telefono y contrasena
            session.setAttribute("datostelefono", objtelefono);
            session.setAttribute("datoscontrasena", objusuario);
            response.getWriter().write("True");
//            response.sendRedirect("principal.jsp");
            
        }
        else{
            response.getWriter().write("False");
//            response.sendRedirect("index.jsp");
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
