package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.kamwha.dao.espec.CategoriaDaoEspec;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.CategoriaModel;

public class CategoriaDaoImpl implements CategoriaDaoEspec {

    private static final AccesoDB cn = AccesoDB.saberEstado();

    @Override
    public List<CategoriaModel> listar(String bean) {

        List<CategoriaModel> lista = new ArrayList<CategoriaModel>();
        ResultSet rs = null;

        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call ListarCategoria()}");

            rs = pst.executeQuery();

            while (rs.next()) {
                CategoriaModel beanCategoria = mapRow(rs);

                lista.add(beanCategoria);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Listar CATEGORIA: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return lista;
    }

    public List<String> listarReporteVentas() {

        List<String> lista = new ArrayList<String>();
        ResultSet rs = null;

        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call Mostrar_Datos_Reserva()}");

            rs = pst.executeQuery();

            while (rs.next()) {
//                CategoriaModel beanCategoria = mapRow(rs);

                lista.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error en Listar CATEGORIA Reporte x Ventas: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return lista;
    }
    

    public List<String> listarReporte() {

        List<String> lista = new ArrayList<String>();
        ResultSet rs = null;

        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call Mostrar_Datos()}");

            rs = pst.executeQuery();

            while (rs.next()) {
//                CategoriaModel beanCategoria = mapRow(rs);

                lista.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error en Listar CATEGORIA Reporte: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return lista;
    }
    
    @Override
    public void insertar(CategoriaModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(CategoriaModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(CategoriaModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaModel mapRow(ResultSet rs) throws SQLException {
        CategoriaModel bean = new CategoriaModel();

        bean.setCategoriaID(rs.getInt(1));
        bean.setCategoriaDescripcion(rs.getString(2));

        return bean;
    }

}
