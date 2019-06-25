
package pe.kamwha.service;

import pe.kamwha.dao.espec.GerenteDaoEspec;
import pe.kamwha.dao.impl.GerenteDaoImpl;
import pe.kamwha.model.GerenteModel;


public class GerenteService {
    private GerenteDaoEspec gerenteDAO;
    private GerenteDaoImpl gerenteImplDAO;

    public GerenteService() {
        gerenteDAO = new GerenteDaoImpl();
        gerenteImplDAO = new GerenteDaoImpl();
    }
    
    public void insertar(GerenteModel bean){
        gerenteDAO.insertar(bean);
    }
    
    public String generarCodigo(){
        String codigo;
        
        codigo = gerenteImplDAO.generarCodigo();
        
        return codigo;
    }
    
    public GerenteModel validar(GerenteModel bean){
        if(bean.getGerenteEmail() == null || bean.getGerenteEmail().isEmpty()){
            System.out.println("Error EMAIL del GERENTE VACIO ");
        }
        if(bean.getGerenteContrasena() == null || bean.getGerenteContrasena().isEmpty()){
            System.out.println("Error CONTRASENIA del GERENTE VACIO ");
        }
        
        GerenteModel beanGerente = gerenteImplDAO.validar(bean);
        
        if(beanGerente == null){
            System.out.println("Error NO HAY CLIENTE CON ESOS DATOS DE IINGRESO");
        }
        
        return beanGerente;
    }
}
