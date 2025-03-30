package com.datos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DatosGUI2 extends JFrame {
    private JFreeChart chart;

    public DatosGUI2() {
        String rutaArchivo = "radiacion.csv";
        AdminDatos adminDatos = new AdminDatos(rutaArchivo);
        List<RadiacionDTO> datos = adminDatos.cargarDatos();
        Map<Month, Double> promediosMensuales = adminDatos.calcularPromediosMensuales(datos);

        setTitle("Cambio de Radiación UV");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Month> mesesOrdenados = new ArrayList<>(promediosMensuales.keySet());
        Collections.sort(mesesOrdenados);

        for (Month mes : mesesOrdenados) {
            dataset.addValue(promediosMensuales.get(mes), "Radiación UV Promedio", mes.name());
        }

        chart = ChartFactory.createBarChart(
                "Radiación UV Promedio por Mes",
                "Mes",
                "Radiación UV (Índice)",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(900, 600));

        JButton saveButton = new JButton("Guardar Gráfico como PNG");
        saveButton.addActionListener(e -> guardarGrafico());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(chartPanel, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3));
        panelBotones.add(saveButton);
        panelBotones.add(new JLabel("Mes con más radiación: " + adminDatos.obtenerMesMayorRadiacion()));
        panelBotones.add(new JLabel("aaespinozac@utn.edu.ec"));
        panelBotones.add(new JLabel("Promedio anual de radiación: " + adminDatos.calcularPromedioAnual()));
        panelBotones.add(new JLabel("Máxima radiación: " + adminDatos.buscarMaximaRadiacion()));
        panelBotones.add(new JLabel("Mínima radiación (sin Julio): " + adminDatos.buscarMinimaRadiacion()));

        mainPanel.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setVisible(true);
    }

    private void guardarGrafico() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Gráfico como PNG");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".png")) {
                fileToSave = new File(filePath + ".png");
            }

            try {
                ChartUtils.saveChartAsPNG(fileToSave, chart, 900, 600);
                JOptionPane.showMessageDialog(this, "Gráfico guardado exitosamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el gráfico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
