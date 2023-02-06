import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> total = abrirLibro.leerLibros();
        Controller c1 = new Controller();
        c1.imprimirLibros(total);
        c1.imprimirTitulo(total);
        c1.imprimirAutor(total);
        c1.agrupadoPorAutor(total);
        c1.agrupadoPorYear(total);
        c1.imprimirLibrosSinPalabrasIniciadasConP(total);
    }
}