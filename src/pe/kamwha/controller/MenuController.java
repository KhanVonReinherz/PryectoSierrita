package pe.kamwha.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pe.kamwha.model.CategoriaModel;
import pe.kamwha.model.MenuModel;
import pe.kamwha.service.MenuService;
import pe.kamwha.util.ImagenUtil;

@WebServlet(name = "MenuController", urlPatterns = {"/MenuController", "/AgregarProducto","/ListarPorCategoria","/ImagenMenu","/editarMenu","/ActualizarProducto"})
@MultipartConfig(maxFileSize = 16177215)
public class MenuController extends HttpServlet {

    MenuService menuService;

    @Override
    public void init() throws ServletException {

        menuService = new MenuService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getServletPath()) {
            
            case "/AgregarProducto":
                agregarProducto(request, response);
                System.out.println("Entro Para agregar producto");
                break;
            case "/ListarPorCategoria":
                listarPorCategoria(request, response);
                break;
            case "/ImagenMenu":
                verImagenMenu(request, response);
                break;
            case "/editarMenu":
            	listarMenuID(request, response);
            	break;
            case "/ActualizarProducto":
            	actualizarMenu(request, response);
            	break;
        }
    }

    private void listarPorCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String descripcionCategoria = request.getParameter("cbxCategoria");
        
        CategoriaModel bean = new CategoriaModel();
        bean.setCategoriaDescripcion(descripcionCategoria);
        
        List<MenuModel> listaMenu = menuService.listarCategoria(bean);
        
        request.setAttribute("listaMenu", listaMenu);
        RequestDispatcher despachador = getServletContext().getRequestDispatcher("/mantenimientoProducto.jsp");
        despachador.forward(request, response);
        
    }
    
    private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreFile = "";
        
            
        
        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNom");
        String descripcion = request.getParameter("txtDesc");
        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        int categoria = Integer.parseInt(request.getParameter("cbxCategoria"));
        String condicion = request.getParameter("cbxCondicion");

        InputStream inputStream = null;

        try{
            Part filePart = request.getPart("Imgfichero");
            if(filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
                nombreFile = filePart.getContentType();
            }
        }catch(Exception e){
            System.out.println("Error en la imagen : " + e.getMessage());
        }

        if (nombreFile.equalsIgnoreCase("image/gif") || nombreFile.equalsIgnoreCase("image/png")
                || nombreFile.equalsIgnoreCase("image/jpeg")) {
            MenuModel beanMenu = new MenuModel();
            
            beanMenu.setMenuID(codigo);
            beanMenu.setCategoria(new CategoriaModel());
            beanMenu.getCategoria().setCategoriaID(categoria);
            beanMenu.setMenuNombre(nombre);
            beanMenu.setMenuDescripcion(descripcion);
            beanMenu.setMenuPrecio(precio);
            beanMenu.setMenuAgotado(condicion);
            beanMenu.setMenuImagen(new ImagenUtil());
            beanMenu.getMenuImagen().setArchivoimg(inputStream);

            menuService.insertar(beanMenu);
        }
        
        ControllerUtil.forward(request, response, "mantenimientoProducto.jsp");
       
    }

    
    private void verImagenMenu(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        response.setContentType("image/png");
        
        String codigo = request.getParameter("id");
        MenuModel bean = new MenuModel();
        bean.setMenuID(codigo);
        
        try{
            InputStream bos = new ByteArrayInputStream(menuService.listarImagenMenu(bean));
            
            int tamanoInput = bos.available();
            byte[] datosImagen = new byte[tamanoInput];
            bos.read(datosImagen, 0, tamanoInput);
            
            response.getOutputStream().write(datosImagen);
        }catch(Exception e){
            System.out.println("Error en verImagenMenu COntroller: " + e);
        }
    }
    
    private void  listarMenuID(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
    	String codigo = request.getParameter("cod");
    	
    	MenuModel bean = new MenuModel();
    	
    	bean.setMenuID(codigo);
    	
    	request.setAttribute("menuEditar", menuService.listarMenuID(bean));
        RequestDispatcher despachador = getServletContext().getRequestDispatcher("/editarProducto.jsp");
        despachador.forward(request, response);
    }
    
    private void actualizarMenu(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
    	String nombreFile = "";
        
        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNom");
        String descripcion = request.getParameter("txtDesc");
        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        int categoria = Integer.parseInt(request.getParameter("cbxCategoria"));
        String condicion = request.getParameter("cbxCondicion");

        InputStream inputStream = null;

        try{
            Part filePart = request.getPart("Imgfichero");
            if(filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
                nombreFile = filePart.getContentType();
            }
        }catch(Exception e){
            System.out.println("Error en la imagen : " + e.getMessage());
        }

        if (nombreFile.equalsIgnoreCase("image/gif") || nombreFile.equalsIgnoreCase("image/png")
                || nombreFile.equalsIgnoreCase("image/jpeg")) {
            MenuModel beanMenu = new MenuModel();
            
            beanMenu.setMenuID(codigo);
            beanMenu.setCategoria(new CategoriaModel());
            beanMenu.getCategoria().setCategoriaID(categoria);
            beanMenu.setMenuNombre(nombre);
            beanMenu.setMenuDescripcion(descripcion);
            beanMenu.setMenuPrecio(precio);
            beanMenu.setMenuAgotado(condicion);
            beanMenu.setMenuImagen(new ImagenUtil());
            beanMenu.getMenuImagen().setArchivoimg(inputStream);

            menuService.actualizar(beanMenu);
        }
        
        ControllerUtil.forward(request, response, "mantenimientoProducto.jsp");
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
