public class Paciente {
    private String documento;
    private String nombre;
    private int edad;
    private char nivelTriage; // A–E
    private boolean atendido;

    // Constructor por defecto
    public Paciente() {
        this.documento = "";
        this.nombre = "";
        this.edad = 0;
        this.nivelTriage = 'E'; // por defecto
        this.atendido = false;
    }

    // Constructor parametrizado
    public Paciente(String documento, String nombre, int edad, char nivelTriage) {
        this.documento = documento;
        this.nombre = nombre;
        setEdad(edad);
        setNivelTriage(nivelTriage);
        this.atendido = false;
    }

    // Setters con validación
    public void setEdad(int edad) {
        this.edad = (edad >= 0) ? edad : 0;
    }

    public void setNivelTriage(char nivelTriage) {
        nivelTriage = Character.toUpperCase(nivelTriage);
        if (nivelTriage >= 'A' && nivelTriage <= 'E') {
            this.nivelTriage = nivelTriage;
        } else {
            this.nivelTriage = 'E'; // valor por defecto
        }
    }

    // Getters
    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public char getNivelTriage() { return nivelTriage; }
    public boolean isAtendido() { return atendido; }

    // Métodos de lógica
    public int prioridad() {
        switch (nivelTriage) {
            case 'A': return 1;
            case 'B': return 2;
            case 'C': return 3;
            case 'D': return 4;
            case 'E': return 5;
            default: return 5;
        }
    }

    public void marcarAtendido() {
        this.atendido = true;
    }

    public void mostrarInfo() {
        System.out.println("Triage " + nivelTriage + " | Prioridad " + prioridad() + " | Atendido: " + atendido);
    }
}
