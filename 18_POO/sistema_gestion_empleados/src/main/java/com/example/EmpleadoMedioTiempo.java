package com.example;


public class EmpleadoMedioTiempo extends Empleado implements Trabajable {
    private static final int HORAS_POR_DIA = 4;
    private static final double PAGO_POR_HORA = 10;

    public EmpleadoMedioTiempo(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar(int dias) throws Exception {
        if (dias < 0) {
            throw new Exception("No se pueden registrar días negativos.");
        }
        if (dias > 23) {
            throw new Exception("No se pueden registrar más de 23 días.");
        }
        this.diasTrabajados = dias;
        this.salario = calcularSalario();
    }

    @Override
    public double calcularSalario() {
        return this.diasTrabajados * HORAS_POR_DIA * PAGO_POR_HORA;
    }
}
