package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import logic.Bebida;
import logic.Cliente;
import logic.Comida;
import logic.Producto;
import pago.PasarelaDePago;
import ticket.Ticket;

/**
 * @author Aleja
 * Clase que representa un pedido realizado por un cliente.
 */
public class GestionPedido {
    private Cliente cliente;
    private Producto producto1;
    private Producto producto2;
    private double importeTotal;
    private PasarelaDePago pago;
    private String estado;

    /**
     * Constructor de la clase Pedido.
     *
     * @param cliente El cliente que realiza el pedido.
     */
    public GestionPedido(Cliente cliente) {
        this.cliente = cliente;
        this.importeTotal = 0;
        this.pago = null;
        this.estado = "PAGADO";
    }
    
    public void realizarPedido() {
        Scanner scanner = new Scanner(System.in);
    
    // Mostrar los detalles de los productos de comida
    System.out.println("\nSelecciona entre una de nuestras dos opciones:\n");
    System.out.println("Marque 1 para: " + Comida.NAPOLITANA.getNombre() + ", Precio: " + Comida.NAPOLITANA.getPrecio() + "€");
    System.out.println("Marque 2 para: " + Comida.CARBONARA.getNombre() + ", Precio: " + Comida.CARBONARA.getPrecio() + "€");
    System.out.println("Marque 3 para: " + Comida.FUGAZZA.getNombre() + ", Precio: " + Comida.FUGAZZA.getPrecio() + "€");
    System.out.println("Marque 4 para: " + Comida.CALZONE.getNombre() + ", Precio: " + Comida.CALZONE.getPrecio() + "€");
    System.out.println("Marque 5 para: " + Comida.PROSCIUTTO.getNombre() + ", Precio: " + Comida.PROSCIUTTO.getPrecio() + "€");
    
    // Capturar la opción de comida seleccionada
    int opcionComida = scanner.nextInt();
    scanner.nextLine();
    
    int cantidadComida = 0;
    Comida comidaSeleccionada = null;
    switch (opcionComida) {
        case 1:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadComida = scanner.nextInt();
            comidaSeleccionada = Comida.NAPOLITANA;
            break;
        case 2:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadComida = scanner.nextInt();
            comidaSeleccionada = Comida.CARBONARA;
            break;
        case 3:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadComida = scanner.nextInt();
            comidaSeleccionada = Comida.FUGAZZA;
            break;
        case 4:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadComida = scanner.nextInt();
            comidaSeleccionada = Comida.CALZONE;
            break;
        case 5:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadComida = scanner.nextInt();
            comidaSeleccionada = Comida.PROSCIUTTO;
            break;
        default:
            System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas");
            break;
    }
    
    // Calcular el precio de la comida seleccionada
    double precioComida = comidaSeleccionada.getPrecio() * cantidadComida;
  
    // Mostrar las opciones de bebida según la comida seleccionada
    System.out.println("\nSeleccione una opción de bebida:");
    System.out.println("1. " + Bebida.REFRESCO.getNombre() + ", Precio: " + Bebida.REFRESCO.getPrecio() + "€");
    System.out.println("2. " + Bebida.AGUA.getNombre() + ", Precio: " + Bebida.AGUA.getPrecio() + "€");
    System.out.println("3. " + Bebida.PERONI.getNombre() + ", Precio: " + Bebida.PERONI.getPrecio() + "€");
    System.out.println("4. " + Bebida.MORETTI.getNombre() + ", Precio: " + Bebida.MORETTI.getPrecio() + "€");

    // Capturar la opción de bebida seleccionada
    int opcionBebida = scanner.nextInt();
    scanner.nextLine();
    
    int cantidadBebida = 0;
    Bebida bebidaSeleccionada = null;
    switch (opcionBebida) {
        case 1:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadBebida = scanner.nextInt();
            bebidaSeleccionada = Bebida.REFRESCO;
            break;
        case 2:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadBebida = scanner.nextInt();
            bebidaSeleccionada = Bebida.AGUA;
            break;
        case 3:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadBebida = scanner.nextInt();
            bebidaSeleccionada = Bebida.PERONI;
            break;
        case 4:
            System.out.println("Ingrese la cantidad que desea:");
            cantidadBebida = scanner.nextInt();
            bebidaSeleccionada = Bebida.MORETTI;
            break;
        default:
            System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas");
            break;
    }

    // Calcular el precio de la bebida seleccionada
    double precioBebida = bebidaSeleccionada.getPrecio() * cantidadBebida;
    
    System.out.println("\nCombinación elegida:\n");
    System.out.println("CANT.\tPRODUCTO\t\tPRECIO UD.\tTOTAL");
    System.out.println("=====   =========\t\t=========\t=====");
    System.out.println(cantidadComida + "\t" + comidaSeleccionada.getNombre() + "\t\t" + comidaSeleccionada.getPrecio() + " €\t\t" + (comidaSeleccionada.getPrecio() * cantidadComida) + " €");
    System.out.println(cantidadBebida + "\t" + bebidaSeleccionada.getNombre() + "\t\t" + bebidaSeleccionada.getPrecio() + " €\t\t" + (bebidaSeleccionada.getPrecio() * cantidadBebida) + " €");
    System.out.println("TOTAL ------------------------------------> " + (precioComida + precioBebida) + " €\n");
    
    // Obtener la fecha actual
    Date fechaActual = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    // Construir el nombre del archivo basado en el nombre del cliente, apellidos del cliente y fecha actual
    String nombreArchivo = "pedido_" + cliente.getNombre().toLowerCase() + "_" + cliente.getApellidos().toLowerCase() + "_" + formatoFecha.format(fechaActual);
    
    PasarelaDePago.procesarPago(precioComida + precioBebida);
    Ticket.generarDocumento(cliente, comidaSeleccionada, cantidadComida, bebidaSeleccionada, cantidadBebida, precioComida + precioBebida, nombreArchivo);
    
    }
    /**
     * Método para pagar el pedido.
     *
     * @param pasarela La pasarela de pago utilizada para realizar el pago.
     * @param importe  El importe del pago.
     */
    public void pagar(PasarelaDePago pasarela, double importe) {
        if (estado.equals("PAGADO")) {
            estado = "PREPARANDO";
        } else {
            System.out.println("El pedido ya ha sido pagado.");
        }
    }

