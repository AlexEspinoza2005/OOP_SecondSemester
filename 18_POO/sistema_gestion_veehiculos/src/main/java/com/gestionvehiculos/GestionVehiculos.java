package com.gestionvehiculos;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculos {
    private List<Vehiculo> vehiculos;

    public GestionVehiculos() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public int calcularCostoTotalMantenimiento() {
        int total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.calcularCostoMantenimiento();
        }
        return total;
    }
}
