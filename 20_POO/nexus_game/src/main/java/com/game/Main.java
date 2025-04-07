package com.game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion = JOptionPane.showOptionDialog(null, 
                "¡Bienvenido! ¿Qué deseas hacer?", 
                "Menú", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                new Object[] { "Jugar", "Salir" }, 
                "Jugar");

        if (opcion == 0) {
            JFrame frame = new JFrame("NexusPlane");
            PanelJuego panel = new PanelJuego();
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
