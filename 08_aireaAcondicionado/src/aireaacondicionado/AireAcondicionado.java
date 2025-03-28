package aireaacondicionado;

/**
 *
 * @author user
 */
public class AireAcondicionado {
    // Atributos
    private boolean encendido;
    private int temperatura; // Temperatura en grados (de 5 a 25)

    // Constructor
    public AireAcondicionado() {
        this.encendido = false; // Inicialmente apagado
        this.temperatura = 14; // Temperatura por defecto al encender
    }

    // Métodos
    public void encender() {
        if (!encendido) {
            encendido = true;
            temperatura = 14; // Restablece la temperatura a 14 grados al encender
            System.out.println("Aire acondicionado encendido. Temperatura por defecto: " + temperatura + " grados.");
        } else {
            System.out.println("El aire acondicionado ya está encendido.");
        }
    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("Aire acondicionado apagado.");
        } else {
            System.out.println("El aire acondicionado ya está apagado.");
        }
    }

    public void subirTemperatura() {
        if (encendido) {
            if (temperatura < 25) {
                temperatura++;
                System.out.println("Temperatura aumentada a: " + temperatura + " grados.");
            } else {
                System.out.println("La temperatura ya está en su máximo de 25 grados.");
            }
        } else {
            System.out.println("El aire acondicionado debe estar encendido para ajustar la temperatura.");
        }
    }

    public void bajarTemperatura() {
        if (encendido) {
            if (temperatura > 5) {
                temperatura--;
                System.out.println("Temperatura disminuida a: " + temperatura + " grados.");
            } else {
                System.out.println("La temperatura ya está en su mínimo de 5 grados.");
            }
        } else {
            System.out.println("El aire acondicionado debe estar encendido para ajustar la temperatura.");
        }
    }

    public void imprimirEstado() {
        String estado = encendido ? "Encendido" : "Apagado";
        System.out.println("Estado del aire acondicionado: " + estado + " - Temperatura actual: " + temperatura + " grados.");
    }
}
