package com.vivos;

public class Planta extends SerVivo {

    public Planta(String nombre) {
        super(nombre);
    }



    @Override
    public String moverse() {
        return getNombre() + " no se mueve.";
    }



    @Override
    public String alimentarse() {
        return getNombre() + " realiza fotosíntesis para alimentarse.";
    }
}