package crudpoo;

import java.util.List;

public interface CrudInterface<T> {
    void crear();
    void listar();
    void actualizar();
    void eliminar();
    void mostrarOpciones();

    //validadores
    int leerEntero(String mensaje);
    double leerDouble(String mensaje);
    String leerTexto(String mensaje);
    
}
