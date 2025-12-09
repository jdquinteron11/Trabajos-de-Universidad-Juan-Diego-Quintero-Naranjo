public class Estudiante {
    private String id;
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private Double promedioManual; // opcional: si el usuario lo ingresa

    // Constructor por defecto
    public Estudiante() {
        this("", "", 0.0, 0.0, 0.0);
    }

    // Constructor parametrizado
    public Estudiante(String id, String nombre, double nota1, double nota2, double nota3) {
        this.id = id;
        this.nombre = nombre;
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
        this.promedioManual = null;
    }

    // Setters con validación (0.0–5.0)
    public void setNota1(double nota1) { this.nota1 = validarNota(nota1); }
    public void setNota2(double nota2) { this.nota2 = validarNota(nota2); }
    public void setNota3(double nota3) { this.nota3 = validarNota(nota3); }

    public void setPromedioManual(double promedio) {
        this.promedioManual = validarNota(promedio);
    }

    private double validarNota(double nota) {
        if (nota < 0.0) return 0.0;
        if (nota > 5.0) return 5.0;
        return nota;
    }

    // Métodos de lógica
    public double getPromedio() {
        double base = (promedioManual != null)
                ? promedioManual
                : (nota1 + nota2 + nota3) / 3.0;
        return Math.round(base * 10.0) / 10.0; // una cifra decimal
    }

    public boolean aprobado() {
        return getPromedio() >= 3.0;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Prom: " + getPromedio() + " | "
                + (aprobado() ? "Aprobado." : "Reprobado."));
    }

    // Getters básicos (por si los necesitas)
    public String getId() { return id; }
    public String getNombre() { return nombre; }
}
