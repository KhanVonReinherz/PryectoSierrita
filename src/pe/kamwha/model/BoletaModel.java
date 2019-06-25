
package pe.kamwha.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BoletaModel {
    private String boletaID;
    private LocalDate boletaFecha;
    private ClienteModel cliente;
    private List<DetalleBoletaModel> detalle = new ArrayList<DetalleBoletaModel>();

    public BoletaModel() {
    }

    public BoletaModel(String boletaID, LocalDate boletaFecha, ClienteModel cliente) {
        this.boletaID = boletaID;
        this.boletaFecha = boletaFecha;
        this.cliente = cliente;
    }

    public String getBoletaID() {
        return boletaID;
    }

    public void setBoletaID(String boletaID) {
        this.boletaID = boletaID;
    }

    public LocalDate getBoletaFecha() {
        return boletaFecha;
    }

    public void setBoletaFecha(LocalDate boletaFecha) {
        this.boletaFecha = boletaFecha;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
    
    public void addDetalle(DetalleBoletaModel item){
        detalle.add(item);
    }
    
    public List<DetalleBoletaModel> getDetalle(){
        return detalle;
    }
}
