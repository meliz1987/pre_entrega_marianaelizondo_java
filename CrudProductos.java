package crudpoo;
import java.util.ArrayList;

public class CrudProductos implements CrudInterface<Producto> {
     private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;
    public final java.util.Scanner scanner = InputValidator.scanner;

    public CrudProductos(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("\n=== CRUD de Productos ===");
        System.out.println("1) Crear producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("0) Volver al menú principal");
        System.out.print("Opción: ");
    }

    @Override
    public void crear() {
        String descripcion = leerTexto("Ingrese descripción: ");
        double precio = leerDouble("Ingrese precio: ");

        System.out.println("Seleccione una categoría:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ") " + categorias.get(i).getNombre());
        }

        int opCat = leerEntero("Opción: ");
        Categoria categoria = (opCat > 0 && opCat <= categorias.size()) ? categorias.get(opCat - 1) : null;

        Producto nuevo = new Producto(productos.size() + 1, descripcion, precio, categoria);
        productos.add(nuevo);
        System.out.println("Producto agregado correctamente.");
    }

    @Override
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\nLista de productos:");
        for (Producto p : productos) {
            System.out.println(p.getInfo());
        }
    }

    @Override
    public void actualizar() {
        listar();
        int id = leerEntero("Ingrese ID del producto a modificar: ");

        for (Producto p : productos) {
            if (p.getId() == id) {
                String nuevaDesc = leerTexto("Nueva descripción: ");
                double nuevoPrecio = leerDouble("Nuevo precio: ");

                System.out.println("Seleccione nueva categoría:");
                for (int i = 0; i < categorias.size(); i++) {
                    System.out.println((i + 1) + ") " + categorias.get(i).getNombre());
                }
                int opCat = leerEntero("Opción: ");
                Categoria nuevaCat = (opCat > 0 && opCat <= categorias.size()) ? categorias.get(opCat - 1) : null;

                p.setDescripcion(nuevaDesc);
                p.setPrecio(nuevoPrecio);
                p.setCategoria(nuevaCat);

                System.out.println("Producto actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    @Override
    public void eliminar() {
        listar();
        int id = leerEntero("Ingrese ID del producto a eliminar: ");
        productos.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado (si existía).");
    }

    
    public int leerEntero(String mensaje) { return InputValidator.leerEntero(mensaje); }
    public double leerDouble(String mensaje) { return InputValidator.leerDouble(mensaje); }
    public String leerTexto(String mensaje) { return InputValidator.leerTexto(mensaje); }
}
