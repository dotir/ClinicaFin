/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Producto;
import modelo.DaoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.TratamientoStock;
import entidades.telefono;
import entidades.usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "StockRegistrar", urlPatterns = {"/StockRegistrar"})
public class StockRegistrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet responsex
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int CodeMedicamento = Integer.parseInt(request.getParameter("medicamento"));
            int CantidadIngreso = Integer.parseInt(request.getParameter("Cantidad_Ingreso"));
            int TipoPresentacion = Integer.parseInt(request.getParameter("TipoPresentacion"));
            int CantidadPresentacion = Integer.parseInt(request.getParameter("Cantidad_Presentacion"));
            double PrecioUnidad = Double.parseDouble(request.getParameter("PrecioUnidad"));
            double CantidadUM = Double.parseDouble(request.getParameter("CantidadUM"));
            int UnidadMedida = Integer.parseInt(request.getParameter("UnidadMedida"));
            String FechaCaducidad = request.getParameter("FechaCaducidad");
//            HttpSession sessionIdTrata = request.getSession(true);
//            sessionIdTrata.setAttribute("CodeTratamiento", CodeTratamiento);
//            HttpSession sessionNombreTrata = request.getSession(true);
//            sessionNombreTrata.setAttribute("NombreTratamiento", NombreTratamiento);
            Producto obj = new Producto(CodeMedicamento,CantidadIngreso,CantidadPresentacion,TipoPresentacion,PrecioUnidad,CantidadUM,UnidadMedida,FechaCaducidad);
            DaoProducto prod=new DaoProducto();
            prod.RegistroProducto(obj);
            HttpSession session= request.getSession(true);
            session.setAttribute("creado", CodeMedicamento);

            response.sendRedirect("bmedicamento.jsp");

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
