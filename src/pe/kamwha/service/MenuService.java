
package pe.kamwha.service;

import java.util.List;
import pe.kamwha.dao.espec.MenuDaoEspec;
import pe.kamwha.dao.impl.MenuDaoImpl;
import pe.kamwha.model.CategoriaModel;
import pe.kamwha.model.MenuModel;

public class MenuService {
    
    private MenuDaoEspec menuDAO;
    private MenuDaoImpl menuDaoImpl;
    
    public MenuService() {
        menuDAO = new MenuDaoImpl();
        menuDaoImpl = new MenuDaoImpl();
    }
    
    public void insertar(MenuModel bean){
        menuDAO.insertar(bean);
    }
    
    public List<MenuModel> listarEntrada(String bean){
        
        return menuDAO.listar(bean);
    }
    
    public List<MenuModel> listarCategoria(CategoriaModel bean){
        return menuDaoImpl.listarCategoria(bean);
    }
    
    public String generarCodigo(){
        String codigo;
        
        codigo = menuDaoImpl.generarCodigo();
        
        return codigo;
    }
    
    public byte[] listarImagenMenu(MenuModel bean){
        return menuDaoImpl.listarImagenMenu(bean);
    }
    
    public MenuModel obtenerporID(MenuModel bean){
        return menuDaoImpl.obtenerporID(bean);
    }
    
    public void eliminar (MenuModel bean){
        menuDAO.eliminar(bean);
    }
    
    public MenuModel listarMenuID(MenuModel bean) {
    	return menuDaoImpl.listarMenuID(bean);
    }
    
    public void actualizar(MenuModel bean){
        menuDAO.actualizar(bean);
    }
}
