package utng.gtid232.apm.dao;

import utng.gtid232.apm.modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    void guardar(Producto producto);
    List<Producto> obtenerTodos();
    
}
