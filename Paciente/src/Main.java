import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese documento del paciente: ");
        String documento = sc.nextLine();

        System.out.print("Ingrese nombre del paciente: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();

        System.out.print("Ingrese nivel de triage (A–E): ");
        char triage = sc.next().charAt(0);

        Paciente p1 = new Paciente(documento, nombre, edad, triage);

        // Mostrar información inicial
        p1.mostrarInfo();

        // Opción de marcar atendido
        System.out.print("¿Desea marcar al paciente como atendido? (s/n): ");
        String opcion = sc.next();
        if (opcion.equalsIgnoreCase("s")) {
            p1.marcarAtendido();
        }

        // Mostrar estado final
        p1.mostrarInfo();

        sc.close();
    }
}
