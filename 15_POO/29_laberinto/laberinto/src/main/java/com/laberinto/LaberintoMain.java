package com.laberinto;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
/**
 * Clase que inicia la ejecución y crea la estructura visual de la aplicación.
 */
public class LaberintoMain extends JFrame {
    private Menu menu;
    private PanelDibujo panelDibujo;
    public LaberintoMain(){
        setTitle("Laberinto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu=new Menu();
        add(menu,BorderLayout.NORTH);
        panelDibujo=new PanelDibujo();
        add(panelDibujo,BorderLayout.CENTER);
        menu.setActionListenerBtnGenerar(e->panelDibujo.generarLaberinto());
        menu.setActionListenerBtnIniciar(e->panelDibujo.resolverLaberinto());
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LaberintoMain laberinto = new LaberintoMain();
            laberinto.setVisible(true);
        });
    }
}
