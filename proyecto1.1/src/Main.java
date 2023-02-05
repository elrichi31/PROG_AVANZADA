import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        abrirLibro a1 = new abrirLibro();
        ArrayList<Libro> total = a1.leerLibros();
        for (Libro libro : total) {
            libro.traverse();
        }

    }
}