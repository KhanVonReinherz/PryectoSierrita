
package pe.kamwha.dao.espec;

import java.util.List;

public interface CrudDaoEspec<T> {
    
    List<T> listar(String bean);
    
    void insertar(T bean);
    
    void actualizar(T bean);
    
    void eliminar(T bean);
}
