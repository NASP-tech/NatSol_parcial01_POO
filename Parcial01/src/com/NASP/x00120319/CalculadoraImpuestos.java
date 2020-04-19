package com.NASP.x00120319;

public final class CalculadoraImpuestos{
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;
    private double total;

    private CalculadoraImpuestos(){}

    public static double calcularPago(Empleado e){
        double salario, AFP = 0, renta = 0, ISSS = 0, restante = 0;
        salario = e.getSalario();

        if(e instanceof ServicioProfesional) {
            renta = e.getSalario()*0.1;
            totalRenta += renta;
            salario -= renta;
            //salario -= e.getSalario()-renta;
        }else {
            AFP = e.getSalario()*0.625;
            totalAFP += AFP;
            ISSS = e.getSalario()*0.3;
            totalISSS += ISSS;
            restante = e.getSalario()-AFP-ISSS;

            //Haciendo uso del Diagrama de Descuentos DFD
            if(restante >= 0 && restante <= 472)
                salario -= restante-renta;
                //salario -= e.getSalario()-restante;
            else if(restante >= 472 && restante <= 895){
                renta = 0.1*(restante-472) + 17.67;
                totalRenta += renta;
                salario -= restante-renta;
                //salario -= e.getSalario()-restante-renta;
            }
            else if(restante >= 895 && restante <= 2038){
                renta = 0.2*(restante-895.24)+60;
                totalRenta += renta;
                salario -= restante-renta;
                //salario -= e.getSalario()-restante-renta;
            }
            else {
                renta = 0.2*(restante-895.24)+60;
                totalRenta += renta;
                salario -= restante-renta;
                //salario -= e.getSalario()-restante-renta;
            }

        }
        /*double total = totalAFP+ totalISSS + totalRenta;*/
        return salario;

    }

    public static String mostrarTotales(){
        return "El total de los impuesto fue de: " + "\n\t-> AFP= $" + totalAFP +
                "\n\t-> ISSS= $" + totalISSS + "\n\t-> Renta= $" + totalRenta;
    }


}
