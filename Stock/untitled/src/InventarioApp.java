import java.util.Scanner;

public class InventarioApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear producto de ejemplo
        Producto producto = new Producto("P01", "Teclado", 20, 59.90);

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar stock");
            System.out.println("2. Vender producto");
            System.out.println("3. Descontinuar producto");
            System.out.println("4. Activar producto");
            System.out.println("5. Mostrar datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a ingresar: ");
                    int cantidadIngreso = scanner.nextInt();
                    producto.ingresar(cantidadIngreso);
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVenta = scanner.nextInt();
                    producto.vender(cantidadVenta);
                    break;

                case 3:
                    producto.descontinuar();
                    break;

                case 4:
                    producto.activar();
                    break;

                case 5:
                    producto.mostrarDatos();
                    break;

                case 6:
                    System.out.println("¡Gracias por usar el inventario!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

