package utng.gtid232.apm.modelo;

/**
 * Entidad que representa la estructura de un Producto.
 * @author Alan Palomino
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String string, String string2, double d, int i) {
        //TODO Auto-generated constructor stub
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + '}';
    }

    public Object getCodigo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodigo'");
    }

    public void setStock(int nuevoStock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStock'");
    }

    public Object isActivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isActivo'");
    }

    public Integer getStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStock'");
    }

    public void aplicarDescuento(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aplicarDescuento'");
    }
}

