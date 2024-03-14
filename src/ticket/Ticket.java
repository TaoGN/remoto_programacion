package ticket;

import logic.Cliente;
import logic.Bebida;
import logic.Comida;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    /**
     * @author Aleja
     * Genera un documento de texto con los datos del cliente y la combinación elegida.
     *
     * @param cliente          Objeto Cliente con los datos del cliente.
     * @param comidaSeleccionada Objeto Comida seleccionado por el cliente.
     * @param cantidadComida   Cantidad de comida seleccionada.
     * @param bebidaSeleccionada Objeto Bebida seleccionada por el cliente.
     * @param cantidadBebida   Cantidad de bebida seleccionada.
     * @param precioTotal      Precio total del pedido.
     * @param nombreArchivo    Nombre del archivo.
     */
    public static void generarDocumento(Cliente cliente, Comida comidaSeleccionada, int cantidadComida, Bebida bebidaSeleccionada, int cantidadBebida, double precioTotal, String nombreArchivo) {
        try {
        	File archivo = new File(nombreArchivo + ".txt"); // Nombrar el archivo según el nombre proporcionado
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(escritor);

            bw.write("Datos del Cliente:\n\n");
            bw.write("Nombre: " + cliente.getNombre() + "\n");
            bw.write("Apellidos: " + cliente.getApellidos() + "\n");
            bw.write("Fecha de alta: " + cliente.getFechaDeAlta() + "\n");
            bw.write("Teléfono: " + cliente.getTelefono() + "\n");
            bw.write("Dirección: " + cliente.getDireccion() + "\n\n\n");

            bw.write("Combinación elegida:\n\n");
            bw.write("Cantidad\tProducto\tPrecio Ud.\tTotal\n");
            bw.write(cantidadComida + "\t" + comidaSeleccionada.getNombre() + "\t\t" + comidaSeleccionada.getPrecio() + " €\t\t" + (comidaSeleccionada.getPrecio() * cantidadComida) + " €\n");
            bw.write(cantidadBebida + "\t" + bebidaSeleccionada.getNombre() + "\t\t" + bebidaSeleccionada.getPrecio() + " €\t\t" + (bebidaSeleccionada.getPrecio() * cantidadBebida) + " €\n");
            bw.write("TOTAL ------------------------------------> " + precioTotal + " €\n\n");
            bw.write("Gracias por confiar en pizzeria Alessandro ¡Hasta pronto!");

            bw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}