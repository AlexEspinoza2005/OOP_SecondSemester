package com.laberinto;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
/**
 * Menu principal de la aplicación Protector de pantalla.
 * Permite al usuario interactuar con la aplicación.
 */
public class Menu extends JPanel {
    private JButton btnGenerar;
    private JButton btnIniciar;

    public Menu() {
        btnGenerar = new JButton("Generar laberinto");
        btnIniciar = new JButton("Resolver");
        
        // Agregar los botones al panel
        add(btnGenerar);
        add(btnIniciar);
    }

    public void setActionListenerBtnGenerar(ActionListener actionListener) {
        btnGenerar.addActionListener(actionListener);
    }

    public void setActionListenerBtnIniciar(ActionListener actionListener) {
        btnIniciar.addActionListener(actionListener);
    }

}
