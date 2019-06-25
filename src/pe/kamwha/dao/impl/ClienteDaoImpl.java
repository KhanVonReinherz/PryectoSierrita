package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import pe.kamwha.dao.espec.ClienteDaoEspec;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.ClienteModel;

public class ClienteDaoImpl implements ClienteDaoEspec {


    @Override
    public List<ClienteModel> listar(String bean) {
        AccesoDB cn = AccesoDB.saberEstado();
        List<ClienteModel> lista = new ArrayList<ClienteModel>();
        ResultSet rs = null;

        PreparedStatement pst;
        
        try {
            pst = cn.getCn().prepareCall("{ Call ListarClienteActivo()}");

            rs = pst.executeQuery();
            
            while(rs.next()){
                ClienteModel beanCliente = mapRow(rs);

                lista.add(beanCliente);
            }
        } catch(SQLException ex){
            System.out.println("Error en Listar Cliente: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return lista;
    }

    @Override
    public void insertar(ClienteModel bean) {
        AccesoDB cn = AccesoDB.saberEstado();
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call InsertarCliente(?,?,?,?,?,?,?,?,?)}");

            pst.setString(1, bean.getClienteID());
            pst.setString(2, bean.getClienteNombres());
            pst.setString(3, bean.getClienteApePaterno());
            pst.setString(4, bean.getClienteApeMaterno());
            pst.setString(5, bean.getClienteDni());
            pst.setString(6, bean.getClienteEmail());
            pst.setString(7, bean.getClienteTelefono());
            pst.setString(8, bean.getClienteActivo());
            pst.setString(9, bean.getClienteContrasena());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Ingresar Cliente: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    @Override
    public void actualizar(ClienteModel bean) {
        PreparedStatement pst;
        AccesoDB cn = AccesoDB.saberEstado();

        try {
            pst = cn.getCn().prepareCall("{ Call EditarCliente(?,?,?,?,?,?,?,?,?)}");

            pst.setString(1, bean.getClienteID());
            pst.setString(2, bean.getClienteNombres());
            pst.setString(3, bean.getClienteApePaterno());
            pst.setString(4, bean.getClienteApeMaterno());
            pst.setString(5, bean.getClienteDni());
            pst.setString(6, bean.getClienteEmail());
            pst.setString(7, bean.getClienteTelefono());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Actualizar Cliente: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    @Override
    public void eliminar(ClienteModel bean) {
        AccesoDB cn = AccesoDB.saberEstado();
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call EliminarCliente(?)}");

            pst.setString(1, bean.getClienteID());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Eliminar Cliente: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    

    /* Generar CODIGO CLIENTE*/
    public String generarCodigo() {
        AccesoDB cn = AccesoDB.saberEstado();
        String codigo = "";

        PreparedStatement pst;
        ResultSet rs = null;

        try {
            pst = cn.getCn().prepareCall("{ Call GenerarClienteID() }");

            rs = pst.executeQuery();

            while(rs.next()){
                codigo = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Generar ID Cliente: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return codigo;
    }
    
    /*Actualizas CONTRASENA CLIENTE*/
    public void actualizarContrasena(ClienteModel bean, String newContrasena){
        AccesoDB cn = AccesoDB.saberEstado();
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call ContrasenaCliente(?,?,?)}");

            pst.setString(1, bean.getClienteID());
            pst.setString(2, bean.getClienteContrasena());
            pst.setString(3, newContrasena);
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Actualizar Password Cliente: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }
    
    /*Validar datos en Login*/
    public ClienteModel validar(ClienteModel bean){
        AccesoDB cn = AccesoDB.saberEstado();
        ClienteModel beanCliente = null;
        ResultSet rs = null;

        PreparedStatement pst;
        
        try{
            pst = cn.getCn().prepareCall("{Call verificarInicioCliente(?,?)}");
            pst.setString(1, bean.getClienteEmail());
            pst.setString(2, bean.getClienteContrasena());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                beanCliente = mapRow(rs);
            }
            
        }catch(SQLException ex){
            System.out.println("Error en Listar Cliente: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return beanCliente;
    }
            
            
    @Override
    public ClienteModel mapRow(ResultSet rs) throws SQLException {
        ClienteModel bean = new ClienteModel();

        bean.setClienteID(rs.getString(1));
        bean.setClienteNombres(rs.getString(2));
        bean.setClienteApePaterno(rs.getString(3));
        bean.setClienteApeMaterno(rs.getString(4));
        bean.setClienteDni(rs.getString(5));
        bean.setClienteEmail(rs.getString(6));
        bean.setClienteTelefono(rs.getString(7));
        bean.setClienteActivo(rs.getString(8));
        bean.setClienteContrasena(rs.getString(9));

        return bean;
    }
}
