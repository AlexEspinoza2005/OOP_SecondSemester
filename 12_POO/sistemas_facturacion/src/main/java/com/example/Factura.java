package com.example;

import com.Impuesto;

public class Factura {
    private Producto producto;
    private int cantidad;
    private Impuesto impuesto;

    public Factura(Producto producto, int cantidad, double tasaImpuesto){
        this.producto = producto;
        this.cantidad = cantidad;
        this.impuesto = new Impuesto(tasaImpuesto);


    }
    public double calcularTotal() {
        double subtotal = producto.getPrecio() * cantidad;
        double impuestoAplicado = impuesto.calcularImpuesto(subtotal);
        return subtotal + impuestoAplicado;
    }

    public void mostrarFactura() {
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: " + producto.getPrecio());
        System.out.println("Total con impuesto: " + calcularTotal());
    }

}
