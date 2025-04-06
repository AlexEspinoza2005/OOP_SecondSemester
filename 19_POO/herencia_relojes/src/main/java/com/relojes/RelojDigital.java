package com.relojes;

public class RelojDigital extends Reloj {

    public RelojDigital(String nombre) {
        super(nombre);
    }

    @Override
    public String funcion() {
        return "Muestra la hora en formato digital.";
    }

    @Override
    public String interaccion() {
        return "Permite ajustar alarmas y configurar la pantalla.";
    }
}
