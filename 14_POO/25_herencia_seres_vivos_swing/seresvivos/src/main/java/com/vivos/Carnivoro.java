package com.vivos;

public class Carnivoro extends Animal {

    public Carnivoro(String nombre) {
        super(nombre);
    }

    @Override
    public String alimentarse() {
        return getNombre() + " se alimenta de otros animales.";
    }

    @Override
    public String moverse() {
        return getNombre() + " corre rápidamente.";
    }
}