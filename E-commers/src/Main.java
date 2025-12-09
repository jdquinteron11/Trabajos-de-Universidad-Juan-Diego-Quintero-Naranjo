import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingreso de datos del pedido
        System.out.print("Ingrese ID del pedido: ");
        String id = sc.nextLine();

        System.out.print("Ingrese número de unidades: ");
        int unidades = sc.nextInt();

        System.out.print("Ingrese precio unitario: ");
        double precioUnitario = sc.nextDouble();

        System.out.print("Ingrese costo de envío: ");
        double costoEnvio = sc.nextDouble();

        PedidoEcommerce pedido = new PedidoEcommerce(id, unidades, precioUnitario, costoEnvio);

        // Mostrar información inicial
        pedido.mostrarInfo();

        // Opción de pago
        System.out.print("¿Desea pagar el pedido? (s/n): ");
        String opcion = sc.next();
        if (opcion.equalsIgnoreCase("s")) {
            pedido.pagar();
        }

        // Opción de cancelación
        System.out.print("¿Desea cancelar el pedido? (s/n): ");
        opcion = sc.next();
        if (opcion.equalsIgnoreCase("s")) {
            pedido.cancelar();
        }

        // Mostrar estado final
        pedido.mostrarInfo();

        sc.close();
    }
}
