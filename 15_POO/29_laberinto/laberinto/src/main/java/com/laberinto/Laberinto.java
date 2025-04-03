package com.laberinto;

import java.util.Random;
/**
 * Clase que encapsula la lógica de funcionamiento del laberinto. Integra al componente
 * Graphics, de manera que se puedan dibujar los elementos del laberinto.
 */
public class Laberinto {
    private int[][] matriz;
    public static final int FILAS = 20;
    public static final int COLUMNAS = 40;
    private boolean laberintoResuelto;
    private int filaInicio;
    private int columnaInicio;
    private int filaSalida;
    private int columnaSalida;

    public Laberinto() {
        matriz = new int[FILAS][COLUMNAS];
        laberintoResuelto = false;
        generarLaberinto();// laberinto inicial
    }

    /**
     * Metodo que genera un laberinto de manera aleatoria.
     * Las paredes están representadas por 1 y el camino por 0.
     */
    public void generarLaberinto() {
        Random random = new Random();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                //Aleatoriamente se generan las paredes y caminos, considerando que los números
                //randómicos van de 0 a 3, se toman los valores de 0, 1 y 2 para camino, de 
                //manera que haya más posibilidad de generar un laberinto con solución.
                int aleatorio = random.nextInt(4);
                if (aleatorio < 3)
                    matriz[i][j] = 0;
                else
                    matriz[i][j] = 1;
            }
        }
        // cerramos todo el contorno:
        for (int i = 0; i < FILAS; i++) {
            matriz[i][0] = 1;
            matriz[i][COLUMNAS - 1] = 1;
        }
        for (int j = 0; j < COLUMNAS; j++) {
            matriz[0][j] = 1;
            matriz[FILAS - 1][j] = 1;
        }
        // entrada al laberinto:
        filaInicio = random.nextInt(1,FILAS-1);
        columnaInicio = 0;
        matriz[filaInicio][columnaInicio] = 0;
        // salida al laberinto:
        filaSalida = random.nextInt(1,FILAS-1);
        columnaSalida = COLUMNAS - 1;
        matriz[filaSalida][columnaSalida] = 0;
        laberintoResuelto=false;
    }

    public void resolverLaberinto(int filaActual, int columnaActual) {
        if (laberintoResuelto == true)
            return;
        if (columnaActual < 0 || columnaActual >= COLUMNAS)
            return;
        if (filaActual < 0 || filaActual >= FILAS)
            return;
        if (matriz[filaActual][columnaActual] == 1)
            return; // es pared
        if (matriz[filaActual][columnaActual] == 2)
            return; // ya está recorrido

        // si es camino, nos ubicamos en esa posición:
        matriz[filaActual][columnaActual] = 2;
        if (filaActual == filaSalida && columnaActual == columnaSalida) {
            System.out.println("salida encontrada!");
            laberintoResuelto = true;
            return;
        }
        //intentar recursivamente el resto de caminos:
        resolverLaberinto(filaActual - 1, columnaActual);// arriba
        resolverLaberinto(filaActual, columnaActual + 1);// derecha
        resolverLaberinto(filaActual + 1, columnaActual);// abajo
        resolverLaberinto(filaActual, columnaActual - 1);// izquierda
    }

    public final int[][] getMatriz() {
        return matriz;
    }

    public boolean isResuelto() {
        return laberintoResuelto;
    }

    public int getFilaInicio() {
        return filaInicio;
    }

    public int getColumnaInicio() {
        return columnaInicio;
    }
}
