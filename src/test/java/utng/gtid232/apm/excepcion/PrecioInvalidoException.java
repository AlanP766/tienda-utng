package utng.gtid232.apm.excepcion;

/**
 * Excepcion lanzada cuando el precio asignado a un producto no cumple con el valor permitido.
 * 
 * @author Alan Palomino
 */
public class PrecioInvalidoException extends RuntimeException {
    private final double precio;

    /**
     * Constructor de la excepcion.
     * 
     * @param precio Precio invalido asignado
     */
    public PrecioInvalidoException(double precio) {
        super(String.format("El precio %.2f es invalido. Debe ser mayor o igual a 0.0", precio));
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}