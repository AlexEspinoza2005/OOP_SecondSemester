package com.laberinto;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Clase que implementa la funcionalidad de dibujo para el
 * laberinto. Define el panel donde se dibujarán
 * las diferentes figuras.
 * 
 * @author Mauricio Rea
 */
public class PanelDibujo extends JPanel {
    Laberinto laberinto;

    public PanelDibujo() {
        laberinto = new Laberinto();
    }

    public void generarLaberinto(){
        laberinto.generarLaberinto();
        repaint();
    }

        /**
     * Metodo que dibuja un bloque dependiendo del tipo.
     * 
     * @param posX  posición x inicial del bloque.
     * @param posY  posicion y inicial del bloque.
     * @param alto  altura del bloque.
     * @param ancho anchura del bloque.
     * @param tipo  tipo de bloque: pared, camino o caminante.
     */
    private void dibujarBloque(Graphics graphics,int posX, int posY, int ancho, int alto, int tipo) {
        switch (tipo) {
            case 0:
                graphics.setColor(Color.WHITE);
                break;
            case 1:
                graphics.setColor(Color.DARK_GRAY);
                break;
            case 2:
                graphics.setColor(Color.YELLOW);
                break;
        }
        graphics.fillRect(posX, posY, ancho, alto);
        graphics.setColor(Color.RED);
        graphics.drawRect(posX, posY, ancho, alto);
    }

    public void dibujarLaberinto(Graphics graphics) {
        int anchoBloque = getWidth() / Laberinto.COLUMNAS;
        int altoBloque = getHeight() / Laberinto.FILAS;

        for (int i = 0; i < Laberinto.FILAS; i++) {
            for (int j = 0; j < Laberinto.COLUMNAS; j++) {
                int tipo = laberinto.getMatriz()[i][j];
                dibujarBloque(graphics, j * anchoBloque, i * altoBloque, anchoBloque, altoBloque, tipo);
            }
        }
    }

    public void resolverLaberinto(){
        int filaInicio=laberinto.getFilaInicio();
        int columnaInicio=laberinto.getColumnaInicio();
        laberinto.resolverLaberinto(filaInicio, columnaInicio);
        repaint();
        if(laberinto.isResuelto())
            LaberintoUtil.mostrarAlertaInfo("Se ha encontrado la salida!!");
        else
            LaberintoUtil.mostrarAlertaError("El laberinto no tiene solución.");
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //Se actualizan los datos gráficos del panel:
        System.out.println("anchoPanel: "+getWidth()+" altoPanel:"+getHeight());
        dibujarLaberinto(graphics);
    }

}
