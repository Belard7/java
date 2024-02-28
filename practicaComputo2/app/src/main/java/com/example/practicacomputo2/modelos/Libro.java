package com.example.practicacomputo2.modelos;

public class Libro {

    private  int id_libro;
    private String titulo, subtitulo, isbn,autor;
    private int yearpublicasion;
    private double precio;

    //Constructor sin argumetos

    public Libro(){

    }

    //constructor con argumentos


    public Libro(int id_libro, String titulo, String subtitulo, String isbn, String autor, int yearpublicasion, double precio) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.isbn = isbn;
        this.autor = autor;
        this.yearpublicasion = yearpublicasion;
        this.precio = precio;
    }

    //metodos getter y setter
    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYearpublicasion() {
        return yearpublicasion;
    }

    public void setYearpublicasion(int yearpublicasion) {
        this.yearpublicasion = yearpublicasion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //metodo toString sirve para imprimir el objeto

    @Override
    public String toString() {
        return "Libro{" +
                "id_libro=" + id_libro +
                ", titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", yearpublicasion=" + yearpublicasion +
                ", precio=" + precio +
                '}';
    }
}


