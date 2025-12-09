import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingreso de datos del sensor
        System.out.print("Ingrese ID del sensor: ");
        String id = sc.nextLine();

        System.out.print("Ingrese umbral bajo: ");
        double bajo = sc.nextDouble();

        System.out.print("Ingrese umbral alto: ");
        double alto = sc.nextDouble();

        Sensor s1 = new Sensor(id, bajo, alto);

        // Activar sensor
        s1.activar();

        // Ingresar lectura
        System.out.print("Ingrese lectura de temperatura (°C): ");
        double lectura = sc.nextDouble();
        s1.actualizarLectura(lectura);

        // Mostrar información
        s1.mostrarInfo();

        sc.close();
    }
}
