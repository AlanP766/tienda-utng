package utng.gtid232.apm.dao;

import utng.gtid232.apm.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl implements ProductoDAO {
    private List<Producto> baseDeDatosSimulada = new ArrayList<>();

    @Override
    public void guardar(Producto producto) {
        baseDeDatosSimulada.add(producto);
        System.out.println("-> Producto guardado en BD: " + producto.getNombre());
    }

    @Override
    public List<Producto> obtenerTodos() {
        return baseDeDatosSimulada;
    }

    @Override
    public int insert(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public Optional<Producto> findByCodigo(String codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCodigo'");
    }

    @Override
    public boolean updateStock(String codigo, int nuevoStock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStock'");
    }

    @Override
    public boolean delete(String codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Producto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
