package utng.gtid232.apm.dao;

import utng.gtid232.apm.modelo.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoDAO {
    void guardar(Producto producto);
    List<Producto> obtenerTodos();
    int insert(Producto producto);
    Optional<Producto> findByCodigo(String codigo);
    boolean updateStock(String codigo, int nuevoStock);
    boolean delete(String codigo);
    List<Producto> findAll();
    void actualizar(Producto producto);
    
}
