package com.datos;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDatos {
    private String rutaArchivo;

    public AdminDatos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<RadiacionDTO> cargarDatos() {
        List<RadiacionDTO> datos = new ArrayList<>();
        try {
            Reader reader = new InputStreamReader(AdminDatos.class.getClassLoader().getResourceAsStream(rutaArchivo));
            CsvToBean<RadiacionDTO> csvToBean = new CsvToBeanBuilder<RadiacionDTO>(reader)
                    .withType(RadiacionDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            datos = csvToBean.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }
    
    public String obtenerMesMayorRadiacion() {
        List<RadiacionDTO> datos = cargarDatos();
        int mesMayor = 0;
        double promedioMayor = 0;
    
        for (int i = 1; i <= 12; i++) {
            int contador = 0;
            double promedio = 0;
            double suma = 0;
            for (RadiacionDTO r : datos) {
                // si coincide el mes:
                if (r.getFecha().getMonth() + 1 == i) {
                    suma += r.getRadiacion();
                    contador++;
                }
            }
            if (contador > 0)
                promedio = suma / contador;
            
            // Redondeo a dos decimales
            promedio = Math.round(promedio * 100.0) / 100.0;
            
            if (promedio > promedioMayor) {
                mesMayor = i;
                promedioMayor = promedio;
            }
        }
        // Redondeo a dos decimales también en el resultado final
        return Month.of(mesMayor).toString() + " : " + promedioMayor;
    }

    //usaré +1 en ambos métodos porque no existe el mes 0

    public String buscarMinimaRadiacion() {
        List<RadiacionDTO> datos = cargarDatos();
        if (datos.isEmpty()) {
            throw new IllegalStateException("No hay datos");
        }
    
        double rMin = Double.MAX_VALUE;
        int mesMin = 0;
    
        // Buscar la radiación mínima y el mes correspondiente
        for (RadiacionDTO r : datos) {
            if (r.getRadiacion() < rMin) {
                rMin = r.getRadiacion();
                mesMin = r.getFecha().getMonth()+1; // Obtener solo el mes
            }
        }
    
        // Redondear la radiación mínima a dos decimales
        rMin = Math.round(rMin * 100.0) / 100.0;
    
        //retornar una cadena xd
        return rMin + " en " + Month.of(mesMin).toString();
    }
    

    
    
    public String buscarMaximaRadiacion() {
        List<RadiacionDTO> datos = cargarDatos();
        if (datos.isEmpty()) {
            throw new IllegalStateException("No hay datos disponibles.");
        }
    
        double rMax = Double.MIN_VALUE;
        int mesMax = 0;
    
        // Buscar la radiación máxima y el mes correspondiente
        for (RadiacionDTO r : datos) {
            if (r.getRadiacion() > rMax) {
                rMax = r.getRadiacion();
                mesMax = r.getFecha().getMonth()+1; // Obtener solo el mes
            }
        }
    
        // Redondear la radiación máxima a dos decimales
        rMax = Math.round(rMax * 100.0) / 100.0;
    
        // Retornar el resultado en el mismo formato que 'obtenerMesMayorRadiacion()'
        return rMax + " en " + Month.of(mesMax).toString();
    }
    
    

    
    public double calcularPromedioAnual() {
        List<RadiacionDTO> datos = cargarDatos();
        if (datos.isEmpty()) {
            throw new IllegalStateException("No hay datos");
        }
    
        double suma = 0;
    
        for (RadiacionDTO r : datos) {
            suma += r.getRadiacion();
        }
    
        // Redondear el promedio anual a 2 decimales
        return Math.round((suma / datos.size()) * 100.0) / 100.0;
    }
    
    public Map<Month, Double> calcularPromediosMensuales(List<RadiacionDTO> datos) {
    Map<Month, Double> promediosMensuales = new HashMap<>();
    
    for (int i = 1; i <= 12; i++) {
        int contador = 0;
        double suma = 0;
        
        for (RadiacionDTO r : datos) {
            if (r.getFecha().getMonth() == i - 1  ) { // Mes es 0-indexed
                suma += r.getRadiacion();
                contador++;
            }
        }
        
        if (contador > 0) {
            double promedio = suma / contador;
            promediosMensuales.put(Month.of(i), Math.round(promedio * 100.0) / 100.0);
        } else {
            promediosMensuales.put(Month.of(i), 0.0); // Si no hay datos para ese mes
        }
    }
    return promediosMensuales;
}

    


}
 