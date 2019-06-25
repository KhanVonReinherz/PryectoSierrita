
package pe.kamwha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.kamwha.model.BoletaModel;
import pe.kamwha.model.ClienteModel;
import pe.kamwha.model.MenuModel;
import pe.kamwha.service.VentaService;


@WebServlet(name = "VenderController", urlPatterns = {"/VenderController","/VenderCarrito"})
public class VenderController extends HttpServlet {

    VentaService ventaService;
    
    @Override
    public void init() throws ServletException {

        ventaService = new VentaService();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String idCliente = request.getParameter("ClienteID");
        List<MenuModel> carro = (List)sesion.getAttribute("carro");
        
        ClienteModel bean = new ClienteModel();
        bean.setClienteID(idCliente);
        
        BoletaModel boleta = ventaService.insertarVenta(bean, carro);
        
        sesion.removeAttribute("carro");
        request.setAttribute("venta", boleta);
        RequestDispatcher despachador = getServletContext().getRequestDispatcher("/venta.jsp");
        despachador.forward(request, response);
    }

    
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
