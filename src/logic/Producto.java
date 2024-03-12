/**
 * 
 */
package logic;
/**
 * @author Aleja 
 *
 */
public abstract class Producto {

	// Atributos
	private String nombre;
	private double precio;
	private int cantidad;
	// Constructores
	/**
	 * 
	 */
	public Producto() {
	}
	/**
	 * Constructor clase producto con 3 parametros
	 * 
	 * @param nombre
	 * @param precioUnit
	 * @param cantidad
	 */
	public Producto(String nombre, double precio, int cantidad) {

		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	// Métodos Get and Set

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecio() {
		return this.precio;
	}

	/**
	 * 
	 * @param precioUnit
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * 
	 * @return
	 */
	public int getCantidad() {
		return this.cantidad;
	}

	/**
	 * 
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

  }
