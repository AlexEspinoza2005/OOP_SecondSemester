package com.game;

class SoldadoAlien extends Alien {
    public SoldadoAlien(int x, int y) {
        super(x, y, 75, 6);
    }

    @Override
    public void comportamientoAlMorir(Astronauta astronauta) {
        if (isMuerto()) {
            astronauta.perderVida(20);  
        }
    }
}
