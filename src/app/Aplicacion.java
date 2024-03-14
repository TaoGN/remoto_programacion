package app;

import data.GestionClientes;
import data.GestionPedido;
import data.Mensajes;
import java.util.Scanner;

/**
 * @author Aleja
 * La clase Aplicacion representa la aplicación principal de la pizzería.
 * Permite a los usuarios interactuar con la aplicación, realizar pedidos y procesar pagos.
 */
public class Aplicacion {
    /**
     * Método principal de la aplicación.
     * Permite a los usuarios interactuar con la aplicación, realizar pedidos y procesar pagos.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("<<<<< ¡Bienvenido a pizzeria Alessandro! >>>>>\n");
        System.out.println("¿Que desea?\n");
        
        boolean opcionSeleccionada = false;

        // Bucle principal para manejar las opciones del menú
        while (!opcionSeleccionada) {
            System.out.println("Seleccione 1 para ver nuestras promociones.");
            System.out.println("Seleccione 2 para ver información sobre nuestra pizzeria.");
            System.out.println("Seleccione 3 para realizar un pedido.");
            
            int seleccion = scanner.nextInt();
            scanner.nextLine();
        
            GestionClientes gestionClientes = new GestionClientes();     
            GestionPedido gestionPedido = new GestionPedido();

            switch (seleccion) {      	
                case 1:
                    // Mostrar promociones
                    System.out.println("Ha seleccionado ver nuestras promociones:\n");
                    Mensajes.promocion();
                    break;
                case 2:
                    // Mostrar información sobre la pizzería
                    System.out.println("Ha seleccionado ver información sobre nuestra pizzeria:\n");
                    Mensajes.informacion();
                    break;
                case 3:
                    // Realizar un pedido
                    System.out.println("Ha seleccionado realizar un pedido, para ello primero necesitamos conocer sus datos:");
                    gestionClientes.crearCliente();
                    gestionPedido.realizarPedido();
                    opcionSeleccionada = true; // Establecer la opción seleccionada como verdadera para salir del bucle
                    break;
                default:
                    System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas");
                    break;
            }
        }

        scanner.close();
    }
}