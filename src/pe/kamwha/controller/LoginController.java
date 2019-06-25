
package pe.kamwha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.kamwha.model.ClienteModel;
import pe.kamwha.model.EmpleadoModel;
import pe.kamwha.model.GerenteModel;
import pe.kamwha.service.ClienteService;
import pe.kamwha.service.EmpleadoServices;
import pe.kamwha.service.GerenteService;


@WebServlet(name = "LoginController", urlPatterns = {"/LoginController","/LoginGeneral","/LogonSalirCliente"})
public class LoginController extends HttpServlet {

    
    ClienteService clienteService;
    GerenteService gerenteService;
    EmpleadoServices  empleadoServices;
    
    @Override
    public void init()throws ServletException{
        
        clienteService = new ClienteService();
        gerenteService = new GerenteService();
        empleadoServices = new EmpleadoServices();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getServletPath()){
            case "/LoginGeneral":
                ingresarGeneral(request,response);
                System.out.println("Entre a LoginController (LoginGeneral)");
                break;
             
            case "/LogonSalirCliente":
                salirCliente(request,response);
                System.out.println("Entre a LoginController(SalirCliente)");
                break;
            
        }
    }

    private void ingresarGeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String destino = "";
        try{
            String email = request.getParameter("loginemail");
            String contrasenia = request.getParameter("loginPassword");
            
            ClienteModel beanCliente = new ClienteModel();
            beanCliente.setClienteEmail(email);
            beanCliente.setClienteContrasena(contrasenia);
            
            GerenteModel beanGerente = new GerenteModel();
            beanGerente.setGerenteEmail(email);
            beanGerente.setGerenteContrasena(contrasenia);
            
            EmpleadoModel beanEmpleado = new EmpleadoModel();
            beanEmpleado.setEmpleadoEmail(email);
            beanEmpleado.setEmpleadoContrasena(contrasenia);
            
            
            ClienteModel beanClienteVali = clienteService.validar(beanCliente);
            GerenteModel beanGerenteVali = gerenteService.validar(beanGerente);
            EmpleadoModel beanEmpleadoVali = empleadoServices.validar(beanEmpleado);
            
            if(beanClienteVali != null && beanGerenteVali == null && beanEmpleadoVali == null){
                ControllerUtil.sessionPut(request, "cliente", beanClienteVali);
            
                destino = "/index.jsp";
                System.out.println("Ingreso EXITOSO CLIENTE");
            }
            
            if(beanClienteVali == null && beanGerenteVali != null && beanEmpleadoVali == null){
                ControllerUtil.sessionPut(request, "gerente", beanGerenteVali);
            
                destino = "/index.jsp";
                System.out.println("Ingreso EXITOSO GERENTE");
            }
            
            if(beanClienteVali == null && beanGerenteVali == null && beanEmpleadoVali != null){
                ControllerUtil.sessionPut(request, "empleado", beanEmpleadoVali);
            
                destino = "/index.jsp";
                System.out.println("Ingreso EXITOSO GERENTE");
            }
            
        } catch(Exception e){
            request.setAttribute("error", e.getMessage());
            destino =  "/Login.jsp";
            System.out.println("Ingreso FALLIDO LOGIN");
        }
        
        ControllerUtil.forward(request, response, destino);
    }
    
    private void salirCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        ControllerUtil.forward(request, response, "index.jsp");
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
