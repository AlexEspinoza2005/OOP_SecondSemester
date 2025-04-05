package com.example;


public abstract class Empleado {
    protected String nombre;
    protected int diasTrabajados;
    protected double salario;
    
    public Empleado(String nombre) {
        this.nombre = nombre;
        this.diasTrabajados = 0;
        this.salario = 0;
    }
    
    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }
}
