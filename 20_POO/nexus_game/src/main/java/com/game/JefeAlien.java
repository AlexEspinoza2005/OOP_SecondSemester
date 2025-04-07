package com.game;


class JefeAlien extends Alien {

    public JefeAlien(int x, int y) {
        super(x, y, 100, 9);
    }

    @Override
    public void comportamientoAlMorir(Astronauta astronauta) {
        if (isMuerto()) {
            astronauta.incrementarDanio(10);  
            astronauta.recibirCura(); 
        }
    }
}
