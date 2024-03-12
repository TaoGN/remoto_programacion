package app;

import data.GestionClientes;
import data.GestionPedido;
import logic.Cliente;
import java.util.Scanner;
/**
 * @author Aleja
 * Esta clase representa la aplicación de la pizzería.
 * Permite a los clientes realizar pedidos y procesar pagos.
 */
public class Aplicacion {
	
	 /**
     * El método principal de la aplicación.
     * Permite a los clientes realizar pedidos y procesar pagos.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	GestionClientes GestionClientes = new GestionClientes(scanner);

        Cliente cliente = GestionClientes.crearCliente();
        
        GestionPedido gestionPedido = new GestionPedido(cliente);
        
        gestionPedido.realizarPedido();

        //scanner.close();       
    }
}