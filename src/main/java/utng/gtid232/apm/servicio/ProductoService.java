package utng.gtid232.apm.servicio;

import utng.gtid232.apm.dao.ProductoDAO;
import utng.gtid232.apm.modelo.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoService {

    private final ProductoDAO productoDAO;

    public ProductoService(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    // --- Métodos principales ---

    public int registrar(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        return productoDAO.insert(producto);
    }

    public boolean vender(String codigo, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        Optional<Producto> optProducto = productoDAO.findByCodigo(codigo);
        if (optProducto.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        Producto producto = optProducto.get();
        if (producto.getStock() < cantidad) {
            throw new IllegalStateException("Stock insuficiente");
        }

        int nuevoStock = producto.getStock() - cantidad;
        return productoDAO.updateStock(codigo, nuevoStock);
    }

    public List<Producto> obtenerTodos() {
        return productoDAO.findAll();
    }

    // --- Métodos de compatibilidad (para Main y SecondaryController) ---

    public void registrarProducto(int id, String nombre, double precio) {
        // Se mapean los parámetros recibidos a un objeto Producto completo
        String codigo = "P" + String.format("%03d", id);
        Producto producto = new Producto(codigo, nombre, precio, 0);
        producto.setId(id);
        registrar(producto);
    }

    public List<Producto> listarProductos() {
        return obtenerTodos();
    }
}