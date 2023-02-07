import java.util.ArrayList;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numEdiciones;
    private String ultEdicion;
    private ArrayList<String> palabrasClaves;
    private double precio;

    //contructor
    public Libro(){
    }
    public Libro(String ISBN, String titulo, String autor, int numEdiciones, String ultEdicion, ArrayList<String> palabrasClaves, double precio) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numEdiciones = numEdiciones;
        this.ultEdicion = ultEdicion;
        this.palabrasClaves = palabrasClaves;
        this.precio = precio;
    }

    //funcion traverse, definida para imprimir los datos de cada libro
    public void traverse(){
        System.out.println("ISBN: " + this.ISBN + ", Titulo: " + this.titulo + ", Autor: " + this.autor + ", Nro de ediciones: " +
                this.numEdiciones + ", Ultima edicion: " + this.ultEdicion +
                ", Palabras clave: " + this.palabrasClaves + ", Precio: " + this.precio);
    }
    //funciones get y set de cada dato para cada libro
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumEdiciones() {
        return numEdiciones;
    }

    public void setNumEdiciones(int numEdiciones) {
        this.numEdiciones = numEdiciones;
    }

    public String getUltEdicion() {
        return ultEdicion;
    }

    public void setUltimaEdicion(String ultEdicion) {
        this.ultEdicion = ultEdicion;
    }

    //se maneja a las palabras clave como un ArrayList, con sus funciones set y get
    public ArrayList<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(ArrayList<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
