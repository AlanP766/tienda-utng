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
            () -> assertEquals("P001", producto.getCodigo(), "El código debe coincidir"),
            () -> assertEquals("Lapiz", producto.getNombre(), "El nombre debe coincidir"),
            () -> assertEquals(15.0, producto.getPrecio(), "El precio debe coincidir"),
            () -> assertEquals(10, producto.getStock(), "El stock debe coincidir")
        );
    }

    @Test
    void setPrecio_precioNegativo_lanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            producto.setPrecio(-5.0);
        }, "Debe lanzar IllegalArgumentException cuando el precio es negativo");
        
        assertTrue(exception.getMessage().contains("precio"), "El mensaje debe hacer referencia al precio");
    }

    @Test
    void setNombre_nombreNulo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            producto.setNombre(null);
        }, "Debe lanzar IllegalArgumentException si el nombre es nulo");
    }

    @Test
    void isActivo_porDefecto_retornaTrue() {
        assertTrue(producto.isActivo(), "El producto debe estar activo por defecto al crearse");
    }

    private void assertTrue(Object activo, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }

    @Test
void aplicarDescuento_porcentajeValido_reducePrecioCorrectamente() {
    // Si el precio original es 15.0 y aplicamos 10% de descuento, debe quedar en 13.5
    producto.aplicarDescuento(10.0);
    assertEquals(13.5, producto.getPrecio(), 0.001, "El precio con 10% de descuento debe ser 13.5");
}
}