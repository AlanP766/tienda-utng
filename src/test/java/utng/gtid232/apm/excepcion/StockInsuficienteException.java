package utng.gtid232.apm.excepcion;

/**
 * Excepcion lanzada cuando no hay stock suficiente para realizar una venta.
 * 
 * @author Alan Palomino
 */
public class StockInsuficienteException extends RuntimeException {
    private final String codigoProducto;
    private final int stockActual;
    private final int cantidadSolicitada;

    /**
     * Constructor de la excepcion.
     * 
     * @param codigoProducto     Codigo del producto involucrado
     * @param stockActual        Cantidad en inventario actual
     * @param cantidadSolicitada Cantidad requerida en la operacion
     */
    public StockInsuficienteException(String codigoProducto, int stockActual, int cantidadSolicitada) {
        super(String.format("Stock insuficiente para el producto %s. Stock actual: %d, solicitado: %d", 
                codigoProducto, stockActual, cantidadSolicitada));
        this.codigoProducto = codigoProducto;
        this.stockActual = stockActual;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }
}