    /**
     * Método para agregar un cliente al pedido.
     *
     * @param cliente El cliente a agregar.
     */
    public void agregarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método para agregar el primer producto al pedido.
     *
     * @param producto El primer producto a agregar.
     */
    public void agregarProducto1(Producto producto) {
        this.producto1 = producto;
        calcularImporteTotal();
    }

    /**
     * Método para agregar el segundo producto al pedido.
     *
     * @param producto El segundo producto a agregar.
     */
    public void agregarProducto2(Producto producto) {
        this.producto2 = producto;
        calcularImporteTotal();
    }

    /**
     * Método para eliminar un producto del pedido.
     *
     * @param producto El producto a eliminar.
     * @return El producto eliminado.
     */
    public Producto eliminarProducto(Producto producto) {
        if (producto == producto1) {
            producto1 = null;
        } else if (producto == producto2) {
            producto2 = null;
        }
        calcularImporteTotal();
        return producto;
    }

    /**
     * Método privado para calcular el importe total del pedido.
     */
    private void calcularImporteTotal() {
        importeTotal = 0;
        if (producto1 != null) {
            importeTotal += producto1.getPrecio() * producto1.getCantidad();
        }
        if (producto2 != null) {
            importeTotal += producto2.getPrecio() * producto2.getCantidad();
        }
    }

    /**
     * Método toString para representar el pedido como una cadena de texto.
     *
     * @return Representación del pedido como una cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CANT.\tPRODUCTO\tPRECIO UD.\tTOTAL\n");
        sb.append("=====   =========   =========   =====\n");
        if (producto1 != null) {
            sb.append(producto1.getCantidad()).append("\t").append(producto1.getNombre()).append("\t")
                    .append(producto1.getPrecio()).append(" €\t")
                    .append(producto1.getPrecio() * producto1.getCantidad()).append(" €\n");
        }
        if (producto2 != null) {
            sb.append(producto2.getCantidad()).append("\t").append(producto2.getNombre()).append("\t")
                    .append(producto2.getPrecio()).append(" €\t")
                    .append(producto2.getPrecio() * producto2.getCantidad()).append(" €\n");
        }
        sb.append("TOTAL --------------------------------------------> ").append(importeTotal).append(" €\n");
        return sb.toString();
    }

    /**
     * Método para obtener el código del pedido.
     *
     * @return El código del pedido.
     */
    public String getCodigoPedido() {
        return null;
    }

}
