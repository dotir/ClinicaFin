/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.AtencionPersona;
import entidades.doctor;
import modelo.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DaoAtencion;
//import entidades.persona;
//import entidades.telefono;
//import entidades.usuario;
//import modelo.DaoDoctor;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CitaActualizarDoc", urlPatterns = {"/CitaActualizarDoc"})
public class CitaActualizarDoc extends HttpServlet {

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
        String idAtencion=request.getParameter("idAtencion");
        String idUsuarioCliente=request.getParameter("idUsuarioCliente");
        
        Date Hora = new Date();
        String strDateFormat = "hh: mm: ss";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
//        System.out.println(objSDF.format(Hora));
        
        String Detalle=request.getParameter("Detalle");
        String HoraInicio=objSDF.format(Hora);
        String HoraFin=objSDF.format(Hora);
//        String HoraInicio=request.getParameter("HoraInicio");
//        String HoraFin=request.getParameter("HoraFin");
        String Estado=request.getParameter("Estado");
        
        
        DaoAtencion objAgregarAtenDet= new DaoAtencion();
        AtencionPersona objAtenDeta = new AtencionPersona(Integer.parseInt(idAtencion),Integer.parseInt(idperson),Detalle,HoraInicio,HoraFin,Estado);
        objAgregarAtenDet.ActualizarAtencionDetalle(objAtenDeta);
        
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
        
        response.sendRedirect("bcita.jsp");
        
        
        
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
