
package pe.kamwha.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.kamwha.model.MenuModel;
import pe.kamwha.service.MenuService;


@WebServlet(name = "CompraController", urlPatterns = {"/CompraController", "/AgregarCompra"})
public class CompraController extends HttpServlet {
    
    MenuService menuService;
    
    @Override
    public void init() throws ServletException {

        menuService = new MenuService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        String menuID = request.getParameter("id");
        
        MenuModel menuModel = new MenuModel();
        menuModel.setMenuID(menuID);
        
        MenuModel bean = menuService.obtenerporID(menuModel);
        
        List<MenuModel> carro = (List)sesion.getAttribute("carro");
        
        if(carro == null){
            carro = new ArrayList<MenuModel>();
        }
        
        carro.add(bean);
        
        sesion.setAttribute("carro", carro);
        RequestDispatcher despachador = getServletContext().getRequestDispatcher("/carro.jsp");
        despachador.forward(request, response);
        
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
