package data;

import java.util.Date;
import logic.Cliente;
import java.util.Scanner;

/**
 * @author Aleja
 * La clase GestionClientes proporciona métodos para gestionar la creación de clientes.
 * Permite la creación de objetos Cliente con información ingresada por el usuario.
 */
public class GestionClientes {
   
    /**
     * Crea un nuevo cliente con la información ingresada por el usuario.
     *
     * @return El cliente creado.
     */
    public Cliente crearCliente() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Por favor ingrese su nombre:");
        String nombre = scanner.nextLine().toLowerCase();

        System.out.println("Por favor ingrese sus apellidos:");
        String apellidos = scanner.nextLine().toUpperCase();

        System.out.println("Por favor ingrese su número de teléfono:");
        String telefono = scanner.nextLine();

        // Validar el formato del número de teléfono
        while (!validarTelefono(telefono)) {
            System.out.println("Número de teléfono no válido, el teléfono ha de tener una longitud de 9 dígitos y empezar por 6, 7, 8 o 9. Por favor, inténtelo de nuevo.");
            telefono = scanner.nextLine();
        }

        System.out.println("Por favor ingrese su dirección:");
        String direccion = scanner.nextLine();
        
        return new Cliente(nombre, apellidos, new Date(), telefono, direccion, "");
    }

    /**
     * Valida el formato del número de teléfono.
     *
     * @param telefono El número de teléfono a validar.
     * @return true si el número de teléfono es válido, false de lo contrario.
     */
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