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
        listaLibros.forEach(e -> {
            e.traverse();
        });
    }
    // Pregunta 4
    public void imprimirAutor(List<Libro> listaLibros) {
        System.out.println("-----------------------------");
        listaLibros.sort(Comparator.comparing(Libro::getAutor));
        listaLibros.forEach(libro -> {
            ArrayList<String> palabrasKey = libro.getPalabrasClaves();
            Collections.sort(palabrasKey, Comparator.reverseOrder());
            libro.setPalabrasClaves(palabrasKey);
            libro.traverse();
        });
    }

    // public static void imprimirLibrosAgrupadosPorAnioEdicion(List<Libro> listaLibros) {
    //     Map<Year, List<Libro>> librosAgrupadosPorAnioEdicion = listaLibros.stream()
    //             .collect(Collectors.groupingBy(l -> Year.parse(l.ultEdicion().split("/")[2])));
    //     librosAgrupadosPorAnioEdicion.forEach((anio, libros) -> {
    //         System.out.println("Año de Edición: " + anio.getValue());
    //         libros.sort(Comparator.comparing(Libro::getTitulo));
    //         libros.forEach(l -> {
    //             System.out.println("\tISBN: " + l.getISBN());
    //             System.out.println("\tTitulo: " + l.getTitulo());
    //             System.out.println("\tAutor: " + l.getAutor());
    //             System.out.println("\tEdiciones: " + l.getNumEdiciones());
    //             System.out.println("\tFecha Ultima Edicion: " + l.getUltEdicion());
    //             System.out.println("\tPalabras Clave: ");
    //             List<String> palabrasClave = l.getPalabrasClaves();
    //             palabrasClave.forEach(pc -> System.out.println("\t\t" + pc));
    //             System.out.println("\tPrecio: " + l.getPrecio());
    //             System.out.println();
    //         });
    //     });
    // }
}
