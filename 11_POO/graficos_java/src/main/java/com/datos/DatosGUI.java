package com.datos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DatosGUI extends JFrame {
    private JFreeChart chart;
    public DatosGUI() {
        String rutaArchivo = "radiacion.csv";
        AdminDatos adminDatos = new AdminDatos(rutaArchivo);
        List<RadiacionDTO> datos = adminDatos.cargarDatos();

        setTitle("Cambio de Radiación UV");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TimeSeries series = new TimeSeries("Radiación UV");
        for (RadiacionDTO punto : datos) {
            series.add(new Day(punto.getFecha()), punto.getRadiacion());
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        chart = ChartFactory.createTimeSeriesChart(
                "Radiación UV vs Fecha",
                "Fecha",
                "Radiación UV (Índice)",
                dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(900, 600));

        JButton saveButton = new JButton("Guardar Gráfico como PNG");
        saveButton.addActionListener(e -> guardarGrafico());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(chartPanel, BorderLayout.CENTER);

        JPanel panelBotones=new JPanel(new GridLayout(2, 3));
        panelBotones.add(saveButton);
        panelBotones.add(new JLabel(" Mes con más radiación: "+adminDatos.obtenerMesMayorRadiacion()));
        panelBotones.add(new JLabel("aaespinozac@utn.edu.ec"));
        panelBotones.add(new JLabel("Promedio anual de radiación: "+adminDatos.calcularPromedioAnual()));
        panelBotones.add(new JLabel("Máxima radiación: "+adminDatos.buscarMaximaRadiacion()));
        
        panelBotones.add(new JLabel("Mínima radiación: "+adminDatos.buscarMinimaRadiacion()));

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

        // aquí aseguré si la extensión .png no está presente pq al guardarla no lo hacía
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".png")) {
            fileToSave = new File(filePath + ".png"); // Agrega la extensión .png si no está presente
        }

        try {
            // Guardar el gráfico
            ChartUtils.saveChartAsPNG(fileToSave, chart, 900, 600);
            JOptionPane.showMessageDialog(this, "Gráfico guardado exitosamente.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el gráfico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


}
