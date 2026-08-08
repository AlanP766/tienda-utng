package utng.gtid232.apm.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utng.gtid232.apm.dao.ProductoDAOMemoria;
import utng.gtid232.apm.modelo.Producto;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

    private ProductoService productoService;
    private ProductoDAOMemoria daoMemoria;

    @BeforeEach
    void setUp() {
        daoMemoria = new ProductoDAOMemoria();
        productoService = new ProductoService(daoMemoria);
    }

    @Test
    void registrar_productoValido_retornaUno() {
        Producto p = new Producto("P002", "Cuaderno", 25.0, 5);
        int resultado = productoService.registrar(p);
        assertEquals(1, resultado, "El registro exitoso de un producto valido debe retornar 1");
    }

    @Test
    void registrar_productoNulo_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.registrar(null);
        }, "Registrar un producto nulo debe lanzar IllegalArgumentException");
    }

    @Test
    void vender_stockSuficiente_reduceCorrectamente() {
        Producto p = new Producto("P003", "Borrador", 10.0, 20);
        productoService.registrar(p);

        boolean exito = productoService.vender("P003", 5);

        assertAll("Verificación de venta con stock suficiente",
            () -> assertTrue(exito, "La venta debe realizarse con exito"),
            () -> assertEquals(15, daoMemoria.findByCodigo("P003").get().getStock(), "El stock debio reducirse de 20 a 15")
        );
    }

    @Test
    void vender_stockInsuficiente_lanzaIllegalStateException() {
        Producto p = new Producto("P004", "Regla", 12.0, 2);
        productoService.registrar(p);

        assertThrows(IllegalStateException.class, () -> {
            productoService.vender("P004", 10);
        }, "Intentar vender mas unidades del stock disponible debe lanzar IllegalStateException");
    }
}