import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear película
        Pelicula matrix = new Pelicula("Matrix", 1999, "R", 3);

        // Mostrar estado inicial
        System.out.println(matrix);

        // Cliente ingresa edad
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        // Intentar alquilar
        matrix.alquilar(edad);

        // Mostrar estado después del alquiler
        System.out.println(matrix);

        // Devolver
        System.out.print("¿Desea devolver la película? (s/n): ");
        String opcion = sc.next();
        if (opcion.equalsIgnoreCase("s")) {
            matrix.devolver();
        }

        // Mostrar estado final
        System.out.println(matrix);

        sc.close();
    }
}
