package ticket;

import logic.Cliente;
import logic.Bebida;
import logic.Comida;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Aleja
 * Clase para generar el ticket del pedido.
 */
public class Ticket {

    private static final String NOMBRE_CLIENTE = "Datos del Cliente:\n\n";
    private static final String NOMBRE = "Nombre: ";
    private static final String APELLIDOS = "Apellidos: ";
    private static final String FECHA_ALTA = "Fecha de alta: ";
    private static final String TELEFONO = "Teléfono: ";
    private static final String DIRECCION = "Dirección: ";
    private static final String COMBINACION_ELEGIDA = "Combinación elegida:\n\n";
    private static final String CABECERA = "Cantidad\tProducto\tPrecio Ud.\tTotal\n";
    private static final String TOTAL = "TOTAL ------------------------------------> ";
    private static final String DESPEDIDA = "Gracias por confiar en pizzeria Alessandro ¡Hasta pronto!";
    private static final String ERROR_ESCRITURA = "Error al escribir el archivo: ";

    /**
     * Método para generar el documento del ticket.
     * 
     * @param cliente Cliente que realiza el pedido.
     * @param comidaSeleccionada Comida seleccionada por el cliente.
     * @param cantidadComida Cantidad de comida seleccionada.
     * @param bebidaSeleccionada Bebida seleccionada por el cliente.
     * @param cantidadBebida Cantidad de bebida seleccionada.
     * @param precioTotal Precio total del pedido.
     * @param nombreArchivo Nombre del archivo donde se guardará el ticket.
     */
    public static void generarDocumento(Cliente cliente, Comida comidaSeleccionada, int cantidadComida, Bebida bebidaSeleccionada, int cantidadBebida, double precioTotal, String nombreArchivo) {
        File archivo = new File(nombreArchivo + ".txt");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            escribirDatosCliente(bw, cliente);
            escribirCombinacionElegida(bw, comidaSeleccionada, cantidadComida, bebidaSeleccionada, cantidadBebida, precioTotal);
            bw.write(DESPEDIDA);
        } catch (IOException e) {
            System.err.println(ERROR_ESCRITURA + e.getMessage());
        }
    }

    /**
     * Método para escribir los datos del cliente en el ticket.
     * 
     * @param bw BufferedWriter para escribir en el archivo.
     * @param cliente Cliente que realiza el pedido.
     * @throws IOException Si hay un error al escribir en el archivo.
     */
    private static void escribirDatosCliente(BufferedWriter bw, Cliente cliente) throws IOException {
        bw.write(NOMBRE_CLIENTE);
        bw.write(NOMBRE + cliente.getNombre() + "\n");
        bw.write(APELLIDOS + cliente.getApellidos() + "\n");
        bw.write(FECHA_ALTA + cliente.getFechaDeAlta() + "\n");
        bw.write(TELEFONO + cliente.getTelefono() + "\n");
        bw.write(DIRECCION + cliente.getDireccion() + "\n\n\n");
    }

    /**
     * Método para escribir la combinación de comida y bebida seleccionada en el ticket.
     * 
     * @param bw BufferedWriter para escribir en el archivo.
     * @param comidaSeleccionada Comida seleccionada por el cliente.
     * @param cantidadComida Cantidad de comida seleccionada.
     * @param bebidaSeleccionada Bebida seleccionada por el cliente.
     * @param cantidadBebida Cantidad de bebida seleccionada.
     * @param precioTotal Precio total del pedido.
     * @throws IOException Si hay un error al escribir en el archivo.
     */
    private static void escribirCombinacionElegida(BufferedWriter bw, Comida comidaSeleccionada, int cantidadComida, Bebida bebidaSeleccionada, int cantidadBebida, double precioTotal) throws IOException {
        bw.write(COMBINACION_ELEGIDA);
        bw.write(CABECERA);
        bw.write(cantidadComida + "\t" + comidaSeleccionada.getNombre() + "\t\t" + comidaSeleccionada.getPrecio() + " €\t\t" + (comidaSeleccionada.getPrecio() * cantidadComida) + " €\n");
        bw.write(cantidadBebida + "\t" + bebidaSeleccionada.getNombre() + "\t\t" + bebidaSeleccionada.getPrecio() + " €\t\t" + (bebidaSeleccionada.getPrecio() * cantidadBebida) + " €\n");
        bw.write(TOTAL + precioTotal + " €\n\n");
    }
}