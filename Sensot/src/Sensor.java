public class Sensor {
    private String id;
    private double ultimaLecturaC;
    private double umbralAlto;
    private double umbralBajo;
    private boolean activo;

    // Constructor por defecto
    public Sensor() {
        this.id = "";
        this.ultimaLecturaC = 0.0;
        this.umbralBajo = 0.0;
        this.umbralAlto = 100.0;
        this.activo = false;
    }

    // Constructor parametrizado
    public Sensor(String id, double umbralBajo, double umbralAlto) {
        this.id = id;
        if (umbralBajo < umbralAlto) {
            this.umbralBajo = umbralBajo;
            this.umbralAlto = umbralAlto;
        } else {
            this.umbralBajo = 0.0;
            this.umbralAlto = 100.0;
        }
        this.ultimaLecturaC = 0.0;
        this.activo = false;
    }

    // Métodos
    public void actualizarLectura(double lectura) {
        if (activo) {
            this.ultimaLecturaC = lectura;
        }
    }

    public boolean enAlarma() {
        return (ultimaLecturaC < umbralBajo || ultimaLecturaC > umbralAlto);
    }

    public void activar() { this.activo = true; }
    public void desactivar() { this.activo = false; }

    public void mostrarInfo() {
        System.out.println(id + " | " + ultimaLecturaC + "°C | Alarma: " + enAlarma());
    }
}
