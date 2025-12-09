public class Cuenta {
    private String titular;
    private String numero;
    private double saldo;
    private boolean activa;

    // Constructor con parámetros
    public Cuenta(String titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo > 0 ? saldo : 0.0;
        this.activa = true;
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    // Métodos de negocio
    public boolean depositar(double monto) {
        if (!activa) {
            System.out.println("La cuenta está bloqueada. No se puede operar.");
            return false;
        }
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (!activa) {
            System.out.println("La cuenta está bloqueada. No se puede operar.");
            return false;
        }
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void bloquear() {
        activa = false;
    }

    public void activar() {
        activa = true;
    }

    // Mostrar datos
    public void mostrarDatos() {
        System.out.printf("Cuenta %s | Saldo: %,.2f | Estado: %s%n",
                numero, saldo, activa ? "Activa" : "Bloqueada");
    }
}
