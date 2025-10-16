package crudpoo;

import java.util.ArrayList;

public class CrudCategorias implements CrudInterface<Categoria>  {
    private final ArrayList<Categoria> categorias;
    public final java.util.Scanner scanner = InputValidator.scanner;

    public CrudCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("\n=== CRUD de Categorías ===");
        System.out.println("1) Crear categoría");
        System.out.println("2) Listar categorías");
        System.out.println("3) Actualizar categoría");
        System.out.println("4) Eliminar categoría");
        System.out.println("0) Volver al menú principal");
        System.out.print("Opción: ");
    }

    @Override
    public void crear() {
        String nombre = leerTexto("Ingrese nombre de la categoría: ");
        Categoria nueva = new Categoria(categorias.size() + 1, nombre);
        categorias.add(nueva);
        System.out.println("Categoría creada con éxito.");
    }

    @Override
    public void listar() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
            return;
        }
        System.out.println("\nLista de categorías:");
        for (Categoria c : categorias) {
            System.out.println(c.getInfo());
        }
    }

    @Override
    public void actualizar() {
        listar();
        int id = leerEntero("Ingrese ID de la categoría a actualizar: ");
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                String nuevoNombre = leerTexto("Nuevo nombre: ");
                c.setNombre(nuevoNombre);
                System.out.println("Categoría actualizada.");
                return;
            }
        }
        System.out.println("Categoría no encontrada.");
    }

    @Override
    public void eliminar() {
        listar();
        int id = leerEntero("Ingrese ID de la categoría a eliminar: ");
        categorias.removeIf(c -> c.getId() == id);
        System.out.println("Categoría eliminada (si existía).");
    }

    // Métodos auxiliares (implementados por la interfaz)
    public int leerEntero(String mensaje) { return InputValidator.leerEntero(mensaje); }
    public double leerDouble(String mensaje) { return InputValidator.leerDouble(mensaje); }
    public String leerTexto(String mensaje) { return InputValidator.leerTexto(mensaje); }
}
