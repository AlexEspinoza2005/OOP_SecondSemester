package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

class PanelJuego extends JPanel {
    private static final int TAMANO_CELDA = 43;
    private static final int FILAS = 15;
    private static final int COLUMNAS = 15;
    private Nave nave;
    private Astronauta astronauta;
    private ArrayList<Alien> aliens;
    private Timer spawnTimer;
    private Timer movimientoAliensTimer;
    private Timer timerJuego;
    private int tiempoTranscurrido = 0;

    public PanelJuego() {
        this.setPreferredSize(new Dimension(COLUMNAS * TAMANO_CELDA + 350, FILAS * TAMANO_CELDA + 10));
        this.setBackground(Color.BLACK);
        this.nave = new Nave(COLUMNAS / 2, FILAS / 2);
        this.astronauta = new Astronauta(0, 0);
        this.aliens = new ArrayList<>();

        generarAlien();

        spawnTimer = new Timer(3000, e -> generarAlien());
        spawnTimer.start();

        movimientoAliensTimer = new Timer(1000, e -> {
            moverAliens();
            chequearColisiones();
            repaint();
        });
        movimientoAliensTimer.start();

        timerJuego = new Timer(1000, e -> {
            tiempoTranscurrido++;
        });
        timerJuego.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP -> moverAstronauta(0, -1);
                    case KeyEvent.VK_DOWN -> moverAstronauta(0, 1);
                    case KeyEvent.VK_LEFT -> moverAstronauta(-1, 0);
                    case KeyEvent.VK_RIGHT -> moverAstronauta(1, 0);
                }
            }
        });
    }

    private void generarAlien() {
        Random rand = new Random();
        int x;
        int y;

        if (rand.nextBoolean()) {
            x = 0;
        } else {
            x = COLUMNAS - 1;
        }

        if (rand.nextBoolean()) {
            y = 0;
        } else {
            y = FILAS - 1;
        }

        int tipoAlienAleatorio = (int) (Math.random() * 3);

        Alien alien;
        if (tipoAlienAleatorio == 0) {
            alien = new EsclavoAlien(x, y);
        } else if (tipoAlienAleatorio == 1) {
            alien = new SoldadoAlien(x, y);
        } else if (tipoAlienAleatorio == 2) {
            alien = new JefeAlien(x, y);
        } else {
            alien = new EsclavoAlien(x, y);
        }

        aliens.add(alien);
        repaint();
    }

    private void moverAliens() {
        for (Alien alien : aliens) {
            int dx = Integer.compare(nave.getPosicionX(), alien.getPosicionX());
            int dy = Integer.compare(nave.getPosicionY(), alien.getPosicionY());
            alien.moverse(dx, dy);
        }
    }

    private void moverAstronauta(int dx, int dy) {
        int nuevoX = astronauta.getPosicionX() + dx;
        int nuevoY = astronauta.getPosicionY() + dy;

        if (nuevoX >= 0 && nuevoX < COLUMNAS && nuevoY >= 0 && nuevoY < FILAS) {
            astronauta.moverse(dx, dy);
            chequearColisiones();
            repaint();
        }
    }

    private void chequearColisiones() {
        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            if (astronauta.getPosicionX() == alien.getPosicionX()
                    && astronauta.getPosicionY() == alien.getPosicionY()) {
                alien.recibirDanio(astronauta.getDanio());
                astronauta.perderVida(alien.getDanio());
                if (alien.isMuerto()) {
                    alien.comportamientoAlMorir(astronauta); 
                    aliens.remove(i);
                    i--;
                }
            }
        }

        for (Alien alien : aliens) {
            if (alien.getPosicionX() == nave.getPosicionX() && alien.getPosicionY() == nave.getPosicionY()) {
                nave.recibirDanio(alien.getDanio());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la cuadrícula del mapa
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                g.setColor(Color.DARK_GRAY);
                g.drawRect((j + 3) * TAMANO_CELDA, i * TAMANO_CELDA, TAMANO_CELDA, TAMANO_CELDA);
            }
        }

        // Dibujar la nave
        g.setColor(Color.BLUE);
        g.fillRect((nave.getPosicionX() + 3) * TAMANO_CELDA, nave.getPosicionY() * TAMANO_CELDA, TAMANO_CELDA,
                TAMANO_CELDA);

        // Dibujar al astronauta
        g.setColor(Color.GREEN);
        g.fillRect((astronauta.getPosicionX() + 3) * TAMANO_CELDA, astronauta.getPosicionY() * TAMANO_CELDA,
                TAMANO_CELDA, TAMANO_CELDA);

        // Dibujar los aliens
        for (Alien alien : aliens) {
            if (alien instanceof EsclavoAlien) {
                g.setColor(Color.CYAN);
            } else if (alien instanceof SoldadoAlien) {
                g.setColor(Color.ORANGE);
            } else if (alien instanceof JefeAlien) {
                g.setColor(Color.RED);
            }
            g.fillRect((alien.getPosicionX() + 3) * TAMANO_CELDA, alien.getPosicionY() * TAMANO_CELDA, TAMANO_CELDA,
                    TAMANO_CELDA);
        }

        int desplazamientoDerecha = COLUMNAS * TAMANO_CELDA + 150;
        g.setColor(Color.WHITE);
        g.drawString("Vida Nave: " + nave.getVida(), desplazamientoDerecha, 30);
        g.drawString("Aliens en el mapa: " + aliens.size(), desplazamientoDerecha, 50);
        g.drawString("Tiempo Transcurrido: " + tiempoTranscurrido, desplazamientoDerecha, 70);

        g.drawString("Astronauta: ", desplazamientoDerecha, 100);
        g.drawString("      Vida: " + astronauta.getVida(), desplazamientoDerecha, 120);
        g.drawString("      Daño: " + astronauta.getDanio(), desplazamientoDerecha, 140);
        int yInfo = 150;
        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            String tipo;

            if (alien instanceof EsclavoAlien) {
                tipo = "Esclavo";
            } else if (alien instanceof SoldadoAlien) {
                tipo = "Soldado";
            } else {
                tipo = "Jefe";
            }

            yInfo += 20;

            g.drawString("Alien " + (i + 1) + ":", desplazamientoDerecha, yInfo);
            yInfo += 20;

            g.drawString("      Tipo: " + tipo, desplazamientoDerecha, yInfo);
            yInfo += 20;
            g.drawString("      Vida: " + alien.getVida(), desplazamientoDerecha, yInfo);

            yInfo += 20;
        }

        int yCuadro = 30;
        g.setColor(Color.RED);
        g.fillRect(10, yCuadro, 20, 20);
        g.setColor(Color.WHITE);
        g.drawString("Jefe Alien", 35, yCuadro + 15);

        yCuadro += 40;

        g.setColor(Color.ORANGE);
        g.fillRect(10, yCuadro, 20, 20);
        g.setColor(Color.WHITE);
        g.drawString("Soldado Alien", 35, yCuadro + 15);
        yCuadro += 40;

        g.setColor(Color.CYAN);
        g.fillRect(10, yCuadro, 20, 20);
        g.setColor(Color.WHITE);
        g.drawString("Esclavo Alien", 35, yCuadro + 15);
        yCuadro += 40;

        g.setColor(Color.blue);
        g.fillRect(10, yCuadro, 20, 20);
        g.setColor(Color.WHITE);
        g.drawString("Nave", 35, yCuadro + 15);
        yCuadro += 40;

        g.setColor(Color.green);
        g.fillRect(10, yCuadro, 20, 20);
        g.setColor(Color.WHITE);
        g.drawString("Astronauta", 35, yCuadro + 15);
        
        if (astronauta.getVida() <= 0 || nave.getVida() <= 0 || tiempoTranscurrido >= 30) {
            spawnTimer.stop();
            movimientoAliensTimer.stop();

            String mensaje;
            if (tiempoTranscurrido >= 30) {
                mensaje = "¡Ganaste!";
            } else {
                mensaje = "¡Perdiste!";
            }

            int opcion = JOptionPane.showOptionDialog(this,
                    mensaje + " ¿Qué deseas hacer?",
                    "Fin del juego",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[] { "Continuar", "Salir" },
                    "Continuar");

            if (opcion == 1) {
                System.exit(0);
            } else if (opcion == 0) {
                astronauta.restaurarVida();
                nave.restaurarVida();
                aliens.clear();
                generarAlien();
                tiempoTranscurrido = 0;
                astronauta.restaurarDanio();
                spawnTimer.start();
                movimientoAliensTimer.start();
            }
        }

    }
}
