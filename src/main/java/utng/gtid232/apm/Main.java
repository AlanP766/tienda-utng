package utng.gtid232.apm;

import utng.gtid232.apm.modelo.Producto;
import utng.gtid232.apm.servicio.ProductoService;

public class Main {
  public static void main(String[] args) {
        System.out.println("=== SISTEMA TIENDA UTNG ===");
        
        ProductoService servicio = new ProductoService();
        
        // Demo
        servicio.registrarProducto(1, "Teclado Mecánico", 750.00);
        servicio.registrarProducto(2, "Mouse Gamer", 450.00);
        
        System.out.println("\nLista de productos:");
        for (Producto p : servicio.listarProductos()) {
            System.out.println(p);
        }
    }
}
