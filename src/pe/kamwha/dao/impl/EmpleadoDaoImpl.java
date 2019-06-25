
package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.kamwha.dao.espec.EmpleadoDaoEspec;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.EmpleadoModel;
import pe.kamwha.model.GerenteModel;


public class EmpleadoDaoImpl implements EmpleadoDaoEspec{
    
    private static final AccesoDB cn = AccesoDB.saberEstado(); 

    @Override
    public List<EmpleadoModel> listar(String bean) {
        List<EmpleadoModel> lista = new ArrayList<EmpleadoModel>();
        ResultSet rs = null;

        PreparedStatement pst;
        
        try {
            pst = cn.getCn().prepareCall("{ Call ListarEmpleadoActivo()}");

            rs = pst.executeQuery();
            
            while(rs.next()){
                EmpleadoModel beanEmpleado = mapRow(rs);

                lista.add(beanEmpleado);
            }
        } catch(SQLException ex){
            System.out.println("Error en Listar Empleado: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return lista;
    }

    @Override
    public void insertar(EmpleadoModel bean) {
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call InsertarEmpleado(?,?,?,?,?,?,?,?,?,?)}");

            pst.setString(1, bean.getEmpleadoID());
            pst.setString(2, bean.getEmpleadoNombres());
            pst.setString(3, bean.getEmpleadoApePaterno());
            pst.setString(4, bean.getEmpleadoApeMaterno());
            pst.setString(5, bean.getEmpleadoDni());
            pst.setString(6, bean.getEmpleadoEmail());
            pst.setString(7, bean.getEmpleadoTelefono());
            pst.setString(8, bean.getGerente().getGerenteID());
            pst.setString(9, bean.getEmpleadoActivo());
            pst.setString(10, bean.getEmpleadoContrasena());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Ingresar Empleado: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    @Override
    public void actualizar(EmpleadoModel bean) {
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call EditarEmpleado(?,?,?,?,?,?,?,?,?)}");

            pst.setString(1, bean.getEmpleadoID());
            pst.setString(2, bean.getEmpleadoNombres());
            pst.setString(3, bean.getEmpleadoApePaterno());
            pst.setString(4, bean.getEmpleadoApeMaterno());
            pst.setString(5, bean.getEmpleadoDni());
            pst.setString(6, bean.getEmpleadoEmail());
            pst.setString(7, bean.getEmpleadoTelefono());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Actualizar Empleado: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    @Override
    public void eliminar(EmpleadoModel bean) {
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call EliminarEmpleado(?)}");

            pst.setString(1, bean.getEmpleadoID());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Eliminar Empleado: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    @Override
    public EmpleadoModel mapRow(ResultSet rs) throws SQLException {
        EmpleadoModel bean = new EmpleadoModel();

        bean.setEmpleadoID(rs.getString(1));
        bean.setEmpleadoNombres(rs.getString(2));
        bean.setEmpleadoApePaterno(rs.getString(3));
        bean.setEmpleadoApeMaterno(rs.getString(4));
        bean.setEmpleadoDni(rs.getString(5));
        bean.setEmpleadoEmail(rs.getString(6));
        bean.setEmpleadoTelefono(rs.getString(7));
        bean.setGerente(new GerenteModel());
        bean.getGerente().setGerenteID(rs.getString(8));
        bean.setEmpleadoActivo(rs.getString(9));
        bean.setEmpleadoContrasena(rs.getString(10));

        return bean;
    }
    
    public String generarCodigo() {

        PreparedStatement pst;
        ResultSet rs = null;
        String codigo = "";
        try {
            pst = cn.getCn().prepareCall("{ Call GenerarEmpleadoID() }");

            rs = pst.executeQuery();
            
            while(rs.next()){
                codigo = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Generar ID Empleado: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return codigo;
    }
    
    /*Actualizas CONTRASENA CLIENTE*/
    public void actualizarContrasena(EmpleadoModel bean, String newContrasena){
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call ContrasenaEmpleado(?,?,?)}");

            pst.setString(1, bean.getEmpleadoID());
            pst.setString(2, bean.getEmpleadoContrasena());
            pst.setString(3, newContrasena);
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Actualizar Password Empleado: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }
    
     /*Validar datos en Login*/
    public EmpleadoModel validar(EmpleadoModel bean){
        AccesoDB cn = AccesoDB.saberEstado();
        EmpleadoModel beanEmpleado = null;
        ResultSet rs = null;

        PreparedStatement pst;
        
        try{
            pst = cn.getCn().prepareCall("{Call verificarInicioEmpleado(?,?)}");
            pst.setString(1, bean.getEmpleadoEmail());
            pst.setString(2, bean.getEmpleadoContrasena());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                beanEmpleado = mapRow(rs);
            }
            
        }catch(SQLException ex){
            System.out.println("Error en VerificarLoginn Empleado: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return beanEmpleado;
    }
}
