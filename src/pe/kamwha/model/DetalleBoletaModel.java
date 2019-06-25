
package pe.kamwha.model;


public class DetalleBoletaModel {
    private String detalleBoleta;
    private BoletaModel boleta;
    private MenuModel menu;
    private float importe;

    public DetalleBoletaModel() {
    }

    public DetalleBoletaModel(String detalleBoleta, BoletaModel boleta, MenuModel menu, float importe) {
        this.detalleBoleta = detalleBoleta;
        this.boleta = boleta;
        this.menu = menu;
        this.importe = importe;
    }

    public String getDetalleBoleta() {
        return detalleBoleta;
    }

    public void setDetalleBoleta(String detalleBoleta) {
        this.detalleBoleta = detalleBoleta;
    }

    public BoletaModel getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaModel boleta) {
        this.boleta = boleta;
    }

    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
