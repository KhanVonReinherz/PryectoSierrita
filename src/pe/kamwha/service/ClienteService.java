
package pe.kamwha.service;

import pe.kamwha.dao.espec.ClienteDaoEspec;
import pe.kamwha.dao.impl.ClienteDaoImpl;
import pe.kamwha.model.ClienteModel;


public class ClienteService {
    private ClienteDaoEspec clienteDAO;
    private ClienteDaoImpl clienteImplDAO;

    public ClienteService() {
        clienteDAO = new ClienteDaoImpl();  
        clienteImplDAO = new ClienteDaoImpl();
    }
    
    public void insertar(ClienteModel bean){
        clienteDAO.insertar(bean);
    }
    
    public String generarCodigo(){
        String codigo;
        
        codigo = clienteImplDAO.generarCodigo();
        
        return codigo;
    }
    
    public ClienteModel validar(ClienteModel bean){
        if(bean.getClienteEmail() == null || bean.getClienteEmail().isEmpty()){
            System.out.println("Error EMAIL del CLIENTE VACIO ");
        }
        if(bean.getClienteContrasena() == null || bean.getClienteContrasena().isEmpty()){
            System.out.println("Error CONTRASENIA del CLIENTE VACIO ");
        }
        
        ClienteModel beanCliente = clienteImplDAO.validar(bean);
        
        if(beanCliente == null){
            System.out.println("Error NO HAY CLIENTE CON ESOS DATOS DE IINGRESO");
        }
        
        return beanCliente;
    }
}
