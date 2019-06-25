
package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.kamwha.dao.espec.MenuDaoEspec;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.CategoriaModel;
import pe.kamwha.model.MenuModel;
import pe.kamwha.util.ImagenUtil;


public class MenuDaoImpl implements MenuDaoEspec{
   
    
    
    @Override
    public List<MenuModel> listar(String bean) {
        AccesoDB cn = AccesoDB.saberEstado();
        List<MenuModel> lista = new ArrayList<MenuModel>();
        ResultSet rs = null;

        PreparedStatement pst;
        
        try {
            pst = cn.getCn().prepareCall("{ Call ListarMenuCategoriaHoy(?)}");
            pst.setString(1, bean);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                MenuModel beanMenu= mapRow(rs);

                lista.add(beanMenu);
            }
        } catch(SQLException ex){
            System.out.println("Error en Listar Menu: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return lista;
    }

    @Override
    public void insertar(MenuModel bean) {
        AccesoDB cn = AccesoDB.saberEstado();
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call InsertarMenu(?,?,?,?,?,?,?)}");

            pst.setString(1, bean.getMenuID());
            pst.setInt(2, bean.getCategoria().getCategoriaID());
            pst.setString(3, bean.getMenuNombre());
            pst.setString(4, bean.getMenuDescripcion());
            pst.setFloat(5, bean.getMenuPrecio());
            pst.setString(6, bean.getMenuAgotado());
            pst.setBlob(7, bean.getMenuImagen().getArchivoimg());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Ingresar Menu: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    
    public MenuModel listarMenuID(MenuModel bean) {
    	AccesoDB cn = AccesoDB.saberEstado();
    	
    	MenuModel beanMenu = new  MenuModel();
    	
    	ResultSet rs = null;

        PreparedStatement pst;
        try {
            pst = cn.getCn().prepareCall("{ Call ListarMenuID(?)}");
            pst.setString(1, bean.getMenuID());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                beanMenu = mapRow(rs);
            }
        } catch(SQLException ex){
            System.out.println("Error en Listar Menu Por Categoria: " + ex);
        } finally{
            cn.cerrarConexion();
        }
    	
    	return beanMenu;
    }
    
    @Override
    public void actualizar(MenuModel bean) {
    	AccesoDB cn = AccesoDB.saberEstado();
    	
        PreparedStatement pst;
        
        try {
            pst = cn.getCn().prepareCall("{ Call ActualizarMenu(?,?,?,?,?,?,?)}");
            pst.setString(1, bean.getMenuID());
            pst.setInt(2, bean.getCategoria().getCategoriaID());
            pst.setString(3, bean.getMenuNombre());
            pst.setString(4, bean.getMenuDescripcion());
            pst.setFloat(5, bean.getMenuPrecio());
            pst.setString(6, bean.getMenuAgotado());
            pst.setBlob(7, bean.getMenuImagen().getArchivoimg());
            
            
            pst.executeUpdate();
            
        } catch(SQLException ex){
            System.out.println("Error en Actualizar Menu: " + ex);
        } finally{
            cn.cerrarConexion();
        }  
    }

    @Override
    public void eliminar(MenuModel bean) {
        AccesoDB cn = AccesoDB.saberEstado();
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call MenuHoy(?, ?)}");

            pst.setString(1, bean.getMenuID());
            pst.setString(2, bean.getMenuAgotado());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Eliminar  Menu: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    
            
    /* Generar CODIGO MENU*/
    public String generarCodigo() {
        AccesoDB cn = AccesoDB.saberEstado();
        String codigo = "";

        PreparedStatement pst;
        ResultSet rs = null;

        try {
            pst = cn.getCn().prepareCall("{ Call GenerarMenuID() }");

            rs = pst.executeQuery();
            
            while(rs.next()){
                codigo = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Generar ID MENU: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return codigo;
    }
    
    public List<MenuModel> listarCategoria(CategoriaModel beanCategoria){
        
        AccesoDB cn = AccesoDB.saberEstado();
        List<MenuModel> lista = new ArrayList<MenuModel>();
        ResultSet rs = null;

        PreparedStatement pst;
        
        try {
            pst = cn.getCn().prepareCall("{ Call ListarMenuCategoria(?)}");
            pst.setString(1, beanCategoria.getCategoriaDescripcion());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                MenuModel beanMenu = mapRow(rs);
                lista.add(beanMenu);
            }
        } catch(SQLException ex){
            System.out.println("Error en Listar Menu Por Categoria: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return lista;
    }
    
    
    public MenuModel obtenerporID(MenuModel bean){
        AccesoDB cn = AccesoDB.saberEstado();
        
        ResultSet rs = null;

        PreparedStatement pst;
        MenuModel menu = new MenuModel();
        try{
            pst = cn.getCn().prepareCall("{ Call ObtenerMenuID(?) }");
            pst.setString(1, bean.getMenuID());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                menu = mapRow(rs);
            }
        }catch(Exception e){
            System.out.println("Error en Obtener ID por MENU: " + e);
        }finally{
            cn.cerrarConexion();
        }
        return menu;
    }
    
    public byte[] listarImagenMenu(MenuModel bean){
        byte[] b = null;
        
        AccesoDB cn = AccesoDB.saberEstado();
        ResultSet rs = null;
        PreparedStatement pst;
        
        try{
            pst = cn.getCn().prepareCall("{ Call verImagenMenu(?) }");
            pst.setString(1, bean.getMenuID());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                b = rs.getBytes(1);
            }
        } catch(Exception e){
            System.out.println("Error en VER IMAGEN MENU: " + e);
        } finally{
            cn.cerrarConexion();
        }
        
        return b;
    }
    
    @Override
    public MenuModel mapRow(ResultSet rs) throws SQLException {
        MenuModel bean = new MenuModel();
        
        bean.setMenuID(rs.getString(1));
        bean.setCategoria(new CategoriaModel());
        bean.getCategoria().setCategoriaDescripcion(rs.getString(2));
        bean.setMenuNombre(rs.getString(3));
        bean.setMenuDescripcion(rs.getString(4));
        bean.setMenuPrecio(rs.getFloat(5));
        bean.setMenuAgotado(rs.getString(6));
        bean.setMenuImagen(new ImagenUtil());
        bean.getMenuImagen().setArchivoimg2(rs.getBytes(7));

        return bean;
    }
}
