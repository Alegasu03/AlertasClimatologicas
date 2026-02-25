# Alertas Climatológicas API

API REST desarrollada con **Spring Boot** para gestionar y consultar avisos meteorológicos.

## Descripción

Este proyecto permite:

- Crear nuevos avisos meteorológicos.
- Listar todos los avisos registrados.
- Consultar avisos activos en el momento actual.
- Filtrar avisos por zona.

La aplicación usa una base de datos **H2 en memoria**, por lo que los datos se reinician cada vez que se detiene la aplicación.

## Tecnologías

- Java 17
- Spring Boot 4
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Requisitos previos

- JDK 17+
- Maven (opcional si usas `./mvnw`)

## Ejecutar el proyecto

```bash
./mvnw spring-boot:run
```

Por defecto, la API queda disponible en:

- `http://localhost:8080`

## Base de datos H2

Con la aplicación en ejecución, puedes acceder a la consola de H2 en:

- `http://localhost:8080/h2-console`

Parámetros de conexión:

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User:** `sa`
- **Password:** *(vacío)*

## Endpoints disponibles

Base path: `/avisos`

### 1) Obtener todos los avisos

- **GET** `/avisos`

### 2) Obtener avisos activos

- **GET** `/avisos/activas`

> Un aviso se considera activo cuando la fecha actual está entre `fechaInicio` (incluida) y `fechaFin` (excluida).

### 3) Obtener avisos por zona

- **GET** `/avisos/zona/{zona}`

Ejemplo:

- `GET /avisos/zona/Costa`

### 4) Crear un aviso

- **POST** `/avisos`
- **Content-Type:** `application/json`

Ejemplo de body:

```json
{
  "tipo": "Tormenta",
  "nivel": "NARANJA",
  "zona": "Madrid",
  "mensaje": "Ráfagas fuertes y lluvia intensa",
  "fechaInicio": "2026-02-01T10:00:00",
  "fechaFin": "2026-02-01T18:00:00"
}
```

## Estructura del proyecto

- `controller`: expone los endpoints REST.
- `service`: lógica de negocio para filtrar y gestionar avisos.
- `repository`: acceso a datos con Spring Data JPA.
- `model`: entidad `AvisoMeteorologico`.

## Ejecutar tests

```bash
./mvnw test
```

## Notas

- Actualmente no hay autenticación/autorización.
- Los filtros por tipo y nivel existen en el servicio y repositorio, pero no están expuestos todavía como endpoint REST
