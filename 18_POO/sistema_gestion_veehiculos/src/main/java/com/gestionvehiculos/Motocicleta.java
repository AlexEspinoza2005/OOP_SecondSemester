package com.gestionvehiculos;

public class Motocicleta extends Vehiculo {

    public Motocicleta(String nombre) {
        super(nombre);
    }

    @Override
    public void acelerar(int veces) {
        contadorAceleracion += veces;  
    }

    @Override
    public int calcularCostoMantenimiento() {
        return contadorAceleracion;  
    }
}
