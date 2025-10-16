package crudpoo;

public class Producto extends Entidad {
    private String descripcion;
    private double precio;
    private Categoria categoria;

    public Producto(int id, String descripcion, double precio, Categoria categoria) {
        super(id);
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getInfo() {
        return "ID: " + id + " | Descripción: " + descripcion + " | Precio: $" + precio +
               " | Categoría: " + (categoria != null ? categoria.getNombre() : "Sin categoría");
    }
}
