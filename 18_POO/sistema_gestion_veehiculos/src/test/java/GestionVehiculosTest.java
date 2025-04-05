
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.gestionvehiculos.Automovil;
import com.gestionvehiculos.GestionVehiculos;
import com.gestionvehiculos.Motocicleta;

public class GestionVehiculosTest {

    @Test
    public void testAceleracionAutomovil() {
        Automovil auto = new Automovil("Toyota");
        auto.acelerar(2);
        assertEquals(6, auto.getContadorAceleracion()); 
    }

    @Test
    public void testAceleracionMotocicleta() {
        Motocicleta moto = new Motocicleta("Yamaha");
        moto.acelerar(4);
        assertEquals(4, moto.getContadorAceleracion());
    }

    @Test
public void testCostoMantenimientoAutomovil() {
    Automovil auto = new Automovil("Honda");
    auto.acelerar(10); 
    assertEquals(30 * 4, auto.calcularCostoMantenimiento()); 
}


    @Test
    public void testCostoMantenimientoMotocicleta() {
        Motocicleta moto = new Motocicleta("Ducati");
        moto.acelerar(20);
        assertEquals(20, moto.calcularCostoMantenimiento());
    }

    @Test
public void testCostoTotalMantenimiento() {
    GestionVehiculos gestion = new GestionVehiculos();

    Automovil auto1 = new Automovil("Mazda");
    Automovil auto2 = new Automovil("Ford");
    Motocicleta moto1 = new Motocicleta("Suzuki");
    Motocicleta moto2 = new Motocicleta("Kawasaki");

    auto1.acelerar(2); 
    auto2.acelerar(3);  
    moto1.acelerar(1); 
    moto2.acelerar(5);  

    gestion.agregarVehiculo(auto1);
    gestion.agregarVehiculo(auto2);
    gestion.agregarVehiculo(moto1);
    gestion.agregarVehiculo(moto2);

    int totalCosto = gestion.calcularCostoTotalMantenimiento();
    assertEquals(66, totalCosto);
}

}
