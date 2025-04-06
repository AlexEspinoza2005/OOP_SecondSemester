package com.relojes;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HerenciaSwingDemo frame = new HerenciaSwingDemo();
            frame.setVisible(true);
        });
    }
}
