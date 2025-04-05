
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.EmpleadoMedioTiempo;
import com.example.EmpleadoTiempoCompleto;
import com.example.GestionEmpleados;

public class EmpleadoMedioTiempoTest {

    @Test
    public void invalidarNumerosNegativos() {
        try {
            EmpleadoMedioTiempo eM = new EmpleadoMedioTiempo("Alex xd");
            eM.trabajar(-2);
        } catch (Exception e) {
            assertEquals("No se pueden registrar días negativos.", e.getMessage());
        }
    }

    @Test
    public void invalidarDiasNoTrabajables() {
        try {
            EmpleadoMedioTiempo e = new EmpleadoMedioTiempo("Pablo ");
            e.trabajar(25);
        } catch (Exception e) {
            assertEquals("No se pueden registrar más de 23 días.", e.getMessage());
        }
    }

    @Test
    public void validarTrabajoTiempoCompleto() throws Exception {
        EmpleadoTiempoCompleto e = new EmpleadoTiempoCompleto("Alex Espinoza");
        e.trabajar(20);
        assertEquals(1600, e.calcularSalario(), 0.01);
    }

    @Test
    public void validarTrabajoMedioTiempo() throws Exception {
        EmpleadoMedioTiempo e = new EmpleadoMedioTiempo("Alex Espinoza");
        e.trabajar(21);
        assertEquals(840, e.calcularSalario(), 0.01);
    }

    @Test
    public void testCalculoTotalSalarios() {
        GestionEmpleados gestion = new GestionEmpleados();

        EmpleadoTiempoCompleto emp1 = new EmpleadoTiempoCompleto("Empleado1");
        EmpleadoTiempoCompleto emp2 = new EmpleadoTiempoCompleto("Empleado2");
        EmpleadoMedioTiempo emp3 = new EmpleadoMedioTiempo("Empleado3");
        EmpleadoMedioTiempo emp4 = new EmpleadoMedioTiempo("Empleado4");

        try {
            emp1.trabajar(20);
            emp2.trabajar(19);
            emp3.trabajar(22);
            emp4.trabajar(21);
        } catch (Exception e) {
            System.out.println("Error al registrar días: " + e.getMessage());
        }

        gestion.agregarEmpleado(emp1);
        gestion.agregarEmpleado(emp2);
        gestion.agregarEmpleado(emp3);
        gestion.agregarEmpleado(emp4);

        double totalSalarios = gestion.calcularSalariosTotales();
        assertEquals(4840.0, totalSalarios, 0.01);
    }
}
