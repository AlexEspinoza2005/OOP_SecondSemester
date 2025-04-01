package com.example;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto("camara", 100);
        Factura factura = new Factura(producto, 2, 0.18); 
        factura.mostrarFactura();
    }
}