
package pe.kamwha.model;


public class CategoriaModel {
    private int categoriaID;
    private String categoriaDescripcion;

    public CategoriaModel() {
    }

    public CategoriaModel(int categoriaID, String categoriaDescripcion) {
        this.categoriaID = categoriaID;
        this.categoriaDescripcion = categoriaDescripcion;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getCategoriaDescripcion() {
        return categoriaDescripcion;
    }

    public void setCategoriaDescripcion(String categoriaDescripcion) {
        this.categoriaDescripcion = categoriaDescripcion;
    }  
}
