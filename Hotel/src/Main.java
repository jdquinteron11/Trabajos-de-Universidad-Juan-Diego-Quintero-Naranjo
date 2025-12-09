import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre del huésped: ");
        String huesped = sc.nextLine();

        System.out.print("Ingrese fecha de ingreso (YYYY-MM-DD): ");
        String fechaIngreso = sc.nextLine();
        LocalDate ingreso = LocalDate.parse(fechaIngreso);

        System.out.print("Ingrese fecha de salida (YYYY-MM-DD): ");
        String fechaSalida = sc.nextLine();
        LocalDate salida = LocalDate.parse(fechaSalida);

        System.out.print("Ingrese tarifa por noche: ");
        double tarifa = sc.nextDouble();

        ReservaHotel reserva = new ReservaHotel(huesped, ingreso, salida, tarifa);

        // Mostrar información inicial
        reserva.mostrarInfo();

        // Confirmar reserva
        System.out.print("¿Desea confirmar la reserva? (s/n): ");
        String opcion = sc.next();
        if (opcion.equalsIgnoreCase("s")) {
            reserva.confirmar();
        }

        // Cancelar reserva
        System.out.print("¿Desea cancelar la reserva? (s/n): ");
        opcion = sc.next();
        if (opcion.equalsIgnoreCase("s")) {
            reserva.cancelar();
        }

        // Mostrar estado final
        reserva.mostrarInfo();

        sc.close();
    }
}
