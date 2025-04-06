package com.relojes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HerenciaSwingDemo extends JFrame {
    private JComboBox<String> tipoRelojCombo;
    private JTextArea outputArea;

    public HerenciaSwingDemo() {
        setTitle("Demostración de Herencia y Polimorfismo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Selecciona un reloj:");
        topPanel.add(label);

        tipoRelojCombo = new JComboBox<>(new String[] { "Reloj de Sol", "Reloj Digital", "Reloj de Arena" });
        topPanel.add(tipoRelojCombo);

        JButton mostrarButton = new JButton("Mostrar Información");
        mostrarButton.addActionListener(new MostrarButtonListener());
        topPanel.add(mostrarButton);

        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private class MostrarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String seleccion = (String) tipoRelojCombo.getSelectedItem();
            Reloj reloj;

            // Polimorfismo: Crear el objeto según la selección
            switch (seleccion) {
                case "Reloj de Sol":
                    reloj = new RelojDeSol("Reloj de Sol");
                    break;
                case "Reloj Digital":
                    reloj = new RelojDigital("Reloj Digital");
                    break;
                case "Reloj de Arena":
                    reloj = new RelojDeArena("Reloj de Arena");
                    break;
                default:
                    reloj = null;
            }

            if (reloj != null) {
                outputArea.setText("");
                outputArea.append("Nombre: " + reloj.getNombre() + "\n");
                outputArea.append("Función: " + reloj.funcion() + "\n");
                outputArea.append("Interacción: " + reloj.interaccion() + "\n");
            }
        }
    }
}
