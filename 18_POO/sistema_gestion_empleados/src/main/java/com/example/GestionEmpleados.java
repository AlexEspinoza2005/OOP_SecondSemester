package com.example;

import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {
    private List<Empleado> empleados;

    public GestionEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public double calcularSalariosTotales() {
        double total = 0;
        for (Empleado e : empleados) {
            total += e.getSalario();
        }
        return total;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
