
package pe.kamwha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.kamwha.model.GerenteModel;
import pe.kamwha.service.GerenteService;


@WebServlet(name = "GerenteController", urlPatterns = {"/GerenteController","/LoginGerente"})
public class GerenteController extends HttpServlet {

    GerenteService gerenteService;
    
    @Override
    public void init()throws ServletException{
        
        gerenteService = new GerenteService();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getServletPath()){
            case "/LoginGerente":
                crearNuevoGerente(request, response);
                System.out.println("Ingresar GERENTE CONTROLLER (CrearGerente");
                break;
        }
    }

    private void crearNuevoGerente(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String codigo = "";
        
        String contrasenia = "";
        try{
            codigo = gerenteService.generarCodigo();
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
                response.sendRedirect("/loginGerente.jsp");
                
            } 
            
            GerenteModel bean = new GerenteModel();
            bean.setGerenteID(codigo);
            bean.setGerenteNombres(nombre);
            bean.setGerenteApePaterno(apePater);
            bean.setGerenteApeMaterno(apeMater);
            bean.setGerenteDni(dni);
            bean.setGerenteEmail(email);
            bean.setGerenteTelefono(telefono);
            bean.setGerenteActivo("A");
            bean.setGerenteContrasena(contrasenia);
                
            gerenteService.insertar(bean);
                  
            request.getRequestDispatcher("/loginGerente.jsp").forward(request, response);
        } catch(Exception ex){
            System.out.println("Error DE REGISTRAR CLIENTE: " + ex);
            response.sendRedirect("/loginGerente.jsp");
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
