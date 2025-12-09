public class Libro {
    // Atributos privados
    private String nombre;
    private String autor;
    private int numEjemplares;
    private int numPrestados;

    // Constructor por defecto
    public Libro() {
        this.nombre = "";
        this.autor = "";
        this.numEjemplares = 0;
        this.numPrestados = 0;
    }

    // Constructor con parámetros
    public Libro(String nombre, String autor, int numEjemplares, int numPrestados) {
        this.nombre = nombre;
        this.autor = autor;
        this.numEjemplares = Math.max(0, numEjemplares);
        this.numPrestados = Math.min(numPrestados, numEjemplares); // No puede haber más prestados que ejemplares
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public int getNumPrestados() {
        return numPrestados;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumEjemplares(int numEjemplares) {
        if (numEjemplares >= numPrestados) {
            this.numEjemplares = numEjemplares;
        }
    }

    public void setNumPrestados(int numPrestados) {
        if (numPrestados <= numEjemplares) {
            this.numPrestados = numPrestados;
        }
    }

    // Método préstamo
    public boolean prestar() {
        if (numPrestados < numEjemplares) {
            numPrestados++;
            return true;
        }
        return false;
    }

    // Método devolución
    public boolean devolver() {
        if (numPrestados > 0) {
            numPrestados--;
            return true;
        }
        return false;
    }

    // Mostrar datos del libro
    public void mostrarDatos() {
        System.out.println("📚 Libro: " + nombre);
        System.out.println("✍️ Autor: " + autor);
        System.out.println("📦 Ejemplares: " + numEjemplares);
        System.out.println("📤 Prestados: " + numPrestados);
    }
}
