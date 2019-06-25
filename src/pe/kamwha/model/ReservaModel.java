
package pe.kamwha.model;


public class ReservaModel {
    private String reservaID;
    private ClienteModel cliente;
    private MesaModel mesa;
    private String reservafecha;
    private String reservaStatus;

    public ReservaModel() {
    }

    public ReservaModel(String reservaID, ClienteModel cliente, MesaModel mesa, String reservafecha, String reservaStatus) {
        this.reservaID = reservaID;
        this.cliente = cliente;
        this.mesa = mesa;
        this.reservafecha = reservafecha;
        this.reservaStatus = reservaStatus;
    }

    public String getReservaID() {
        return reservaID;
    }

    public void setReservaID(String reservaID) {
        this.reservaID = reservaID;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public MesaModel getMesa() {
        return mesa;
    }

    public void setMesa(MesaModel mesa) {
        this.mesa = mesa;
    }

    public String getReservafecha() {
        return reservafecha;
    }

    public void setReservafecha(String reservafecha) {
        this.reservafecha = reservafecha;
    }

    public String getReservaStatus() {
        return reservaStatus;
    }

    public void setReservaStatus(String reservaStatus) {
        this.reservaStatus = reservaStatus;
    }
}
