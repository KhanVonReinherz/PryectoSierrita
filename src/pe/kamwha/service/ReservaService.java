package pe.kamwha.service;

import pe.kamwha.dao.espec.ReservaDaoEspec;
import pe.kamwha.dao.impl.ReservaDaoImpl;
import pe.kamwha.model.ReservaModel;

public class ReservaService {

    private ReservaDaoEspec reservaDAO;
    private ReservaDaoImpl reservaDaoImpl;

    public ReservaService() {
        reservaDAO = new ReservaDaoImpl();
        reservaDaoImpl = new ReservaDaoImpl();
    }

    public void insertar(ReservaModel bean) {
        reservaDAO.insertar(bean);
    }

    public ReservaModel enviarCorreoCliente(ReservaModel bean) {
    	return reservaDaoImpl.enviarCorreoCliente(bean);
    }
    
    public String generarCodigo() {
        String codigo = "";

        codigo = reservaDaoImpl.generarCodigo();

        return codigo;
    }
    
    public int validarReserva(ReservaModel bean){
        return reservaDaoImpl.validarExistenciaReserva(bean);      
    }
}
