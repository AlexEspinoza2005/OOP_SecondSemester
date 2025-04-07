package com.game;


class Nave extends ObjetoJuego {
    private int vida;

    public Nave(int x, int y) {
        super(x, y);
        this.vida = 250;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
    }

    public boolean isDestruida() {
        return vida <= 0;
    }

    public int getVida() {
        return vida;
    }
    public void restaurarVida() {
        this.vida = 200;
    }
    
    
}
