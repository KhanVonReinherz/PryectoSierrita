
package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.kamwha.dao.espec.GerenteDaoEspec;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.GerenteModel;


public class GerenteDaoImpl implements GerenteDaoEspec{

    @Override
    public List<GerenteModel> listar(String bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(GerenteModel bean) {
    	AccesoDB cn = AccesoDB.saberEstado();
        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call InsertarGerente(?,?,?,?,?,?,?,?,?)}");

            pst.setString(1, bean.getGerenteID());
            pst.setString(2, bean.getGerenteNombres());
            pst.setString(3, bean.getGerenteApePaterno());
            pst.setString(4, bean.getGerenteApeMaterno());
            pst.setString(5, bean.getGerenteDni());
            pst.setString(6, bean.getGerenteEmail());
            pst.setString(7, bean.getGerenteTelefono());
            pst.setString(8, bean.getGerenteActivo());
            pst.setString(9, bean.getGerenteContrasena());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en Ingresar Gerente: " + ex);
        } finally {
            cn.cerrarConexion();
        }
    }

    @Override
    public void actualizar(GerenteModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(GerenteModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*Generar ID de GERENTE*/
    public String generarCodigo() {
        AccesoDB cn = AccesoDB.saberEstado();
        String codigo = "";

        PreparedStatement pst;
        ResultSet rs = null;

        try {
            pst = cn.getCn().prepareCall("{ Call GenerarGerenteID() }");

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
    
    /*Validar datos en Login*/
    public GerenteModel validar(GerenteModel bean){
        AccesoDB cn = AccesoDB.saberEstado();
        GerenteModel beanGerente = null;
        ResultSet rs = null;

        PreparedStatement pst;
        
        try{
            pst = cn.getCn().prepareCall("{Call verificarInicioGerente(?,?)}");
            pst.setString(1, bean.getGerenteEmail());
            pst.setString(2, bean.getGerenteContrasena());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                beanGerente = mapRow(rs);
            }
            
        }catch(SQLException ex){
            System.out.println("Error en VerificarLoginn Gerente: " + ex);
        } finally{
            cn.cerrarConexion();
        }
        
        return beanGerente;
    }
    
    @Override
    public GerenteModel mapRow(ResultSet rs) throws SQLException {
        GerenteModel bean = new GerenteModel();
        
        bean.setGerenteID(rs.getString(1));
        bean.setGerenteNombres(rs.getString(2));
        bean.setGerenteApePaterno(rs.getString(3));
        bean.setGerenteApeMaterno(rs.getString(4));
        bean.setGerenteDni(rs.getString(5));
        bean.setGerenteEmail(rs.getString(6));
        bean.setGerenteTelefono(rs.getString(7));
        bean.setGerenteActivo(rs.getString(8));
        bean.setGerenteContrasena(rs.getString(9));
        
        return bean;
    }
}
