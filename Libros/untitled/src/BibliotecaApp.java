import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de libros con unidades diferentes
        ArrayList<Libro> biblioteca = new ArrayList<>();
        biblioteca.add(new Libro("El Karina", "Germán Castro Caicedo", 10));
        biblioteca.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 5));
        biblioteca.add(new Libro("La Vorágine", "José Eustasio Rivera", 7));
        biblioteca.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 3));

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Adquirir libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Modificar cantidad de libros");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro que desea adquirir: ");
                    String tituloDeseado = scanner.nextLine();
                    boolean encontrado = false;
                    for (Libro libro : biblioteca) {
                        if (tituloDeseado.equalsIgnoreCase(libro.getTitulo())) {
                            encontrado = true;
                            if (libro.prestar()) {
                                System.out.println("¡Préstamo exitoso!");
                            } else {
                                System.out.println("No hay ejemplares disponibles.");
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ese libro no está en la biblioteca.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el título del libro que desea devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : biblioteca) {
                        if (tituloDevolver.equalsIgnoreCase(libro.getTitulo())) {
                            encontrado = true;
                            if (libro.devolver()) {
                                System.out.println("Devolución realizada.");
                            } else {
                                System.out.println("No hay libros prestados para devolver.");
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ese libro no está en la biblioteca.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el título del libro que desea modificar: ");
                    String tituloModificar = scanner.nextLine();
                    encontrado = false;
                    for (Libro libro : biblioteca) {
                        if (tituloModificar.equalsIgnoreCase(libro.getTitulo())) {
                            encontrado = true;
                            System.out.print("Ingrese la nueva cantidad total de libros: ");
                            int nuevaCantidad = scanner.nextInt();
                            libro.modificarCantidad(nuevaCantidad);
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ese libro no está en la biblioteca.");
                    }
                    break;

                case 4:
                    for (Libro libro : biblioteca) {
                        libro.mostrarDatos();
                        System.out.println("-------------------");
                    }
                    break;

                case 5:
                    System.out.println("¡Gracias por usar la biblioteca!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}


