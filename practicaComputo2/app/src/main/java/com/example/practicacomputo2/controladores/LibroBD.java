package com.example.practicacomputo2.controladores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.practicacomputo2.modelos.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroBD extends SQLiteOpenHelper implements ILibroBD {

    Context contexto;
    private List<Libro> librosList = new ArrayList<>();


    //creacion del constructor
    public LibroBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.contexto = context;

    }



    //meotodo para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //creacion de la tabla libros

        String sql = "CREATE TABLE libros("+
                "id_libro INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "titulo TEXT,"+
                "subtitulo TEXT,"+
                "isbn TEXT,"+
                "autor TEXT,"+
                "yearpublicasion INTEGER,"+
                "precio REAL) ";

        sqLiteDatabase.execSQL(sql);

        String insert = "INSERT INTO Libros VALUES(null," +
                "'Percy jackson y el ladron del rayo'," +
                "'Percy jackson '," +
                "'978-84-9838-297-3'," +
                "'Rick Riordan', 2005, 15.00)";
    sqLiteDatabase.execSQL(insert);

         insert = "INSERT INTO Libros VALUES(null," +
                "'Percy jackson el mar de los monstruos'," +
                "'Percy jackson '," +
                "'10203997383'," +
                "'Rick Riordan', 2006, 20.00)";
        sqLiteDatabase.execSQL(insert);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public Libro elemento(int id) {
        return null;
    }

    @Override
    public Libro elemento(String title) {
        return null;
    }

    @Override
    public List<Libro> lista() {
        return null;
    }

    @Override
    public void agregar(Libro book) {

    }

    @Override
    public void actualizar(int id, Libro book) {

    }

    @Override
    public void borrar(int id) {

    }
}
