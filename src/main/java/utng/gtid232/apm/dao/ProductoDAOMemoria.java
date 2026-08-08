package utng.gtid232.apm.dao;

import utng.gtid232.apm.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stub en memoria de ProductoDAO para ejecucion de pruebas unitarias sin BD.
 */
public class ProductoDAOMemoria implements ProductoDAO {
private final List<Producto> almacen = new ArrayList<>();
    private int contadorId = 1;

    @Override
    public int insert(Producto producto) {
        if (producto == null) {
            return 0;
        }
        producto.setId(contadorId++);
        almacen.add(producto);
        return 1;
    }

    @Override
    public void guardar(Producto producto) {
        insert(producto);
    }

    @Override
    public List<Producto> findAll() {
        // Retorna una copia defensiva
        return new ArrayList<>(almacen);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return findAll();
    }

    @Override
    public Optional<Producto> findByCodigo(String codigo) {
        return almacen.stream()
                .filter(p -> p.getCodigo() != null && ((String) p.getCodigo()).equalsIgnoreCase(codigo))
                .findFirst();
    }

    @Override
    public boolean updateStock(String codigo, int nuevoStock) {
        Optional<Producto> optProducto = findByCodigo(codigo);
        if (optProducto.isPresent()) {
            optProducto.get().setStock(nuevoStock);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String codigo) {
        return almacen.removeIf(p -> p.getCodigo() != null && ((String) p.getCodigo()).equalsIgnoreCase(codigo));
    }
}

