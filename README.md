# Tienda UTNG - Gestión de Productos

Aplicación de escritorio desarrollada en **JavaFX** para la gestión y registro de productos en una base de datos **MySQL**, implementando una arquitectura en capas (Modelo, DAO, Servicio y Vista/Controlador).

---

## Requisitos Previos

* **JDK:** Java 17 o superior
* **Base de Datos:** MySQL Server 8.0+
* **Herramienta de Construcción:** Maven
* **IDE Recomendado:** Visual Studio Code / IntelliJ IDEA

---

## Configuración e Instalación

### 1. Base de Datos
Asegúrate de tener tu servidor MySQL activo y ejecuta el siguiente script para crear la base de datos y la tabla correspondiente:

```sql
CREATE DATABASE utng_tienda;
USE utng_tienda;

CREATE TABLE productos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL
);

## Excepciones del Dominio

El sistema utiliza las siguientes excepciones personalizadas para el control de reglas de negocio:

* **`StockInsuficienteException`**: Se lanza en `ProductoService.vender()` cuando el stock disponible es menor a la cantidad requerida. Captura `codigoProducto`, `stockActual` y `cantidadSolicitada`.
* **`ProductoNoEncontradoException`**: Se lanza al intentar consultar o vender un código de producto inexistente. Captura el `codigo` buscado.
* **`PrecioInvalidoException`**: Se lanza al intentar registrar un producto con precio menor a 0. Captura el `precio` inválido.