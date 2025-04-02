package com.vivos;

public class Herbivoro extends Animal {

    public Herbivoro(String nombre) {
        super(nombre);
    }

    @Override
    public String alimentarse() {
        return getNombre() + " se alimenta de plantas.";
    }

    @Override
    public String moverse() {
        return getNombre() + " camina o trota.";
    }
}