package utng.gtid232.apm.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utng.gtid232.apm.dao.ProductoDAOMemoria;
import utng.gtid232.apm.excepcion.PrecioInvalidoException;
import utng.gtid232.apm.excepcion.ProductoNoEncontradoException;
import utng.gtid232.apm.excepcion.StockInsuficienteException;
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

    // --- TESTS DEL CONSTRUCTOR ---
    @Test
    void constructor_daoNulo_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ProductoService(null), 
                "Instanciar el servicio con DAO nulo debe lanzar IllegalArgumentException");
    }

    // --- TESTS DE REGISTRAR ---
    @Test
    void registrar_productoValido_ejecutaSinExcepcion() {
        Producto p = new Producto("P002", "Cuaderno", 25.0, 5);
        assertDoesNotThrow(() -> productoService.registrar(p), 
                "El registro exitoso de un producto valido no debe lanzar excepcion");
    }

    @Test
    void registrar_productoNulo_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.registrar(null);
        }, "Registrar un producto nulo debe lanzar IllegalArgumentException");
    }

    @Test
    void registrar_precioNegativo_lanzaPrecioInvalidoException() {
        Producto p = new Producto("P005", "Pluma", -15.0, 10);
        PrecioInvalidoException ex = assertThrows(PrecioInvalidoException.class, () -> {
            productoService.registrar(p);
        }, "Registrar un precio negativo debe lanzar PrecioInvalidoException");

        assertEquals(-15.0, ex.getPrecio(), "El precio de la excepcion debe coincidir con el asignado");
    }

    @Test
    void registrar_stockNegativo_lanzaIllegalArgumentException() {
        Producto p = new Producto("P006", "Lápiz", 10.0, -5);
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.registrar(p);
        }, "Registrar un stock negativo debe lanzar IllegalArgumentException");
    }

    // --- TESTS DE VENDER ---
    @Test
    void vender_stockSuficiente_reduceCorrectamente() {
        Producto p = new Producto("P003", "Borrador", 10.0, 20);
        productoService.registrar(p);

        assertDoesNotThrow(() -> productoService.vender("P003", 5));
        assertEquals(15, daoMemoria.findByCodigo("P003").get().getStock(), 
                "El stock debio reducirse de 20 a 15");
    }

    @Test
    void vender_productoInexistente_lanzaProductoNoEncontradoException() {
        assertThrows(ProductoNoEncontradoException.class, () -> {
            productoService.vender("CODIGO_INEXISTENTE", 1);
        }, "Vender un producto inexistente debe lanzar ProductoNoEncontradoException");
    }

    @Test
    void vender_sinStock_verificaDetallesDeExcepcion() {
        Producto p = new Producto("P004", "Regla", 12.0, 2);
        productoService.registrar(p);

        StockInsuficienteException ex = assertThrows(StockInsuficienteException.class, () -> {
            productoService.vender("P004", 10);
        }, "Intentar vender mas unidades que el stock disponible debe lanzar StockInsuficienteException");

        assertAll("Verificación de atributos de StockInsuficienteException",
            () -> assertEquals("P004", ex.getCodigoProducto(), "El codigo del producto en la excepcion debe coincidir"),
            () -> assertEquals(2, ex.getStockActual(), "El stock actual reportado debe ser 2"),
            () -> assertEquals(10, ex.getCantidadSolicitada(), "La cantidad solicitada reportada debe ser 10")
        );
    }

    @Test
    void vender_codigoInvalido_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.vender("", 5);
        }, "Pasar un codigo vacio debe lanzar IllegalArgumentException");
    }

    @Test
    void vender_cantidadInvalida_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.vender("P003", 0);
        }, "Pasar una cantidad <= 0 debe lanzar IllegalArgumentException");
    }
}