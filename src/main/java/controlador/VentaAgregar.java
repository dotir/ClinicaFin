/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import entidades.Atencion;
import entidades.DetalleVenta;
import entidades.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import modelo.DaoAtencion;
import modelo.DaoVentas;

/**
 *
 * @author ALESSO
 */
@WebServlet(name = "VentaAgregar", urlPatterns = {"/VentaAgregar"})
public class VentaAgregar extends HttpServlet {

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
            String idPaciente = request.getParameter("CodePac");
            String idDoctor = request.getParameter("CodeDoc");
//            String CodeAnt = request.getParameter("CodeAtencio");
//            String diagnostico = request.getParameter("diagnostico");
            String carritoRecetas = request.getParameter("sub");
            Gson gson = new Gson();
            Type ListaDetalleReceta = new TypeToken<List<DetalleVenta>>() {
            }.getType();
            List<DetalleVenta> ItemsDetReceta = gson.fromJson(carritoRecetas, ListaDetalleReceta);
//            gson=carritoRecetas;
            SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");      
            Date date = new Date();            
            String FechaAtencion = ymd.format(date);
            
            Venta vent = new Venta(Integer.parseInt(idPaciente),Integer.parseInt(idDoctor),FechaAtencion);
            System.out.println(vent);
            DaoVentas objvent = new DaoVentas();
            
            String part2=objvent.VentaAgregar(vent);
            double Subtotal=0.0;
            
            for (int i = 0; i < ItemsDetReceta.size(); i++) {
//                ItemsDetReceta;
                double Precio=0.0;
                int idProducto=(ItemsDetReceta.get(i).getProducto());
                int Cant=(ItemsDetReceta.get(i).getCantidad());
                Precio=((ItemsDetReceta.get(i).getPrecio())*(ItemsDetReceta.get(i).getCantidad()));
                Subtotal = Subtotal+Precio;
                DetalleVenta detrec = new DetalleVenta(idProducto,Cant);                
                objvent.VentaActulizarProducto(detrec);
                objvent.DetalleVentaAgregar(Integer.parseInt(idDoctor), Integer.parseInt(idPaciente), detrec);
                System.out.println(detrec.toString());
            }
            double IGV = (Subtotal*0.18);
            double Total = Subtotal+IGV;
            HttpSession session= request.getSession(true);
            session.setAttribute("creado1", idPaciente);
            response.sendRedirect("principal.jsp");
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
