package com.game;

class EsclavoAlien extends Alien {
    public EsclavoAlien(int x, int y) {
        super(x, y, 50, 4);
    }

    @Override
    public void comportamientoAlMorir(Astronauta astronauta) {
        if (isMuerto()) {
            astronauta.recibirCura(); 
        }
    }
}
