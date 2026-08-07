package utng.gtid232.apm.servicio;

import utng.gtid232.apm.dao.ProductoDAO;
import utng.gtid232.apm.dao.ProductoDAOImpl;
import utng.gtid232.apm.modelo.Producto;
import java.util.List;

public class ProductoService {

    private ProductoDAO productoDAO = (ProductoDAO) new ProductoDAOImpl();

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

}
