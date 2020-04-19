package com.NASP.x00120319;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    static Scanner in = new java.util.Scanner(System.in);
    public static void main(String[] args) {

        boolean NatSol = false;

        do{
            try{
                NatSol = false;
                //Servicio Profesional
                JOptionPane.showConfirmDialog(null, "\t->Datos de Empleado en Servicio " +
                        "Profesional", "Servicio Profesional", JOptionPane.DEFAULT_OPTION);

                //Ingresando nombre
                String nombre = JOptionPane.showInputDialog(null, "\t\t-> Nombre:",
                        "Nombre", JOptionPane.DEFAULT_OPTION);
                if(nombre == null || nombre.isEmpty())
                    throw new NotFoundException("No existe un empleado");
                else if(cifra(nombre) || cifraDouble(nombre)){
                    throw new InsufficientException("Ingresaste el nombre incorrectamente");
                }

                //Ingresando puesto
                String puesto = JOptionPane.showInputDialog(null, "\t\t-> Puesto",
                        "Puesto", JOptionPane.DEFAULT_OPTION);

                if(puesto == null || puesto.isEmpty())
                    throw new NotFoundException("No existe el puesto");
                else if(cifra(puesto) || cifraDouble(puesto)){
                    throw new InsufficientException("Ingresaste el puesto incorrectamente");
                }

                //Ingresando salario

                Double salario = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "\t\t-> Salario: ", "Salario", JOptionPane.DEFAULT_OPTION));

                //Ingresando meses de contrato
                int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "\t\t-> Meses de contrato: ", "Meses de Contrato", JOptionPane.DEFAULT_OPTION));

                //Creando el objeto
                ServicioProfesional servicios = new ServicioProfesional(nombre, puesto, salario, mesesContrato);

                //Imprimiendo los getter
                JOptionPane.showConfirmDialog(null, "\t\t-> Nombre: " + servicios.getNombre()
                        + "\n\t-> Puesto: " + servicios.getPuesto() + "\n\t-> Salario actual: " + servicios.getSalario()
                        + "\n\t-> Meses de Contrato: " + servicios.getMesesContrato(),
                        "Datos", JOptionPane.DEFAULT_OPTION);

                //Calculando el salario
                JOptionPane.showConfirmDialog(null, "Su salario final es: $"
                        + CalculadoraImpuestos.calcularPago(servicios),
                        "Salario Final", JOptionPane.DEFAULT_OPTION);
                JOptionPane.showConfirmDialog(null, CalculadoraImpuestos.mostrarTotales());

                //Plaza fija
                JOptionPane.showConfirmDialog(null, "\t-> Datos de Empleado en Plaza Fija",
                        "Plaza fija", JOptionPane.DEFAULT_OPTION);

                //Ingresando nombre
                String nombre2 = JOptionPane.showInputDialog(null, "\t\t-> Nombre: ",
                        "Nombre", JOptionPane.DEFAULT_OPTION);
                if(nombre2 == null || nombre2.isEmpty())
                   throw new NotFoundException("No existe un empleado");
                else if(cifra(nombre2) || cifraDouble(nombre2)){
                   throw new InsufficientException("Ingresaste el nombre incorrectamente");
                }

                //Ingresando puesto
                String puesto2 = JOptionPane.showInputDialog(null, "\t\t-> Puesto",
                        "Puesto", JOptionPane.DEFAULT_OPTION);
                if(puesto2 == null || puesto2.isEmpty())
                   throw new NotFoundException("No existe el puesto");
                else if(cifra(puesto2) || cifraDouble(puesto2)){
                   throw new InsufficientException("Ingresaste el puesto incorrectamente");
                }

                //Ingresando salario
                double salario2 = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "\t\t-> Salario: ", "Salario", JOptionPane.DEFAULT_OPTION));

                //throw new NotFoundException("Ingreso el salario incorrectamente");

                //Ingresando extension
                int extension = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "\t\t-> Telefono: ", "Telefono", JOptionPane.DEFAULT_OPTION));


                //Creando el objeto
                PlazaFija plaza = new PlazaFija(nombre2, puesto2, salario2, extension);
                //Integer.parseInt(JOptionPane.showInputDialog(null, "\t\t-> Extension telefonica: "
                // + plaza.setExtension()));

                //Imprimiendo los getters
                JOptionPane.showConfirmDialog(null, "\t\t-> Nombre: " + plaza.getNombre()
                        + "\n\t-> Puesto: " + plaza.getPuesto() + "\n\t-> Salario actual: " + plaza.getSalario() +
                        "\n\t-> Extension: " + plaza.getExtension(), "Datos", JOptionPane.DEFAULT_OPTION);

                //Calculando el salario
                JOptionPane.showConfirmDialog(null, "Su salario final es: $"
                        + CalculadoraImpuestos.calcularPago(plaza), "Salario Final", JOptionPane.DEFAULT_OPTION);
                JOptionPane.showConfirmDialog(null, CalculadoraImpuestos.mostrarTotales());

            } catch(NumberFormatException exc){
                JOptionPane.showConfirmDialog(null, exc.getMessage() + "\n\t Error : Debe ingresar un valor numerico...",
                        "...", JOptionPane.DEFAULT_OPTION);
                NatSol = true;
            }
            catch(NotFoundException | InsufficientException exc){
                JOptionPane.showConfirmDialog(null, exc.getMessage() + "\n\t Cargando...",
                        "...", JOptionPane.DEFAULT_OPTION);
                NatSol = true;
            }


        }while (NatSol);

    }
    public static boolean cifra(String c){
        try {
            Integer.parseInt(c);
        }catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }
    public static boolean cifraDouble(String c){
        try {
            Double.parseDouble(c);
        }catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }

    public static double parseStringDouble( String valor){
        return valor == null || valor.isEmpty() ? Double.NaN : Double.parseDouble(valor);
    }



}
