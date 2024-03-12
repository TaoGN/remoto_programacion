package logic;

/**
 * @author Aleja
 * Esta clase representa un producto de bebida.
 * Extiende la clase Producto.
 */
public class Bebida extends Producto {

    /**
     * Constructor de la clase Bebida.
     *
     * @param nombre   El nombre del producto de bebida.
     * @param precio   El precio del producto de bebida.
     * @param cantidad La cantidad seleccionada del producto de bebida.
     */
    public Bebida(String nombre, double precio, int cantidad) {
        // Llama al constructor de la clase padre (Producto) con los parámetros proporcionados.
        super(nombre, precio, cantidad);
    }
    
    // Variables estáticas para las comidas
    public static final Bebida REFRESCO = new Bebida("Refresco", 1.80, 0);
    public static final Bebida AGUA = new Bebida("Agua", 1.00, 0);
    public static final Bebida PERONI = new Bebida("Cerveza Peroni", 3.00, 0);
    public static final Bebida MORETTI = new Bebida("Cerveza Moretti", 3.20, 0);
}