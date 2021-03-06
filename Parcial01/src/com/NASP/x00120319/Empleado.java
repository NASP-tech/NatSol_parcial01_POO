package com.NASP.x00120319;

public abstract class Empleado {
    protected String nombre;
    protected String puesto;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre(){
        return nombre;
    }

    public String getPuesto(){
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salary){
        this.salario = salary;
    }
}
