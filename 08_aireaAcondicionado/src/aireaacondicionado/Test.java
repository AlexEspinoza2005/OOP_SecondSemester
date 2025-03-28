package aireaacondicionado;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Test {
    private Scanner scanner;
    private AireAcondicionado aireAcondicionado;

    public void run() {
        scanner = new Scanner(System.in);
        aireAcondicionado = new AireAcondicionado();
        int opcion;

        do {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Seleccione la opción: (1) Ver estado (2) Encender (3) Apagar (4) Subir temperatura (5) Bajar temperatura (0) Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    aireAcondicionado.imprimirEstado();
                    break;
                case 2:
                    aireAcondicionado.encender();
                    break;
                case 3:
                    aireAcondicionado.apagar();
                    break;
                case 4:
                    aireAcondicionado.subirTemperatura();
                    break;
                case 5:
                    aireAcondicionado.bajarTemperatura();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }
}

