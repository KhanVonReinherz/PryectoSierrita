package pe.kamwha.model;

public class GerenteModel {

    private String gerenteID;
    private String gerenteNombres;
    private String gerenteApePaterno;
    private String gerenteApeMaterno;
    private String gerenteDni;
    private String gerenteEmail;
    private String gerenteTelefono;
    private String gerenteActivo;
    private String gerenteContrasena;

    public GerenteModel() {
    }

    public GerenteModel(String gerenteID, String gerenteNombres, String gerenteApePaterno, String gerenteApeMaterno, String gerenteDni, String gerenteEmail, String gerenteTelefono, String gerenteActivo, String gerenteContrasena) {
        this.gerenteID = gerenteID;
        this.gerenteNombres = gerenteNombres;
        this.gerenteApePaterno = gerenteApePaterno;
        this.gerenteApeMaterno = gerenteApeMaterno;
        this.gerenteDni = gerenteDni;
        this.gerenteEmail = gerenteEmail;
        this.gerenteTelefono = gerenteTelefono;
        this.gerenteActivo = gerenteActivo;
        this.gerenteContrasena = gerenteContrasena;
    }

    public String getGerenteID() {
        return gerenteID;
    }

    public void setGerenteID(String gerenteID) {
        this.gerenteID = gerenteID;
    }

    public String getGerenteNombres() {
        return gerenteNombres;
    }

    public void setGerenteNombres(String gerenteNombres) {
        this.gerenteNombres = gerenteNombres;
    }

    public String getGerenteApePaterno() {
        return gerenteApePaterno;
    }

    public void setGerenteApePaterno(String gerenteApePaterno) {
        this.gerenteApePaterno = gerenteApePaterno;
    }

    public String getGerenteApeMaterno() {
        return gerenteApeMaterno;
    }

    public void setGerenteApeMaterno(String gerenteApeMaterno) {
        this.gerenteApeMaterno = gerenteApeMaterno;
    }

    public String getGerenteDni() {
        return gerenteDni;
    }

    public void setGerenteDni(String gerenteDni) {
        this.gerenteDni = gerenteDni;
    }

    public String getGerenteEmail() {
        return gerenteEmail;
    }

    public void setGerenteEmail(String gerenteEmail) {
        this.gerenteEmail = gerenteEmail;
    }

    public String getGerenteTelefono() {
        return gerenteTelefono;
    }

    public void setGerenteTelefono(String gerenteTelefono) {
        this.gerenteTelefono = gerenteTelefono;
    }

    public String getGerenteActivo() {
        return gerenteActivo;
    }

    public void setGerenteActivo(String gerenteActivo) {
        this.gerenteActivo = gerenteActivo;
    }

    public String getGerenteContrasena() {
        return gerenteContrasena;
    }

    public void setGerenteContrasena(String gerenteContrasena) {
        this.gerenteContrasena = gerenteContrasena;
    }
}
