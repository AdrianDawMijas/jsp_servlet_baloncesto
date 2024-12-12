# JSP Servlet JDBC CRUD Application

Este proyecto demuestra cómo manejar peticiones HTTP utilizando JSP y Servlets para implementar un CRUD (Crear, Leer, Actualizar, Eliminar) de una entidad `Socio`.

## Funcionalidades Principales

### Peticiones HTTP y JSP/Servlets

- **GET**: Se utiliza para recuperar y mostrar información. Por ejemplo, al solicitar la edición de un socio, se envía una petición GET que recupera los datos del socio desde la base de datos y los muestra en un formulario de edición.
- **POST**: Se utiliza para enviar datos al servidor. Por ejemplo, al actualizar un socio, se envía una petición POST con los datos del formulario que se procesan y actualizan en la base de datos.

### CRUD de Socios

1. **Crear Socio**:
    - **Formulario**: Un formulario HTML para ingresar los datos del nuevo socio.
    - **Servlet (doPost)**: Procesa los datos del formulario y los guarda en la base de datos.
2. **Leer Socios**:
    - **Listado**: Una vista que muestra una lista de todos los socios.
    - **Servlet (doGet)**: Recupera la lista de socios desde la base de datos y la envía a la vista.
3. **Actualizar Socio**:
    - **Formulario de Edición**: Un formulario HTML prellenado con los datos del socio a editar.
    - **Servlet (doGet)**: Recupera los datos del socio y los envía al formulario de edición.
    - **Servlet (doPost)**: Procesa los datos actualizados del formulario y los guarda en la base de datos.
4. **Eliminar Socio**:
    - **Acción de Eliminación**: Un enlace o botón para eliminar un socio específico.
    - **Servlet (doPost)**: Procesa la solicitud de eliminación y remueve el socio de la base de datos.

## Estructura del Proyecto

- **Servlets**: Manejan las peticiones HTTP y la lógica de negocio.
- **JSP**: Generan las vistas HTML que se envían al cliente.
- **DAO**: Acceden y manipulan la base de datos.
