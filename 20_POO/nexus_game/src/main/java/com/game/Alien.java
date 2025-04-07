package com.game;

abstract class Alien extends ObjetoJuego {
    protected int vida;
    protected int danio;

    public Alien(int x, int y, int vida, int danio) {
        super(x, y);
        this.vida = vida;
        this.danio = danio;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
    }

    public boolean isMuerto() {
        return vida <= 0;
    }

    public void moverse(int dx, int dy) {
        this.posicionX += dx;
        this.posicionY += dy;
    }

    public int getVida() { return vida; }
    public int getDanio() { return danio; }

    public abstract void comportamientoAlMorir(Astronauta astronauta);
}
