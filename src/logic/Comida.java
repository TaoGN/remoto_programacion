package logic;

/**
 * @author Aleja 
 * Esta clase representa un producto de comida.
 * Extiende la clase Producto.
 */
public class Comida extends Producto {

    /**
     * Constructor de la clase Comida.
     *
     * @param nombre   El nombre del producto de comida.
     * @param precio   El precio del producto de comida.
     * @param cantidad La cantidad seleccionada del producto de comida.
     */
    public Comida(String nombre, double precio, int cantidad) {
        // Llama al constructor de la clase padre (Producto) con los parámetros proporcionados.
        super(nombre, precio, cantidad);
    }
   
    // Variables estáticas para las comidas
    public static final Comida NAPOLITANA = new Comida("Pizza Napolitana", 10.00, 0);
    public static final Comida CARBONARA = new Comida("Pizza Carbonara", 10.50, 0);
    public static final Comida FUGAZZA = new Comida("Pizza Fugazza", 10.50, 0);
    public static final Comida CALZONE = new Comida("Calzone", 13.50, 0);
    public static final Comida PROSCIUTTO = new Comida("Pizza Prosciutto", 9.80, 0);
}