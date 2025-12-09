public class Pelicula {
    private String titulo;
    private int anio;
    private String clasificacion;
    private int copias;
    private int alquiladas;

    // Constructor
    public Pelicula(String titulo, int anio, String clasificacion, int copias) {
        if (anio < 1900) {
            throw new IllegalArgumentException("El año debe ser mayor o igual a 1900.");
        }
        this.titulo = titulo;
        this.anio = anio;
        this.clasificacion = clasificacion;
        this.copias = copias;
        this.alquiladas = 0;
    }

    // Método alquilar
    public boolean alquilar(int edadCliente) {
        int edadMinima = 0;
        switch (clasificacion) {
            case "G": edadMinima = 0; break;
            case "PG13": edadMinima = 13; break;
            case "R": edadMinima = 17; break;
        }

        if (edadCliente < edadMinima) {
            System.out.println("No permitido: edad insuficiente para " + clasificacion);
            return false;
        }
        if (alquiladas < copias) {
            alquiladas++;
            System.out.println("Has alquilado: " + titulo);
            return true;
        } else {
            System.out.println("No hay copias disponibles.");
            return false;
        }
    }

    // Método devolver
    public void devolver() {
        if (alquiladas > 0) {
            alquiladas--;
            System.out.println("Has devuelto: " + titulo);
        }
    }

    // Mostrar estado
    @Override
    public String toString() {
        return titulo + " (" + clasificacion + ") | disp: " + (copias - alquiladas) + "/" + copias;
    }
}
