/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.kamwha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.kamwha.model.ClienteModel;
import pe.kamwha.model.MesaModel;
import pe.kamwha.model.ReservaModel;
import pe.kamwha.service.ReservaService;
import pe.kamwha.util.CorreoUtil;
import pe.kamwha.dao.impl.ReservaDaoImpl;

@WebServlet(name = "ReservaService", urlPatterns = {"/ReservaService", "/AgregarReserva"})
public class ReservaController extends HttpServlet {

    ReservaService reservaService;

    @Override
    public void init() throws ServletException {

        reservaService = new ReservaService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/AgregarReserva":
                realizarReserva(request, response);
                System.out.println("Entro a ReservaController(Agregrar Reserva)");
                break;
        }
    }

    private void realizarReserva(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoReserva = reservaService.generarCodigo();
        String codigoCliente = request.getParameter("txtCod");
        int codigoMesa = Integer.parseInt(request.getParameter("cbxMesa"));
        String fecha = request.getParameter("filter-date");
        String status = "RESERVADO";
        
        String destino = "";
        if (codigoReserva != null && codigoCliente != null && codigoMesa != 0 && fecha != null && status != null) {
            MesaModel beanMesa = new MesaModel();
            beanMesa.setMesaNro(codigoMesa);
            ClienteModel beanCliente = new ClienteModel();
            beanCliente.setClienteID(codigoCliente);
            ReservaModel beanReserva = new ReservaModel();
            beanReserva.setReservaID(codigoReserva);
            beanReserva.setCliente(beanCliente);
            beanReserva.setMesa(beanMesa);
            beanReserva.setReservafecha(fecha);
            beanReserva.setReservaStatus(status);
            
            int rows = reservaService.validarReserva(beanReserva);
            
            if(rows == 0){
                reservaService.insertar(beanReserva);
                ReservaModel reservaCorreo = reservaService.enviarCorreoCliente(beanReserva);
                CorreoUtil correoReserva = new CorreoUtil();
                correoReserva.enviarCorreo(reservaCorreo);
                
                System.out.println("Se inserto la reserva");
                destino = "/index.jsp";
            }else{
                System.out.println("Ya hay reserva para esa mesa ese dia y hora");
                destino = "/Login.jsp";
            }
            
            
        } else{
            System.out.println("Error en la fecha lo mas probables :'v");
            destino = "/Login.jsp";
        }
        
        ControllerUtil.forward(request, response, destino);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
