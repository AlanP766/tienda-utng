package utng.gtid232.apm.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto("P001", "Lapiz", 15.0, 10);
    }

    @Test
    void constructor_datosValidos_creaProductoCorrectamente() {
        assertAll("Verificar atributos del producto",
            () -> assertEquals("P001", producto.getCodigo()),
            () -> assertEquals("Lapiz", producto.getNombre()),
            () -> assertEquals(15.0, producto.getPrecio()),
            () -> assertEquals(10, producto.getStock())
        );
    }

    @Test
    void setPrecio_precioNegativo_lanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            producto.setPrecio(-5.0);
        });
        assertTrue(exception.getMessage().contains("precio"));
    }

    @Test
    void setNombre_nombreNulo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            producto.setNombre(null);
        });
    }

    @Test
    void isActivo_porDefecto_retornaTrue() {
        assertTrue(producto.isActivo());
    }

    // --- METODOS DE LA TAREA 3 (TDD) ---
    @Test
    void aplicarDescuento_porcentajeValido_reducePrecioCorrectamente() {
        producto.aplicarDescuento(10.0);
        assertEquals(13.5, producto.getPrecio(), 0.001);
    }

    @Test
    void aplicarDescuento_porcentajeInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            producto.aplicarDescuento(150.0);
        });
    }
}