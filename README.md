# apiProductos

Descripción del Proyecto: API REST de Gestión de Productos

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

Introducción

* Este proyecto implementa una API REST en Spring Boot para realizar operaciones CRUD (Crear, Leer, Actualizar) en productos. La aplicación se conecta a una 
  base de datos Oracle para persistir la información.
  
  Al ejecutar el proyecto se recomienda cambiar el usuario y la contraseña en el properties. Al iniciar creará la tabla y al cerrar la eliminará.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

Estructura del Proyecto

* El proyecto sigue una arquitectura de tres capas típica para aplicaciones Spring Boot, que facilita la modularidad, la escalabilidad y el mantenimiento del código.
* El proyecto está organizado en los siguientes paquetes:

 * controllers: Contiene controladores que gestionan las peticiones HTTP.
 * models: Define las clases de modelo, como la entidad Producto.
   * dao: Contiene interfaces o clases para el acceso a datos (Data Access Objects).
   * entities: Define las entidades JPA que se mapean a la base de datos.
   * services: Contiene la lógica de negocio y servicios relacionados con productos.
   
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

Configuración de la Base de Datos

* La conexión a la base de datos Oracle se realiza mediante el archivo application.properties. Asegurarse de configurar adecuadamente la URL, el usuario y la contraseña 
  en este archivo.

  * properties

    spring.jpa.hibernate.ddl-auto=create-drop
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
    logging.level.org.hibernate.SQL=debug
    spring.jpa.show-sql=true
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XE
    spring.datasource.username=SYSTEM
    spring.datasource.password=258963

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

Uso de los Endpoint en Postman

* Listar Productos:

  * Endpoint: GET /productos
    Descripción: Obtiene la lista de todos los productos almacenados.


* Guardar Producto:

  * Endpoint: POST /productos
  * Descripción: Guarda un nuevo producto en la base de datos.
  * Cuerpo de la Petición:
    json

   {
           "nombreProducto": "Jugo Fresa",
           "precio": 4000
   }


* Modificar Producto:

  * Endpoint: PUT /productos/{id}
  * Descripción: Modifica un producto existente por su ID.
  * Cuerpo de la Petición:
    json

   {
       "nombreProducto": "Jugo Mora",
       "precio": 4500
   }


* Buscar Producto por ID:

  * Endpoint: GET /productos/{id}
  * Descripción: Obtiene los detalles de un producto por su ID.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

Pruebas Unitarias

* Se han incluido pruebas unitarias para garantizar el funcionamiento correcto de las diferentes capas del proyecto. Estas pruebas utilizan bibliotecas como JUnit y 
  Mockito para simular el comportamiento de las dependencias.
