
package pe.kamwha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.kamwha.model.EmpleadoModel;
import pe.kamwha.service.EmpleadoServices;


@WebServlet(name = "EmpleadoController", urlPatterns = {"/EmpleadoController","/LoginEmpleado"})
public class EmpleadoController extends HttpServlet {
    
    EmpleadoServices empleadoService;
    
    @Override
    public void init()throws ServletException{
        
        empleadoService = new EmpleadoServices();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getServletPath()){
            case "/LoginEmpleado":
                crearNuevoEmpleado(request, response);
                System.out.println("Ingresar GERENTE CONTROLLER (CrearGerente");
                break;
        }
    }

     private void crearNuevoEmpleado(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String codigo = "";
        
        String contrasenia = "";
        try{
            codigo = empleadoService.generarCodigo();
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
                response.sendRedirect("/loginEmpleado.jsp");
                
            } 
            
            EmpleadoModel bean = new EmpleadoModel();
            bean.setEmpleadoID(codigo);
            bean.setEmpleadoNombres(nombre);
            bean.setEmpleadoApePaterno(apePater);
            bean.setEmpleadoApeMaterno(apeMater);
            bean.setEmpleadoDni(dni);
            bean.setEmpleadoEmail(email);
            bean.setEmpleadoTelefono(telefono);
            bean.setEmpleadoActivo("A");
            bean.setEmpleadoContrasena(contrasenia);
                
            empleadoService.insertar(bean);
                  
            request.getRequestDispatcher("/loginEmpleado.jsp").forward(request, response);
        } catch(Exception ex){
            System.out.println("Error DE REGISTRAR CLIENTE: " + ex);
            response.sendRedirect("/loginEmpleado.jsp");
        }
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
