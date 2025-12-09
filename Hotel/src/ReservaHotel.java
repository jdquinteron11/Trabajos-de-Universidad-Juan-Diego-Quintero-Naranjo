import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaHotel {
    private String huesped;
    private LocalDate ingreso;
    private LocalDate salida;
    private double tarifaNoche;
    private boolean confirmada;

    // Constructor por defecto
    public ReservaHotel() {
        this.huesped = "";
        this.ingreso = LocalDate.now();
        this.salida = ingreso.plusDays(1);
        this.tarifaNoche = 0.0;
        this.confirmada = false;
    }

    // Constructor parametrizado
    public ReservaHotel(String huesped, LocalDate ingreso, LocalDate salida, double tarifaNoche) {
        this.huesped = huesped;
        setIngreso(ingreso);
        setSalida(salida);
        setTarifaNoche(tarifaNoche);
        this.confirmada = false;
    }

    // Setters con validación
    public void setIngreso(LocalDate ingreso) {
        this.ingreso = ingreso;
        if (salida != null && !salida.isAfter(ingreso)) {
            this.salida = ingreso.plusDays(1);
        }
    }

    public void setSalida(LocalDate salida) {
        if (salida.isAfter(ingreso)) {
            this.salida = salida;
        } else {
            this.salida = ingreso.plusDays(1);
        }
    }

    public void setTarifaNoche(double tarifaNoche) {
        this.tarifaNoche = (tarifaNoche >= 0.0) ? tarifaNoche : 0.0;
    }

    // Getters
    public String getHuesped() { return huesped; }
    public LocalDate getIngreso() { return ingreso; }
    public LocalDate getSalida() { return salida; }
    public double getTarifaNoche() { return tarifaNoche; }
    public boolean isConfirmada() { return confirmada; }

    // Métodos de lógica
    public long noches() {
        return ChronoUnit.DAYS.between(ingreso, salida);
    }

    public double total() {
        return Math.round(noches() * tarifaNoche * 100.0) / 100.0;
    }

    public void confirmar() {
        if (noches() > 0 && tarifaNoche > 0) {
            confirmada = true;
        }
    }

    public void cancelar() {
        if (!confirmada) {
            System.out.println("Reserva cancelada (no estaba confirmada).");
        } else {
            long horasAntes = ChronoUnit.HOURS.between(LocalDate.now().atStartOfDay(), ingreso.atStartOfDay());
            if (horasAntes >= 48) {
                confirmada = false;
                System.out.println("Reserva cancelada con éxito.");
            } else {
                System.out.println("No se puede cancelar: menos de 48h antes del ingreso.");
            }
        }
    }

    public void mostrarInfo() {
        System.out.println(noches() + " noches | $" + total());
    }
}
