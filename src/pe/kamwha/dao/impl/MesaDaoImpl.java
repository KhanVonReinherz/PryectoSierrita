
package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.kamwha.dao.espec.MesaDaoEspec;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.MesaModel;

public class MesaDaoImpl implements MesaDaoEspec{

    private static final AccesoDB cn = AccesoDB.saberEstado();
    
    @Override
    public List<MesaModel> listar(String bean) {
        List<MesaModel> lista = new ArrayList<MesaModel>();
        ResultSet rs = null;

        PreparedStatement pst;

        try {
            pst = cn.getCn().prepareCall("{ Call listarMesa()}");

            rs = pst.executeQuery();

            while (rs.next()) {
                MesaModel beanMesa = mapRow(rs);

                lista.add(beanMesa);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Listar MESAS: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return lista;
    }

    @Override
    public void insertar(MesaModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(MesaModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(MesaModel bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MesaModel mapRow(ResultSet rs) throws SQLException {
        MesaModel bean = new MesaModel();

        bean.setMesaNro(rs.getInt(1));
        bean.setMesaCap(rs.getInt(2));

        return bean;
    }
    
}
