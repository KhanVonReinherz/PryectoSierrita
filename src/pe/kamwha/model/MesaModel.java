
package pe.kamwha.model;


public class MesaModel {
    private int mesaNro;
    private int mesaCap;

    public MesaModel() {
    }

    public MesaModel(int mesaNro, int mesaCap) {
        this.mesaNro = mesaNro;
        this.mesaCap = mesaCap;
    }

    public int getMesaNro() {
        return mesaNro;
    }

    public void setMesaNro(int mesaNro) {
        this.mesaNro = mesaNro;
    }

    public int getMesaCap() {
        return mesaCap;
    }

    public void setMesaCap(int mesaCap) {
        this.mesaCap = mesaCap;
    }
}
