package crudpoo;

public class Categoria extends Entidad  {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(int id, String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getInfo() {
        return "ID: " + id + " | Nombre: " + nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
