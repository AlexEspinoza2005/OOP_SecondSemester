package com.example;

public class Producto {
    private String nombre;
    private float precio;

    public Producto (String nombre , float precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public float getPrecio(){
        return precio;
    }

}
