import java.util.ArrayList;
import java.util.Date;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numEdiciones;
    private Date ultEdicion;
    private ArrayList<String> palabrasClaves;
    private double precio;

    public Libro(){

    }
    public Libro(String ISBN, String titulo, String autor, int numEdiciones, Date ultEdicion, ArrayList<String> palabrasClaves, double precio) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numEdiciones = numEdiciones;
        this.ultEdicion = ultEdicion;
        this.palabrasClaves = palabrasClaves;
        this.precio = precio;
    }

    

    public void traverse(){
        System.out.println("ISBN: " + this.ISBN + ", Titulo: " + this.titulo + ", Autor: " + this.autor + ", Nro de ediciones: " +
                this.numEdiciones + ", Ultima edicion: " + this.ultEdicion +
                ", Palabras clave: " + this.palabrasClaves + ", Precio: " + this.precio);
    }
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

    public Date getUltEdicion() {
        return ultEdicion;
    }

    public void setUltimaEdicion(Date ultEdicion) {
        this.ultEdicion = ultEdicion;
    }

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
