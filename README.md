Este proyecto implementa un sistema **CRUD** en Java, para la gestión de productos y categorías de un supermercado.  
Está desarrollado aplicando los principios de POO, organizando el código en clases y delegando responsabilidades entre distintos módulos.  

El programa se ejecuta en consola y permite al usuario administrar tanto las categorías como los productos asociados a cada una.

## Estructura del proyecto
Las Clases principales son:

- **`Main.java`**
  Orquestador principal del sistema. Inicializa las listas de productos y categorías, carga datos iniciales y muestra el menú principal con acceso al CRUD de productos y al CRUD de categorías.  

- **Producto.java**  
  Representa un producto del supermercado con sus atributos: `id`, `descripcion`, `precio`, `categoria` .
  Hereda de la clase abstracta `Entidad`.

- **`Categoria.java`**  
  Representa una categoría de productos (por ejemplo, *Alimentos*, *Bebidas*, *Limpieza*). También hereda de `Entidad`.

- **`Entidad.java`**  
  Clase abstracta base de la cual heredan `Producto` y `Categoria`.  
  Define el atributo `id` y el método abstracto `mostrarResumen()`, que cada subclase implementa a su manera (polimorfismo). Permite abstarer el comportamiento común y aplicar herencia correctamente.

- **`CrudProductos.java`**  
  Gestiona las operaciones CRUD sobre productos:
  - Crear nuevo producto (con validación y selección de categoría)
  - Listar productos
  - Modificar producto existente
  - Eliminar producto  
  Utiliza una lista de productos (`ArrayList<Producto>`) y una lista de categorías para mantener la relación entre ambos.

- **`CrudCategorias.java`**  
  Gestiona las operaciones CRUD sobre las categorías, con una estructura similar a la de productos.  

- **`InputValidator.java`**  
  Clase auxiliar encargada de validar los datos ingresados por consola.  
  Contiene métodos estáticos que aseguran que el usuario ingrese:
  - Números válidos (para precios y opciones del menú)
  - Cadenas no vacías (para descripciones)
  - Rangos válidos de selección  
  Esta clase mejora la robustez del programa y evita errores en la entrada de datos.

## Lógica principal
El `Main` muestra un menú principal desde donde el usuario puede elegir:

1) CRUD de Productos  
2) CRUD de Categorías  
0) Salir  

Cada módulo (productos o categorías) tiene su propio submenú con las opciones:

- Crear  
- Listar  
- Actualizar  
- Eliminar  
- Volver al menú principal  

---

## Categorías precargadas:
Al iniciar el programa, se crean tres categorías iniciales para facilitar la prueba del sistema:

- **Alimentos**  
- **Bebidas**  
- **Limpieza**  

Los productos que se agreguen podrán asociarse a cualquiera de estas categorías o a las nuevas que el usuario cree.

## Autora
Mariana Elizondo
Proyecto para Curso de backEnd Java – TalentoTech , 2°cuatrimestre 2025
