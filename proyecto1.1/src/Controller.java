import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.Year;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    // Pregunta 2
    public void imprimirLibros(ArrayList<Libro> listaLibros){
        System.out.println("--------------Lista de libros---------------");
        listaLibros.forEach(e -> {
            e.traverse();
        });
    }
    // Pregunta 4
    public void imprimirAutor(List<Libro> listaLibros) {
        System.out.println("--------------Ordenado por Autor---------------");
        listaLibros.sort(Comparator.comparing(Libro::getAutor));
        listaLibros.forEach(libro -> {
            ArrayList<String> palabrasKey = libro.getPalabrasClaves();
            Collections.sort(palabrasKey, Comparator.reverseOrder());
            libro.setPalabrasClaves(palabrasKey);
            libro.traverse();
        });
    }
    //Pregunta 6
    public void agrupadoPorYear(List<Libro> listaLibros) {
        System.out.println("--------------Agrupado por Año---------------");
        Map<Year, List<Libro>> agrupado = listaLibros.stream()
                .collect(Collectors.groupingBy(l -> Year.parse(l.getUltEdicion().split("/")[2])));
        agrupado.forEach((year, libros) -> {
            libros.sort(Comparator.comparing(Libro::getTitulo));
            libros.forEach(l -> l.traverse());
        });
    }
}
