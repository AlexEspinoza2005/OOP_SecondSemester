package com.datos;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class RadiacionDTO {
    @CsvBindByName(column = "Fecha")
    @CsvDate("yyyy-MM-dd")
    private Date fecha;

    @CsvBindByName(column = "Radiación_UV (Índice)")
    private double radiacion;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getRadiacion() {
        return radiacion;
    }

    public void setRadiacion(double radiacion) {
        this.radiacion = radiacion;
    }
}