package utng.gtid232.apm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utng.gtid232.apm.modelo.Producto;
import utng.gtid232.apm.servicio.ProductoService;

public class SecondaryController {

    // 1. Enlace con los elementos visuales de tienda.fxml (los fx:id)
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, Integer> colId;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;

    // 2. Conexión con tu backend (Base de Datos a través de ProductoService)
    private ProductoService servicio = new ProductoService();
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    /**
     * Se ejecuta automáticamente al cargar la pantalla.
     * Configura las columnas de la tabla y carga los datos existentes.
     */
    @FXML
    public void initialize() {
        // Vincula las columnas de la TableView con los atributos id, nombre, precio de Producto
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaProductos.setItems(listaProductos);
        actualizarTabla(); // Carga inicial desde MySQL
    }

    /**
     * Este método se ejecuta al presionar el botón "Guardar Producto"
     */
    @FXML
    private void handleGuardarProducto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            if (nombre.isEmpty()) {
                mostrarAlerta("Campo vacío", "El nombre del producto no puede estar vacío.");
                return;
            }

            // 3. Envía los datos al servicio -> DAO -> Base de Datos MySQL
            servicio.registrarProducto(id, nombre, precio);

            // Limpia las cajas de texto y actualiza la tabla visual
            txtId.clear();
            txtNombre.clear();
            txtPrecio.clear();
            actualizarTabla();

            mostrarInformacion("Éxito", "Producto registrado correctamente en la base de datos.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de Formato", "Asegúrate de ingresar valores numéricos válidos en ID y Precio.");
        } catch (Exception e) {
            mostrarAlerta("Error en Base de Datos", "No se pudo guardar el producto: " + e.getMessage());
        }
    }

    private void actualizarTabla() {
        // Consulta los productos de la BD a través del servicio y actualiza la lista visual
        listaProductos.setAll(servicio.listarProductos());
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}