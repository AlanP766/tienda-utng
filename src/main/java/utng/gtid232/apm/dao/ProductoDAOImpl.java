package utng.gtid232.apm.dao;

import utng.gtid232.apm.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

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
}
