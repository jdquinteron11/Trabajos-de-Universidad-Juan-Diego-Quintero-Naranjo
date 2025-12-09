public class Libro {
    private String titulo;
    private String autor;
    private int numLibros;
    private int prestados;

    // Constructor con parámetros
    public Libro(String titulo, String autor, int numLibros) {
        this.titulo = titulo;
        this.autor = autor;
        this.numLibros = numLibros;
        this.prestados = 0;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public int getPrestados() {
        return prestados;
    }

    // Método préstamo
    public boolean prestar() {
        if (prestados < numLibros) {
            prestados++;
            return true;
        }
        return false;
    }

    // Método devolución
    public boolean devolver() {
        if (prestados > 0) {
            prestados--;
            return true;
        }
        return false;
    }

    // Modificar cantidad de libros
    public void modificarCantidad(int nuevaCantidad) {
        if (nuevaCantidad >= prestados) {
            this.numLibros = nuevaCantidad;
            System.out.println("Cantidad de libros actualizada a " + nuevaCantidad);
        } else {
            System.out.println("No se puede reducir por debajo de los libros prestados.");
        }
    }

    // Mostrar datos
    public void mostrarDatos() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Total libros: " + numLibros);
        System.out.println("Prestados: " + prestados);
    }
}
