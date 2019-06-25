
package pe.kamwha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.kamwha.model.ClienteModel;
import pe.kamwha.service.ClienteService;


@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController","/CrearCliente"})
public class ClienteController extends HttpServlet {

   ClienteService clienteService;
    
    @Override
    public void init()throws ServletException{
        
        clienteService = new ClienteService();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getServletPath()){
            case "/CrearCliente":
                crearNuevoCliente(request, response);
                System.out.println("Ingresar CLIENTE CONTROLLER (CrearCliente");
                break;
        }
    }

    private void crearNuevoCliente(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String codigo = "";
        
        String contrasenia = "";
        try{
            codigo = clienteService.generarCodigo();
            String nombre = request.getParameter("name");
            String apePater = request.getParameter("surnamepaterno");
            String apeMater = request.getParameter("surnamematerno");
            String dni = request.getParameter("dni");
            String email = request.getParameter("emailAdress");
            String telefono = request.getParameter("phone");

            if(request.getParameter("password").equals(request.getParameter("passwordCon"))){
                contrasenia = request.getParameter("password");
            }

            System.out.println(nombre);
            System.out.println(apePater);
            System.out.println(apeMater);
            System.out.println(dni);
            System.out.println(email);
            System.out.println(telefono);
            System.out.println(contrasenia);
        
            
            if(codigo.isEmpty() || nombre.isEmpty() || apePater.isEmpty() || apeMater.isEmpty() || dni.isEmpty() || email.isEmpty() || 
                    telefono.isEmpty() || contrasenia.isEmpty()){
                System.out.println("ERROR en INSERTAR PAPRAMETROS VACIOS: "  );
                response.sendRedirect("/Login.jsp");
                
            } 
            
            ClienteModel bean = new ClienteModel();
            bean.setClienteID(codigo);
            bean.setClienteNombres(nombre);
            bean.setClienteApePaterno(apePater);
            bean.setClienteApeMaterno(apeMater);
            bean.setClienteDni(dni);
            bean.setClienteEmail(email);
            bean.setClienteTelefono(telefono);
            bean.setClienteActivo("A");
            bean.setClienteContrasena(contrasenia);
                
            clienteService.insertar(bean);
                  
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        } catch(Exception ex){
            System.out.println("Error DE REGISTRAR CLIENTE: " + ex);
            response.sendRedirect("/Login.jsp");
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
