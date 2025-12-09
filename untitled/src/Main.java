import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear los 5 libros
        Libro[] biblioteca = new Libro[5];
        biblioteca[0] = new Libro("Luna de Plutón", "Dross", 3, 0);
        biblioteca[1] = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 0);
        biblioteca[2] = new Libro("El libro Nacho", "Desconocido", 2, 0);
        biblioteca[3] = new Libro("Clean Code", "Robert C. Martin", 4, 0);
        biblioteca[4] = new Libro("Fundamentos de Java", "Luis Joyanes", 6, 0);

        int opcion;
        do {
            System.out.println("\n Bienvenido a la biblioteca virtual de javaQuintel selecciona los siguientes apartados:");

            System.out.println("\n  Seleccione una opción:");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Editar datos de un libro (Administrador)");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Mostrar todos los libros
                    for (int i = 0; i < biblioteca.length; i++) {
                        System.out.println((i+1) + ". " + biblioteca[i].getNombre() +
                                " (" + biblioteca[i].getAutor() + ")");
                        System.out.println("   Ejemplares: " + biblioteca[i].getNumEjemplares() +
                                " | Prestados: " + biblioteca[i].getNumPrestados());
                    }
                    break;

                case 2:
                    // Prestar un libro
                    System.out.println("Ingrese el número del libro que desea prestar:");
                    int numPrestamo = sc.nextInt();
                    if (numPrestamo >= 1 && numPrestamo <= biblioteca.length) {
                        if (biblioteca[numPrestamo-1].prestar()) {
                            System.out.println(" Préstamo realizado de \"" + biblioteca[numPrestamo-1].getNombre() + "\"");
                        } else {
                            System.out.println(" No hay ejemplares disponibles.");
                        }
                    } else {
                        System.out.println("⚠️ Número inválido.");
                    }
                    break;

                case 3:
                    // Devolver un libro
                    System.out.println("Ingrese el número del libro que desea devolver:");
                    int numDevolucion = sc.nextInt();
                    if (numDevolucion >= 1 && numDevolucion <= biblioteca.length) {
                        if (biblioteca[numDevolucion-1].devolver()) {
                            System.out.println(" Devolución realizada de \"" + biblioteca[numDevolucion-1].getNombre() + "\"");
                        } else {
                            System.out.println(" No hay libros prestados para devolver.");
                        }
                    } else {
                        System.out.println("⚠️ Número inválido.");
                    }
                    break;

                case 4:
                    System.out.println("⚠️ Acceso de administrador requerido ingresa contraseña.");
                    String password = sc.nextLine();
                    if (password != "12345") {
                        System.out.println("⚠️ Contraseña incorrecta. Acceso denegado.");
                        break;
                    }
                    // Editar datos de un libro usando setters
                    System.out.println("Ingrese el número del libro que desea editar:");
                    int numEditar = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    if (numEditar >= 1 && numEditar <= biblioteca.length) {
                        Libro libro = biblioteca[numEditar-1];

                        System.out.println("Nuevo nombre del libro:");
                        String nuevoNombre = sc.nextLine();
                        libro.setNombre(nuevoNombre);

                        System.out.println("Nuevo autor del libro:");
                        String nuevoAutor = sc.nextLine();
                        libro.setAutor(nuevoAutor);

                        System.out.println("Nuevo número de ejemplares:");
                        int nuevosEjemplares = sc.nextInt();
                        libro.setNumEjemplares(nuevosEjemplares);

                        System.out.println("Nuevo número de prestados:");
                        int nuevosPrestados = sc.nextInt();
                        libro.setNumPrestados(nuevosPrestados);

                        System.out.println(" Datos actualizados correctamente.");
                    } else {
                        System.out.println(" Número inválido.");
                    }
                    break;

                case 0:
                    System.out.println(" Saliendo del sistema...");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 0);

        // Mostrar marcador final
        System.out.println("\n MARCADOR FINAL - Libros disponibles en la biblioteca:");
        int totalDisponibles = 0;
        for (Libro libro : biblioteca) {
            int disponibles = libro.getNumEjemplares() - libro.getNumPrestados();
            System.out.println("los libros " + libro.getNombre() + " → Disponibles: " + disponibles);
            totalDisponibles += disponibles;
        }
        System.out.println(" Total de ejemplares disponibles en toda la biblioteca: " + totalDisponibles);

        sc.close();
    }
}

class Libro {
    private String nombre;
    private String autor;
    private int numEjemplares;
    private int numPrestados;

    public Libro(String nombre, String autor, int numEjemplares, int numPrestados) {
        this.nombre = nombre;
        this.autor = autor;
        this.numEjemplares = Math.max(0, numEjemplares);
        this.numPrestados = Math.min(numPrestados, numEjemplares);
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getAutor() { return autor; }
    public int getNumEjemplares() { return numEjemplares; }
    public int getNumPrestados() { return numPrestados; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setNumEjemplares(int numEjemplares) {
        if (numEjemplares >= numPrestados) {
            this.numEjemplares = numEjemplares;
        } else {
            System.out.println(" No puedes asignar menos ejemplares que los ya prestados.");
        }
    }
    public void setNumPrestados(int numPrestados) {
        if (numPrestados <= numEjemplares) {
            this.numPrestados = numPrestados;
        } else {
            System.out.println(" No puedes asignar más prestados que ejemplares.");
        }
    }

    // Métodos préstamo y devolución
    public boolean prestar() {
        if (numPrestados < numEjemplares) {
            numPrestados++;
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (numPrestados > 0) {
            numPrestados--;
            return true;
        }
        return false;
    }
}
