package com.vivos;

public abstract class SerVivo {
    private String nombre;

    public SerVivo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String alimentarse();
    public abstract String moverse();
}