import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lectura de texto
        System.out.print("Ingrese ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine().trim();

        // Lectura de notas con validación
        double n1 = leerNota(sc, "Ingrese nota1 (0.0–5.0): ");
        double n2 = leerNota(sc, "Ingrese nota2 (0.0–5.0): ");
        double n3 = leerNota(sc, "Ingrese nota3 (0.0–5.0): ");

        Estudiante e1 = new Estudiante(id, nombre, n1, n2, n3);

        // Consumir salto de línea pendiente por seguridad
        sc.nextLine();

        System.out.print("¿Desea ingresar promedio manual? (s/n): ");
        String opcion = sc.nextLine().trim();

        if (opcion.equalsIgnoreCase("s")) {
            double prom = leerNota(sc, "Ingrese promedio (0.0–5.0): ");
            e1.setPromedioManual(prom);
            // Consumir salto de línea pendiente
            sc.nextLine();
        }

        e1.mostrarInfo();

        sc.close();
    }

    // Utilidad para leer y validar una nota (maneja errores y rango)
    private static double leerNota(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                // validación suave: el setter recorta extremos, aquí prevenimos
                if (valor >= 0.0 && valor <= 5.0) {
                    return valor;
                } else {
                    System.out.println("Valor fuera de rango. Debe estar entre 0.0 y 5.0.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número (ej: 4.3).");
            }
            sc.next(); // limpia el token inválido o avanza
        }
    }
}
