package com.example.practicacomputo2.controladores;
import com.example.practicacomputo2.modelos.Libro;
import java.util.List;
public interface ILibroBD {

    //metodos de la interfaz
    Libro elemento(int id);
    Libro elemento(String title);
    List<Libro> lista();

    //metodos para agregar, actualizar y borrar
    void agregar(Libro book);
    void actualizar(int id, Libro book);
    void borrar(int id);

}
