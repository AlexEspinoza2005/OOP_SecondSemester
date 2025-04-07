package com.game;
class Astronauta extends ObjetoJuego {
    private int vida;
    private int danio;

    public Astronauta(int x, int y) {
        super(x, y);
        this.vida = 200;
        this.danio = 10;
    }

    public void moverse(int dx, int dy) {
        this.posicionX += dx;
        this.posicionY += dy;
    }

    public int getDanio() {
        return danio;
    }

    public int getVida() {
        return vida;
    }

    public void perderVida(int cantidad) {
        vida -= cantidad;
    }

    public boolean isMuerto() {
        return vida <= 0;
    }

    public void restaurarVida() {
        this.vida = 200;  
    }
    public void recibirCura(){
        this.vida+=25;
    }

    public void incrementarDanio(int cantidad) {
        this.danio += cantidad;  
    }
    public void restaurarDanio() {
        this.danio = 10;
    }
}
