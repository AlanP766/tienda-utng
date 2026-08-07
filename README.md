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
