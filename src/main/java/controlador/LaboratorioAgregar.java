/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import entidades.DetalleLaboratorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.*;
import com.google.gson.reflect.TypeToken;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import modelo.DaoLaboratorios;
import entidades.Laboratorio;


/**
 *
 * @author ALESSO
 */
@WebServlet(name = "LaboratorioAgregar", urlPatterns = {"/LaboratorioAgregar"})
public class LaboratorioAgregar extends HttpServlet {

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
            String carritoLaboratorio = request.getParameter("sub");;
            Gson gson = new Gson();
            Type ListaDetalleLaboratorio = new TypeToken<List<DetalleLaboratorio>>() {
            }.getType();
            List<DetalleLaboratorio> ItemsDetLaboratorio = gson.fromJson(carritoLaboratorio, ListaDetalleLaboratorio);
//            gson=carritoRecetas;
            SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            String FechaAtencion = ymd.format(date);
            String HoraFin = hm.format(date);
            
            
            Laboratorio rec1 = new Laboratorio(Integer.parseInt(idDoctor),Integer.parseInt(idPaciente),FechaAtencion,"Espera");
            System.out.println(rec1);
            DaoLaboratorios objrec = new DaoLaboratorios();
//            String part2=objrec.LaboratorioAgregar(rec1); //esta crear cabecera
            double subTotal=0.0;
            for (int i = 0; i < ItemsDetLaboratorio.size(); i++) {
//                ItemsDetReceta;(int idExamen, String DesExamen, String FechaEntrega, String Estado)
                int idExamen=(ItemsDetLaboratorio.get(i).getIdExamen());
                subTotal=(ItemsDetLaboratorio.get(i).getPrecio())+subTotal;
                String Desc=(ItemsDetLaboratorio.get(i).getDesExamen());
                String Fecha=(ItemsDetLaboratorio.get(i).getFechaEntrega());
                String Est=(ItemsDetLaboratorio.get(i).getEstado());
                DetalleLaboratorio detrec = new DetalleLaboratorio(idExamen,Desc,Fecha,Est);
//                objrec.DetalleLaboratorioAgregar(Integer.parseInt(idPaciente), Integer.parseInt(idDoctor), detrec);
                System.out.println(detrec.toString());
            }            
//            subTotal;
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
