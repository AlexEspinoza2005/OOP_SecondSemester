package com;

public class Impuesto {
    private double tasa;

    public Impuesto(double tasa) {
        this.tasa = tasa;
    }

    public double calcularImpuesto(double monto) {
        return monto * tasa;
    }
}
