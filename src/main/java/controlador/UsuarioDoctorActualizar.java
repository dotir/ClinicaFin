/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.doctor;
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
import modelo.DaoDoctor;

/**
 *
 * @author Dell
 */
@WebServlet(name = "UsuarioDoctorActualizar", urlPatterns = {"/UsuarioDoctorActualizar"})
public class UsuarioDoctorActualizar extends HttpServlet {

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
        String idperson=request.getParameter("idpersona");
        String idDoctor=request.getParameter("idDoctor");
        String nombre=request.getParameter("nombre");
        String apellidop=request.getParameter("apellidosP");
        String apellidom=request.getParameter("apellidoM");
        String dni=request.getParameter("dni");
        String fecha_nacimiento=request.getParameter("fecha_nacimiento");
        String correo=request.getParameter("correo");
        String especialidad =request.getParameter("idEspcialidad");
        String detalle =request.getParameter("detalle");
        DaoDoctor objagregarpa= new DaoDoctor();
        doctor objDoctor = new doctor(idDoctor,nombre,apellidop,apellidom,dni,fecha_nacimiento,correo,especialidad,detalle);
        objagregarpa.ActualizarDoctor(objDoctor);
        
//        String idDoctor, String nombre, String apellidosP, String apellidoM, String dni, String fecha_nacimiento, String correo, String especialidad, String detalle
//        String tipodocu=request.getParameter("tdoumento");
//        String ndocu=request.getParameter("ndoumento");
//        String ncelular=request.getParameter("ncelular");
//        String direccion=request.getParameter("direccion");
//        String distrito=request.getParameter("distrito");
//        String provincia=request.getParameter("provincia");
//        String departamento=request.getParameter("departamento");
//        String correo=request.getParameter("correo");
//        String contraseña=request.getParameter("contrasena");
//        
//        DaoUsuario objagregarpa= new DaoUsuario();
//        persona objPersona = new persona(idperson,nombre,apellidop,apellidom,fechan,tipodocu,ndocu,direccion,correo,true);
//        objagregarpa.ActualizarU(objPersona, contraseña, ncelular);
        
        response.sendRedirect("bdoctor.jsp");
        
        
        
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
