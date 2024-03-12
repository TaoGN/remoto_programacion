package data;

import java.util.Date;
import logic.Cliente;
import java.util.Scanner;

public class GestionClientes {
    private Scanner scanner;

    public GestionClientes(Scanner scanner) {
        this.scanner = scanner;
    }
   
	public Cliente crearCliente() {
		System.out.println("¡Bienvenido a pizzeria Alessandro!");
		
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine().toLowerCase();

        System.out.println("Ingrese sus apellidos:");
        String apellidos = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese su número de teléfono:");
        String telefono = scanner.nextLine();

        while (!validarTelefono(telefono)) {
            System.out.println("Número de teléfono no válido, el teléfono ha de tener una longitud de 9 dígitos y empezar por 6, 7, 8 o 9. Por favor, inténtelo de nuevo.");
            telefono = scanner.nextLine();
        }

        System.out.println("Ingrese su dirección:");
        String direccion = scanner.nextLine();

        return new Cliente(nombre, apellidos, new Date(), telefono, direccion, "");
    }

    private boolean validarTelefono(String telefono) {
        // Verificar si el teléfono tiene 9 dígitos numéricos
        if (telefono.length() != 9)
            return false;

        // Verificar si el primer dígito es 6, 7, 8 o 9
        char primerDigito = telefono.charAt(0);
        if (primerDigito != '6' && primerDigito != '7' && primerDigito != '8' && primerDigito != '9')
            return false;

        return true;
    }
}