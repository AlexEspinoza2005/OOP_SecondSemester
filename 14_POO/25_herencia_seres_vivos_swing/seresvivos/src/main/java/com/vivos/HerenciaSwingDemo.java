package com.vivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HerenciaSwingDemo extends JFrame {
    private JComboBox<String> tipoSerVivoCombo;
    private JTextArea outputArea;

    public HerenciaSwingDemo() {
        setTitle("Demostración de Herencia y Polimorfismo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Selecciona un ser vivo:");
        topPanel.add(label);

        tipoSerVivoCombo = new JComboBox<>(new String[] { "Planta", "Herbívoro", "Carnívoro" });
        topPanel.add(tipoSerVivoCombo);

        JButton mostrarButton = new JButton("Mostrar Comportamiento");
        mostrarButton.addActionListener(new MostrarButtonListener());
        topPanel.add(mostrarButton);

        add(topPanel, BorderLayout.NORTH);

        // Área de texto para resultados
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    // Clase interna para manejar el botón
    private class MostrarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String seleccion = (String) tipoSerVivoCombo.getSelectedItem();
            SerVivo serVivo;

            // Polimorfismo: Crear el objeto según la selección
            switch (seleccion) {
                case "Planta":
                    serVivo = new Planta("Rosa");
                    break;
                case "Herbívoro":
                    serVivo = new Herbivoro("Conejo");
                    break;
                case "Carnívoro":
                    serVivo = new Carnivoro("León");
                    break;
                default:
                    serVivo = null;
            }

            if (serVivo != null) {
                outputArea.setText("");
                outputArea.append("Nombre: " + serVivo.getNombre() + "\n");
                outputArea.append("Alimentación: " + serVivo.alimentarse() + "\n");
                outputArea.append("Movimiento: " + serVivo.moverse() + "\n");
            }
        }
    }
}