/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.kamwha.service;

import pe.kamwha.dao.espec.EmpleadoDaoEspec;
import pe.kamwha.dao.impl.EmpleadoDaoImpl;
import pe.kamwha.model.EmpleadoModel;


public class EmpleadoServices {
    private EmpleadoDaoEspec empleadoDAO;
    private EmpleadoDaoImpl empleadoImplDAO;

    public EmpleadoServices() {
        empleadoDAO = new EmpleadoDaoImpl();
        empleadoImplDAO = new EmpleadoDaoImpl();
    }
    
    public void insertar(EmpleadoModel bean){
        empleadoDAO.insertar(bean);
    }
    
    public String generarCodigo(){
        String codigo;
        
        codigo = empleadoImplDAO.generarCodigo();
        
        return codigo;
    }
    
    public EmpleadoModel validar(EmpleadoModel bean){
        if(bean.getEmpleadoEmail() == null || bean.getEmpleadoEmail().isEmpty()){
            System.out.println("Error EMAIL del GERENTE VACIO ");
        }
        if(bean.getEmpleadoContrasena() == null || bean.getEmpleadoContrasena().isEmpty()){
            System.out.println("Error CONTRASENIA del GERENTE VACIO ");
        }
        
        EmpleadoModel beanEmpleado = empleadoImplDAO.validar(bean);
        
        if(beanEmpleado == null){
            System.out.println("Error NO HAY CLIENTE CON ESOS DATOS DE IINGRESO");
        }
        
        return beanEmpleado;
    }
}
