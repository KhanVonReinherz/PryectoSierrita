
package pe.kamwha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.kamwha.db.AccesoDB;
import pe.kamwha.model.BoletaModel;
import pe.kamwha.model.ClienteModel;
import pe.kamwha.model.DetalleBoletaModel;
import pe.kamwha.model.MenuModel;


public class VentaDAOImpl {
    private static final AccesoDB cn = AccesoDB.saberEstado();
    
    public BoletaModel insertarVenta(ClienteModel cliente, List<MenuModel> carro){
        BoletaModel boleta = null;
        try{
            insertarBoleta(cliente);
            boleta = listarBoletaCliente();
            insertarDetalleBoleta(carro, boleta);
        }catch(Exception e){
            System.out.println("Error en insertar ventas: " + e);
        }
        
        return boleta;
    }
    
    private void insertarBoleta(ClienteModel cliente){
        
        PreparedStatement pst;

        try{
            String codigo = generarCodigoBoleta();
            pst = cn.getCn().prepareCall("{ Call IngresarBoleta(?,?)}");
            pst.setString(1, codigo);
            pst.setString(2, cliente.getClienteID());
            pst.executeUpdate();

            
        }catch(Exception e){
            System.out.println("Error en insertar Boleta: " + e);
        }
        
    }
     
    private BoletaModel listarBoletaCliente(){
        BoletaModel boleta = null;
        PreparedStatement pst;
        ResultSet rs = null;
        try{
            pst = cn.getCn().prepareCall("{ Call listarUltimaBoleta() }");

            rs = pst.executeQuery();
            
            while(rs.next()){
                boleta = new BoletaModel();
                boleta.setBoletaID(rs.getString(1));
                boleta.setBoletaFecha(rs.getDate(2).toLocalDate());
                boleta.setCliente(new ClienteModel());
                boleta.getCliente().setClienteNombres(rs.getString(3));
                boleta.getCliente().setClienteApePaterno(rs.getString(4));
                boleta.getCliente().setClienteApeMaterno(rs.getString(5));
                boleta.getCliente().setClienteDni(rs.getString(6));
            }
            
        }catch(Exception e){
            System.out.println("Error en listarBoletaCliente: " + e);
        }

        return boleta;
    }
    
    private void insertarDetalleBoleta(List<MenuModel> carro, BoletaModel boleta){
        PreparedStatement pst;
        try{
        	
            for(MenuModel menu : carro){
            	String codigo = generarCodigoDetalleBoleta();
                DetalleBoletaModel detalle = new DetalleBoletaModel();
                detalle.setDetalleBoleta(codigo);
                detalle.setBoleta(boleta);
                detalle.setMenu(menu);
                
                pst = cn.getCn().prepareCall("{ Call InsertarDetalleBoleta(?,?,?,?) }");
                pst.setString(1, detalle.getDetalleBoleta());
                pst.setString(2, detalle.getBoleta().getBoletaID());
                pst.setString(3, detalle.getMenu().getMenuID());
                pst.setFloat(4, detalle.getMenu().getMenuPrecio());
                pst.executeUpdate();
                
                boleta.addDetalle(detalle);
            }
        }catch(Exception e){
            System.out.println("Error en insertarDetalleBoleta: " + e);
        }
    }
    
    
    /* Generar CODIGO Boleta*/
    public String generarCodigoBoleta() {
        AccesoDB cn = AccesoDB.saberEstado();
        String codigo = "";

        PreparedStatement pst;
        ResultSet rs = null;

        try {
            pst = cn.getCn().prepareCall("{ Call GenerarBoletaID() }");

            rs = pst.executeQuery();

            while(rs.next()){
                codigo = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Generar ID Boleta: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return codigo;
    }
    
    /* Generar CODIGO Detalle Boleta*/
    public String generarCodigoDetalleBoleta() {
        AccesoDB cn = AccesoDB.saberEstado();
        String codigo = "";

        PreparedStatement pst;
        ResultSet rs = null;

        try {
            pst = cn.getCn().prepareCall("{ Call GenerarDetalleBoletaID() }");

            rs = pst.executeQuery();

            while(rs.next()){
                codigo = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en Generar ID DetalleBoleta: " + ex);
        } finally {
            cn.cerrarConexion();
        }

        return codigo;
    }
}
