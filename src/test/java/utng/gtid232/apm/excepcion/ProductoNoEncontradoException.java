package utng.gtid232.apm.excepcion;

/**
 * Excepcion lanzada cuando se intenta buscar o procesar un producto inexistente.
 * 
 * @author Alan Palomino
 */
public class ProductoNoEncontradoException extends RuntimeException {
    private final String codigo;

    /**
     * Constructor de la excepcion.
     * 
     * @param codigo Codigo del producto que no se encontro
     */
    public ProductoNoEncontradoException(String codigo) {
        super("Producto no encontrado con codigo: " + codigo);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}