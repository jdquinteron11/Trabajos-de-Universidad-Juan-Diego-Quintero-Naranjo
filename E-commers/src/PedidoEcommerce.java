public class PedidoEcommerce {
    private String id;
    private int unidades;
    private double precioUnitario;
    private double costoEnvio;
    private boolean pagado;

    // Constructor por defecto
    public PedidoEcommerce() {
        this.id = "";
        this.unidades = 1; // mínimo 1
        this.precioUnitario = 0.0;
        this.costoEnvio = 0.0;
        this.pagado = false;
    }

    // Constructor parametrizado
    public PedidoEcommerce(String id, int unidades, double precioUnitario, double costoEnvio) {
        this.id = id;
        setUnidades(unidades);
        setPrecioUnitario(precioUnitario);
        setCostoEnvio(costoEnvio);
        this.pagado = false;
    }

    // Setters con validación
    public void setUnidades(int unidades) {
        this.unidades = (unidades >= 1) ? unidades : 1;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = (precioUnitario >= 0.0) ? precioUnitario : 0.0;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = (costoEnvio >= 0.0) ? costoEnvio : 0.0;
    }

    // Getters (valores inmutables)
    public String getId() { return id; }
    public int getUnidades() { return unidades; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getCostoEnvio() { return costoEnvio; }
    public boolean isPagado() { return pagado; }

    // Métodos de lógica
    public double total() {
        return Math.round((unidades * precioUnitario + costoEnvio) * 100.0) / 100.0;
    }

    public void pagar() {
        if (total() > 0) {
            pagado = true;
        }
    }

    public void cancelar() {
        if (!pagado) {
            unidades = 0;
            precioUnitario = 0.0;
            costoEnvio = 0.0;
        } else {
            System.out.println("No se puede cancelar un pedido ya pagado.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Pedido " + id + " | Total: $" + total() + " | Pagado: " + pagado);
    }
}
