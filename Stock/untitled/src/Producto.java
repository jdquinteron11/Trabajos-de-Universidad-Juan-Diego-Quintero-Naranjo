public class Producto {
    private String codigo;
    private String nombre;
    private int stock;
    private double precioUnitario;
    private boolean activo;

    // Constructor por defecto
    public Producto() {
        this.codigo = "";
        this.nombre = "";
        this.stock = 0;
        this.precioUnitario = 0.0;
        this.activo = true;
    }

    // Constructor con parámetros (validando precio y stock)
    public Producto(String codigo, String nombre, int stock, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock >= 0 ? stock : 0;
        this.precioUnitario = precioUnitario >= 0 ? precioUnitario : 0.0;
        this.activo = true;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getPrecioUnitario() {
        return String.format("$%.2f", precioUnitario);
    }

    public boolean isActivo() {
        return activo;
    }

    // Métodos de negocio
    public void ingresar(int cantidad) {
        if (activo && cantidad > 0) {
            stock += cantidad;
            System.out.println("Ingreso exitoso. Stock actualizado.");
        } else {
            System.out.println("No se puede ingresar productos.");
        }
    }

    public boolean vender(int cantidad) {
        if (!activo) {
            System.out.println("El producto está descontinuado.");
            return false;
        }
        if (cantidad > 0 && cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Venta realizada.");
            return true;
        }
        System.out.println("Stock insuficiente o cantidad inválida.");
        return false;
    }

    public void descontinuar() {
        activo = false;
        System.out.println("Producto descontinuado.");
    }

    public void activar() {
        activo = true;
        System.out.println("Producto activado nuevamente.");
    }

    // Mostrar datos
    public void mostrarDatos() {
        System.out.printf("%s - %s | stock: %d | %s | Estado: %s%n",
                codigo, nombre, stock, getPrecioUnitario(), activo ? "Activo" : "Descontinuado");
    }
}
