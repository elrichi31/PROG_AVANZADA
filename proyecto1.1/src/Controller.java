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
    // Pregunta 3
    public void imprimirTitulo(List<Libro> listaLibros) {
        System.out.println("--------------Ordenado por Titulo---------------");
        listaLibros.sort(Comparator.comparing(Libro::getTitulo));
        listaLibros.forEach(libro -> {
            ArrayList<String> palabrasKey = libro.getPalabrasClaves();
            Collections.sort(palabrasKey, Comparator.naturalOrder());
            libro.setPalabrasClaves(palabrasKey);
            libro.traverse();
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
    //Pregunta 5
    public void agrupadoPorAutor(List<Libro> listaLibros) {
        System.out.println("--------------Agrupado por Autor---------------");
    Map<String, List<Libro>> agrupado = listaLibros.stream()
                .collect(Collectors.groupingBy(l -> l.getAutor()));
            agrupado.keySet().stream().sorted().forEach(l -> {
                System.out.println("Autor: " + l);
                List<Libro> librosPorAutor = agrupado.get(l);
                librosPorAutor.sort((l1, l2) -> l1.getAutor().compareTo(l2.getAutor()));
                librosPorAutor.forEach(lib -> lib.traverse());
            });
    }
    //Pregunta 6
    public void agrupadoPorYear(List<Libro> listaLibros) {
        System.out.println("--------------Agrupado por Año---------------");
        Map<Year, List<Libro>> agrupado = listaLibros.stream()
                .collect(Collectors.groupingBy(l -> Year.parse(l.getUltEdicion().split("/")[2])));
        agrupado.keySet().stream().sorted().forEach(l -> {
            System.out.println("Year: " + l);
            List<Libro> librosPorAnio = agrupado.get(l);
            librosPorAnio.sort((l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
            librosPorAnio.forEach(lib -> lib.traverse());
        });
    }
    //Pregunta 7
    public void imprimirLibrosConPalabrasIniciadasConP(List<Libro> listaLibros) {
        System.out.println("--------------Tienen palabras que inician con \"P\"---------------");
        listaLibros.stream()
            .filter(libro -> libro.getPalabrasClaves().stream().filter(pc -> pc.startsWith("P")).count() >= 2)
            .sorted((libro1, libro2) -> libro1.getISBN().compareTo(libro2.getISBN()))
            .forEach(libro -> {
                System.out.println("Palabras Clave que inician con 'P': ");
                libro.getPalabrasClaves().stream()
                    .filter(pc -> pc.startsWith("P"))
                    .sorted((pc1, pc2) -> pc2.compareTo(pc1))
                    .forEach(pc -> System.out.println(" - " + pc));
                libro.traverse();
                System.out.println();
            });
    }
    //Pregunta 8
    public void imprimirLibrosSinPalabrasIniciadasConP(List<Libro> listaLibros) {
        System.out.println("--------------No tienen palabras que inician con \"P\"---------------");

        listaLibros.stream()
                .filter(libro -> libro.getPalabrasClaves().stream().noneMatch(palabra -> palabra.startsWith("P")))
                .sorted((l1, l2) -> l1.getAutor().compareTo(l2.getAutor()))
                .forEach(l -> {
                    System.out.println("ISBN: " + l.getISBN());
                    System.out.println("Titulo: " + l.getTitulo());
                    System.out.println("Autor: " + l.getAutor());
                    System.out.println("Palabras Clave: " + l.getPalabrasClaves());
                    System.out.println();
                });
    }
}
