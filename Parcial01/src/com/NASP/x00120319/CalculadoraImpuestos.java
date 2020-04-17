package com.NASP.x00120319;

public final class CalculadoraImpuestos{
    private double totalRenta;
    private double totalISSS;
    private double totalAFP;

    private CalculadoraImpuestos(double totalRenta, double totalISSS, double totalAFP) {
        this.totalRenta = totalRenta;
        this.totalISSS = totalISSS;
        this.totalAFP = totalAFP;
    }

    public double calcularPago(Empleado e){
        double total = 0;
        return total;

    }

    public String mostrarTotales(){
        return "El total de los impuesto fue de: $" + totalRenta + totalISSS + totalAFP;
    }
}
