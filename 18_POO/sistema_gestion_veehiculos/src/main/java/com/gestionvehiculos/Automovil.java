package com.gestionvehiculos;

public class Automovil extends Vehiculo {

    public Automovil(String nombre) {
        super(nombre);
    }

    @Override
    public void acelerar(int veces) {
        contadorAceleracion += veces * 3; 
    }

    @Override
    public int calcularCostoMantenimiento() {
        return contadorAceleracion * 4; 
    }
}

