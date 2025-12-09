public class Vehiculo {
    private String placa;
    private String marca;
    private double capacidadTanqueLitros;
    private double combustibleActual;
    private double kmPorLitro;

    // Constructor por defecto
    public Vehiculo() {
        this("", "", 1.0, 0.0, 1.0);
    }

    // Constructor parametrizado
    public Vehiculo(String placa, String marca, double capacidadTanqueLitros, double combustibleActual, double kmPorLitro) {
        this.placa = placa;
        this.marca = marca;
        this.capacidadTanqueLitros = (capacidadTanqueLitros > 0) ? capacidadTanqueLitros : 1.0;
        this.kmPorLitro = (kmPorLitro > 0) ? kmPorLitro : 1.0;
        if (combustibleActual < 0) {
            this.combustibleActual = 0.0;
        } else if (combustibleActual > this.capacidadTanqueLitros) {
            this.combustibleActual = this.capacidadTanqueLitros;
        } else {
            this.combustibleActual = combustibleActual;
        }
    }

    // Métodos
    public void recargar(double litros) {
        if (litros > 0) {
            combustibleActual += litros;
            if (combustibleActual > capacidadTanqueLitros) {
                combustibleActual = capacidadTanqueLitros;
            }
        }
    }

    public void conducir(double km) {
        if (km > 0) {
            double consumo = km / kmPorLitro;
            if (consumo <= combustibleActual) {
                combustibleActual -= consumo;
            } else {
                System.out.println("No hay suficiente combustible para recorrer " + km + " km.");
            }
        }
    }

    public double autonomia() {
        return Math.round(combustibleActual * kmPorLitro * 10.0) / 10.0;
    }

    public void mostrarInfo() {
        System.out.println(placa + " | Autonomía: " + autonomia() + " km.");
    }
}
