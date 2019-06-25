
package pe.kamwha.service;

import java.util.List;
import pe.kamwha.dao.impl.VentaDAOImpl;
import pe.kamwha.model.BoletaModel;
import pe.kamwha.model.ClienteModel;
import pe.kamwha.model.MenuModel;


public class VentaService {
    private VentaDAOImpl ventaDAOImpl;

    public VentaService() {
        ventaDAOImpl = new VentaDAOImpl();
    }
    
    public BoletaModel insertarVenta(ClienteModel cliente, List<MenuModel> carro){
        return ventaDAOImpl.insertarVenta(cliente, carro);
    }
}

