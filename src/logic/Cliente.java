/**
 * 
 */
package logic;
import java.util.Date;
import data.GestionPedido;

/**
 * @author Aleja 
 *
 */
public class Cliente {

	// Atributos
	private String nombre;
	private String apellidos;
	private Date fechaDeAlta;
	private String telefono;
	private String direccion;
	private String historial;
	public static int dimesionArray;

	// Constructores
	/**
	 * 
	 */
	public Cliente() {

	}

	/**
	 * Constructor clase producto con 6 parametros
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param fechaDeAlta
	 * @param telefono
	 * @param direccion
	 * @param historial
	 */
	public Cliente(String nombre, String apellidos, Date fechaDeAlta, String telefono, String direccion, String historial) {
		 this.nombre = nombre.toLowerCase();
		 this.apellidos = apellidos.toUpperCase();
		 this.fechaDeAlta = (fechaDeAlta != null) ? fechaDeAlta : new Date();
		 this.telefono = telefono; // Asignar el valor de telefono primero
		 this.direccion = direccion;
		 this.historial = "";
		    
		 // Luego validar el teléfono
		 this.telefono = validarTelefono(telefono) ? telefono : null;
		}
	
	public boolean validarTelefono(String telefono) {
	    // Verificar si el teléfono tiene 9 dígitos numéricos
	    if (telefono.length() != 9)
	        return false;

	    // Verificar si el primer dígito es 6, 7, 8 o 9
	    char primerDigito = telefono.charAt(0);
	    if (primerDigito != '6' && primerDigito != '7' && primerDigito != '8' && primerDigito != '9')
	        return false;

	    return true;
	}

	    public void agregarPedido(GestionPedido pedido) {
	        historial += pedido.getCodigoPedido() + ",";
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
	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getFechaDeAlta() {
		return this.fechaDeAlta;
	}

	/**
	 * 
	 * @param fechaDeAlta
	 */
	public void setfechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHistorial() {
		return this.historial;
	}

	/**
	 * 
	 * @param historial
	 */
	public void setHistorial(String historial) {
		this.historial = historial;
	}

}
