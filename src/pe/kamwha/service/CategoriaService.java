
package pe.kamwha.service;

import java.util.List;
import pe.kamwha.dao.espec.CategoriaDaoEspec;
import pe.kamwha.dao.impl.CategoriaDaoImpl;
import pe.kamwha.model.CategoriaModel;


public class CategoriaService {
    private CategoriaDaoEspec categoriaDAO;
    private CategoriaDaoImpl categoriaDaoImpl;

    public CategoriaService() {
        categoriaDAO = new CategoriaDaoImpl();
        categoriaDaoImpl = new CategoriaDaoImpl();
    }
    
    public List<CategoriaModel> listarCategoria(){
        
        return categoriaDAO.listar("");
    }
}
