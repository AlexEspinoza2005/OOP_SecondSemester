package com.gestionvehiculos;

public abstract class Vehiculo implements Acelerable {
    protected String nombre;
    protected int contadorAceleracion;

    public Vehiculo(String nombre) {
        this.nombre = nombre;
        this.contadorAceleracion = 0;
    }

    public int getContadorAceleracion() {
        return contadorAceleracion;
    }

    public abstract int calcularCostoMantenimiento();
}
