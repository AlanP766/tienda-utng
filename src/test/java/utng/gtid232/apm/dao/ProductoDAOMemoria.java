package utng.gtid232.apm.dao;

import utng.gtid232.apm.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stub en memoria de ProductoDAO para ejecucion de pruebas unitarias y ejecucion local sin BD.
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
        // Guarda o actualiza si ya existe en la lista
        Optional<Producto> existente = findByCodigo(producto.getCodigo());
        if (existente.isPresent()) {
            actualizar(producto);
        } else {
            insert(producto);
        }
    }

    @Override
    public void actualizar(Producto producto) {
        if (producto == null || producto.getCodigo() == null) {
            return;
        }
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).getCodigo().equalsIgnoreCase(producto.getCodigo())) {
                almacen.set(i, producto);
                return;
            }
        }
    }

    @Override
    public List<Producto> findAll() {
        return new ArrayList<>(almacen);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return findAll();
    }

    @Override
    public Optional<Producto> findByCodigo(String codigo) {
        if (codigo == null) {
            return Optional.empty();
        }
        return almacen.stream()
                .filter(p -> p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo))
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
        if (codigo == null) {
            return false;
        }
        return almacen.removeIf(p -> p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo));
    }
}