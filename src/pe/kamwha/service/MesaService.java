
package pe.kamwha.service;

import java.util.List;
import pe.kamwha.dao.espec.MesaDaoEspec;
import pe.kamwha.dao.impl.MesaDaoImpl;
import pe.kamwha.model.MesaModel;


public class MesaService {
    private MesaDaoEspec mesaDAO;
    private MesaDaoImpl mesaDaoImpl;

    public MesaService() {
        mesaDAO = new MesaDaoImpl();
        mesaDaoImpl = new MesaDaoImpl();
    }
    
    public List<MesaModel> listar(String bean){
        return mesaDAO.listar("");
    }
}
