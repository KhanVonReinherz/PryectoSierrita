
package pe.kamwha.model;

import pe.kamwha.util.ImagenUtil;

public class MenuModel {
    private String menuID;
    private CategoriaModel categoria;
    private String menuNombre;
    private String menuDescripcion;
    private float menuPrecio;
    private String menuAgotado;
    private ImagenUtil menuImagen;

    public MenuModel() {
    }

    public MenuModel(String menuID, CategoriaModel categoria, String menuNombre, String menuDescripcion, float menuPrecio, String menuAgotado, ImagenUtil menuImagen) {
        this.menuID = menuID;
        this.categoria = categoria;
        this.menuNombre = menuNombre;
        this.menuDescripcion = menuDescripcion;
        this.menuPrecio = menuPrecio;
        this.menuAgotado = menuAgotado;
        this.menuImagen = menuImagen;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getMenuDescripcion() {
        return menuDescripcion;
    }

    public void setMenuDescripcion(String menuDescripcion) {
        this.menuDescripcion = menuDescripcion;
    }

    public float getMenuPrecio() {
        return menuPrecio;
    }

    public void setMenuPrecio(float menuPrecio) {
        this.menuPrecio = menuPrecio;
    }

    public String getMenuAgotado() {
        return menuAgotado;
    }

    public void setMenuAgotado(String menuAgotado) {
        this.menuAgotado = menuAgotado;
    }

    public ImagenUtil getMenuImagen() {
        return menuImagen;
    }

    public void setMenuImagen(ImagenUtil menuImagen) {
        this.menuImagen = menuImagen;
    }
}
