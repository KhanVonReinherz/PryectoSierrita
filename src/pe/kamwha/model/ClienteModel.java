
package pe.kamwha.model;

public class ClienteModel {
    private String clienteID;
    private String clienteNombres;
    private String clienteApePaterno;
    private String clienteApeMaterno;
    private String clienteDni;
    private String clienteEmail;
    private String clienteTelefono;
    private String clienteActivo;
    private String clienteContrasena;

    public ClienteModel() {
    }

    public ClienteModel(String clienteID, String clienteNombres, String clienteApePaterno, String clienteApeMaterno, String clienteDni, String clienteEmail, String clienteTelefono, String clienteActivo, String clienteContrasena) {
        this.clienteID = clienteID;
        this.clienteNombres = clienteNombres;
        this.clienteApePaterno = clienteApePaterno;
        this.clienteApeMaterno = clienteApeMaterno;
        this.clienteDni = clienteDni;
        this.clienteEmail = clienteEmail;
        this.clienteTelefono = clienteTelefono;
        this.clienteActivo = clienteActivo;
        this.clienteContrasena = clienteContrasena;
    }

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

    public String getClienteNombres() {
        return clienteNombres;
    }

    public void setClienteNombres(String clienteNombres) {
        this.clienteNombres = clienteNombres;
    }

    public String getClienteApePaterno() {
        return clienteApePaterno;
    }

    public void setClienteApePaterno(String clienteApePaterno) {
        this.clienteApePaterno = clienteApePaterno;
    }

    public String getClienteApeMaterno() {
        return clienteApeMaterno;
    }

    public void setClienteApeMaterno(String clienteApeMaterno) {
        this.clienteApeMaterno = clienteApeMaterno;
    }

    public String getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClienteTelefono() {
        return clienteTelefono;
    }

    public void setClienteTelefono(String clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public String getClienteActivo() {
        return clienteActivo;
    }

    public void setClienteActivo(String clienteActivo) {
        this.clienteActivo = clienteActivo;
    }

    public String getClienteContrasena() {
        return clienteContrasena;
    }

    public void setClienteContrasena(String clienteContrasena) {
        this.clienteContrasena = clienteContrasena;
    }
}
