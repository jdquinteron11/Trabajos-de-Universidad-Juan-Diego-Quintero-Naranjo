import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cuenta de ejemplo
        Cuenta cuenta = new Cuenta("Juan Diego", "123-4", 1_250_000.00);

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Bloquear cuenta");
            System.out.println("4. Activar cuenta");
            System.out.println("5. Mostrar datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    if (cuenta.depositar(deposito)) {
                        System.out.println("Depósito exitoso.");
                    } else {
                        System.out.println("Depósito inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (cuenta.retirar(retiro)) {
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("Retiro inválido o saldo insuficiente.");
                    }
                    break;

                case 3:
                    cuenta.bloquear();
                    System.out.println("Cuenta bloqueada.");
                    break;

                case 4:
                    cuenta.activar();
                    System.out.println("Cuenta activada.");
                    break;

                case 5:
                    cuenta.mostrarDatos();
                    break;

                case 6:
                    System.out.println("¡Gracias por usar el banco!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
