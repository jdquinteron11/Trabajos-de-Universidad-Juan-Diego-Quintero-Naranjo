import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese placa: ");
        String placa = sc.nextLine();

        System.out.print("Ingrese marca: ");
        String marca = sc.nextLine();

        System.out.print("Ingrese capacidad del tanque (litros): ");
        double capacidad = sc.nextDouble();

        System.out.print("Ingrese combustible actual (litros): ");
        double combustible = sc.nextDouble();

        System.out.print("Ingrese rendimiento (km por litro): ");
        double rendimiento = sc.nextDouble();

        Vehiculo v1 = new Vehiculo(placa, marca, capacidad, combustible, rendimiento);

        // Mostrar autonomía inicial
        v1.mostrarInfo();

        // Ejemplo de interacción
        System.out.print("¿Cuántos litros desea recargar?: ");
        double recarga = sc.nextDouble();
        v1.recargar(recarga);
        v1.mostrarInfo();

        System.out.print("¿Cuántos km desea conducir?: ");
        double km = sc.nextDouble();
        v1.conducir(km);
        v1.mostrarInfo();

        sc.close();
    }
}
