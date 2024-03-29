package pago;

import java.util.Scanner;

public class PasarelaDePago {

    public static void procesarPago(double importeTotal) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecciona la forma de pago \n 1. Efectivo \n 2. Tarjeta");
        int forma = sc.nextInt(); // Escoge la opcion de pago
        sc.nextLine();
        
        switch (forma) {
            case 1:
                pagoEnEfectivo(importeTotal);
                break;
            case 2:
                pagoConTarjeta(sc);
                break;
            default:
                System.out.println("Opción no válida.");
        }
        
        sc.close();
    }

    private static void pagoEnEfectivo(double importeTotal) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Ha seleccionado pagar en efectivo \nPor favor indique la cantidad que va entregar");
            double cantidadEntrega = sc.nextDouble(); // Toma la cantidad que entrega el cliente para pagar en efectivo
            
            if (cantidadEntrega < importeTotal) {
                System.out.println("Importe insuficiente. Por favor, asegúrese de entregar la cantidad correcta.\n");
            } else {
                double resultado = (cantidadEntrega - importeTotal);
                resultado = Math.round(resultado * 100.0) / 100.0;

                System.out.println("Su cambio es " + resultado + " euros");

                // Calculamos los billetes que vamos a entregar
                double[] valoresBilletes = {500, 200, 100, 50, 20, 10, 5};
                for (double valor : valoresBilletes) {
                    if (resultado >= valor) {
                        double cantidadBilletes = Math.floor(resultado / valor);
                        System.out.println("Número de billetes de " + valor + " euros: " + (int) cantidadBilletes);
                        resultado -= cantidadBilletes * valor;
                        resultado = Math.round(resultado * 100.0) / 100.0;
                    }
                }

                // Calculamos las monedas que vamos a entregar
                double[] valoresMonedas = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
                for (double valor : valoresMonedas) {
                    if (resultado >= valor) {
                        double cantidadMonedas = Math.floor(resultado / valor);
                        System.out.println("Número de monedas de " + valor + " euros: " + (int) cantidadMonedas);
                        resultado -= cantidadMonedas * valor;
                        resultado = Math.round(resultado * 100.0) / 100.0;
                    }
                }
                break; // Salir del bucle si la cantidad entregada es suficiente
            }
        } while (true);

        sc.close();
    }

    private static void pagoConTarjeta(Scanner sc) {
        String tarjeta = "";
        
        while (true) {
            System.out.println("Ha seleccionado pagar con tarjeta.");
            System.out.println("Ingrese 3 si va a pagar con American Express.");
            System.out.println("Ingrese 4 si va a pagar con Visa.");
            System.out.println("Ingrese 5 si va a pagar con MasterCard.");

            tarjeta = sc.nextLine();

            // Verificar si la opción ingresada es válida
            if (tarjeta.equals("3") || tarjeta.equals("4") || tarjeta.equals("5")) {
                break; // Salir del bucle si la opción es válida
            } else {
                System.out.println("La opción seleccionada no es válida.\n\nPor favor, seleccione una de las opciones propuestas.\n");
            }
        }

        String tipoTarjeta;
        switch (tarjeta) {
            case "3":
                tipoTarjeta = "American Express";
                validarTarjetaAE(sc, tipoTarjeta);
                break;
            case "4":
                tipoTarjeta = "Visa";
                validarTarjetaVisa(sc, tipoTarjeta);
                break;
            case "5":
                tipoTarjeta = "MasterCard";
                validarTarjetaMC(sc, tipoTarjeta);
                break;
            default:
                tipoTarjeta = "desconocida";
        }
    }
    
    private static void validarTarjetaAE(Scanner sc, String tipoTarjeta) {
        while (true) {
            System.out.println("Por favor, introduzca el número de tarjeta " + tipoTarjeta + ":");
            String numeroTarjeta = sc.nextLine();

            if (numeroTarjeta.matches("[0-9]{15}$")) {
                System.out.println("Número de tarjeta " + tipoTarjeta + " válido.\n");
                break;
            } else {
                System.out.println("Número de tarjeta " + tipoTarjeta + " no válido. Introducir unicamente los 15 números de su tarjeta.");
            }
        }
    }
    
    private static void validarTarjetaVisa(Scanner sc, String tipoTarjeta) {
        while (true) {
            System.out.println("Por favor, introduzca el número de tarjeta " + tipoTarjeta + ":");
            String numeroTarjeta = sc.nextLine();

            if (numeroTarjeta.matches("[0-9]{16}$")) {
                System.out.println("Número de tarjeta " + tipoTarjeta + " válido.\n");
                break;
            } else {
                System.out.println("Número de tarjeta " + tipoTarjeta + " no válido. Introducir unicamente los 16 números de su tarjeta.");
            }
        }
    }
    
    private static void validarTarjetaMC(Scanner sc, String tipoTarjeta) {
        while (true) {
            System.out.println("Por favor, introduzca el número de tarjeta " + tipoTarjeta + ":");
            String numeroTarjeta = sc.nextLine();

            if (numeroTarjeta.matches("[0-9]{16}$")) {
                System.out.println("Número de tarjeta " + tipoTarjeta + " válido.\n");
                break;
            } else {
                System.out.println("Número de tarjeta " + tipoTarjeta + " no válido. Introducir unicamente los 16 números de su tarjeta.");
            }
        }
    }
}