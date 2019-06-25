
package pe.kamwha.model;

public class EmpleadoModel {
    private String empleadoID;
    private String empleadoNombres;
    private String empleadoApePaterno;
    private String empleadoApeMaterno;
    private String empleadoDni;
    private String empleadoEmail;
    private String empleadoTelefono;
    private GerenteModel gerente;
    private String empleadoActivo;
    private String empleadoContrasena;

    public EmpleadoModel() {
    }

    public EmpleadoModel(String empleadoID, String empleadoNombres, String empleadoApePaterno, String empleadoApeMaterno, String empleadoDni, String empleadoEmail, String empleadoTelefono, GerenteModel gerente, String empleadoActivo, String empleadoContrasena) {
        this.empleadoID = empleadoID;
        this.empleadoNombres = empleadoNombres;
        this.empleadoApePaterno = empleadoApePaterno;
        this.empleadoApeMaterno = empleadoApeMaterno;
        this.empleadoDni = empleadoDni;
        this.empleadoEmail = empleadoEmail;
        this.empleadoTelefono = empleadoTelefono;
        this.gerente = gerente;
        this.empleadoActivo = empleadoActivo;
        this.empleadoContrasena = empleadoContrasena;
    }

    public String getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(String empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getEmpleadoNombres() {
        return empleadoNombres;
    }

    public void setEmpleadoNombres(String empleadoNombres) {
        this.empleadoNombres = empleadoNombres;
    }

    public String getEmpleadoApePaterno() {
        return empleadoApePaterno;
    }

    public void setEmpleadoApePaterno(String empleadoApePaterno) {
        this.empleadoApePaterno = empleadoApePaterno;
    }

    public String getEmpleadoApeMaterno() {
        return empleadoApeMaterno;
    }

    public void setEmpleadoApeMaterno(String empleadoApeMaterno) {
        this.empleadoApeMaterno = empleadoApeMaterno;
    }

    public String getEmpleadoDni() {
        return empleadoDni;
    }

    public void setEmpleadoDni(String empleadoDni) {
        this.empleadoDni = empleadoDni;
    }

    public String getEmpleadoEmail() {
        return empleadoEmail;
    }

    public void setEmpleadoEmail(String empleadoEmail) {
        this.empleadoEmail = empleadoEmail;
    }

    public String getEmpleadoTelefono() {
        return empleadoTelefono;
    }

    public void setEmpleadoTelefono(String empleadoTelefono) {
        this.empleadoTelefono = empleadoTelefono;
    }

    public GerenteModel getGerente() {
        return gerente;
    }

    public void setGerente(GerenteModel gerente) {
        this.gerente = gerente;
    }

    public String getEmpleadoActivo() {
        return empleadoActivo;
    }

    public void setEmpleadoActivo(String empleadoActivo) {
        this.empleadoActivo = empleadoActivo;
    }

    public String getEmpleadoContrasena() {
        return empleadoContrasena;
    }

    public void setEmpleadoContrasena(String empleadoContrasena) {
        this.empleadoContrasena = empleadoContrasena;
    }
}
