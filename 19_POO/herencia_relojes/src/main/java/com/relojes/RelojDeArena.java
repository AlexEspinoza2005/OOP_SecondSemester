package com.relojes;

public class RelojDeArena extends Reloj {

    public RelojDeArena(String nombre) {
        super(nombre);
    }

    @Override
    public String funcion() {
        return "Mide el tiempo con el flujo de arena.";
    }

    @Override
    public String interaccion() {
        return "Se voltea para reiniciar el conteo de tiempo.";
    }
}
