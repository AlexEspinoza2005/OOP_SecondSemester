package com.relojes;

public abstract class Reloj {
    private String nombre;

    public Reloj(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String funcion();
    public abstract String interaccion();
}
