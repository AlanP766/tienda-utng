package utng.gtid232.apm.servicio;

import utng.gtid232.apm.dao.ProductoDAO;
import utng.gtid232.apm.dao.ProductoDAOImpl;
import utng.gtid232.apm.dao.ProductoDAOMemoria;
import utng.gtid232.apm.modelo.Producto;
import java.util.List;

/**
 * Servicio que contiene la lógica de negocio para la gestión de productos.
 * @author Alan Palomino
 */
public class ProductoService {

    private ProductoDAO productoDAO = (ProductoDAO) new ProductoDAOImpl();

    public ProductoService(ProductoDAOMemoria daoMemoria) {
        //TODO Auto-generated constructor stub
    }

    public void registrarProducto(int id, String nombre, double precio) {
        if (precio > 0) {
            Producto p = new Producto(id, nombre, precio);
            productoDAO.guardar(p);
        } else {
            System.out.println("Error: El precio debe ser mayor a 0.");
        }
    }

    public List<Producto> listarProductos() {
        return productoDAO.obtenerTodos();
    }

    public int registrar(Producto p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrar'");
    }

    public boolean vender(String string, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vender'");
    }

}
