package com.laberinto;

import javax.swing.JOptionPane;
/**
 * Clase utilitaria para la aplicación Laberinto
 */
public class LaberintoUtil {
    public static void mostrarAlertaInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Laberinto", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mostrarAlertaError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Laberinto", JOptionPane.ERROR_MESSAGE);
    }
}
