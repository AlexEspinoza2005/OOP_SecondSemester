package com.relojes;

public class RelojDeSol extends Reloj {

    public RelojDeSol(String nombre) {
        super(nombre);
    }

    @Override
    public String funcion() {
        return "Mide el tiempo usando la posición del sol.";
    }

    @Override
    public String interaccion() {
        return "Se ajusta según la ubicación para proyectar la hora.";
    }
}
