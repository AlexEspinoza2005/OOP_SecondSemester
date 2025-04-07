package com.game;
abstract class ObjetoJuego {
    protected int posicionX;
    protected int posicionY;

    public ObjetoJuego(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosition(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }
}
