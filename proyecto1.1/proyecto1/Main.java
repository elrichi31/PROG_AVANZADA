import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.Year;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    // Funcion para abrir archivo .txt y leer los libros
    public static ArrayList<Libro> leerLibros(){
        ArrayList<Libro> totalLibros = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("libros.txt"));
            br.lines().forEach(line -> {
                String[] data = line.split(",");//data es un arreglo de strings que corresponde a cada libro del .txt
                String ISBN = data[0];
                String titulo = data[1];
                String autor = data[2];
                int numEdiciones = Integer.parseInt(data[3]);
                String ultEdicion = data[4];
                ArrayList<String> palabrasClaves = new ArrayList<>();
                for (int i = 5; i < data.length - 1; i++) {
                    palabrasClaves.add(data[i]);
                }
                double precio = Double.parseDouble(data[data.length - 1]);
                Libro libro = new Libro(ISBN, titulo, autor, numEdiciones, ultEdicion, palabrasClaves, precio);
                totalLibros.add(libro);
            });
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return totalLibros;
    }
    // Pregunta 2
    //funcion que imprime la lista original de libros desde el .txt
    public static void imprimirLibros(ArrayList<Libro> listaLibros){
        System.out.println("--------------Lista de libros---------------");
        listaLibros.forEach(e -> {
            e.traverse();
        });
    }
    // Pregunta 3
    public static void imprimirTitulo(List<Libro> listaLibros) {
        System.out.println("--------------Ordenado por Titulo---------------");
        listaLibros.sort(Comparator.comparing(Libro::getTitulo));//se ordena alfabeticamente por Titulo
        listaLibros.forEach(libro -> {//para cada libro, se ordenan sus palabras clave
            ArrayList<String> palabrasKey = libro.getPalabrasClaves();
            Collections.sort(palabrasKey, Comparator.naturalOrder());//palabras clave ordenadas alfabeticamente
            libro.setPalabrasClaves(palabrasKey);
            libro.traverse();
        });
    }
    // Pregunta 4
    public static void imprimirAutor(List<Libro> listaLibros) {
        System.out.println("--------------Ordenado por Autor---------------");
        listaLibros.sort(Comparator.comparing(Libro::getAutor));//se ordena alfabeticamente por Autor
        listaLibros.forEach(libro -> {//para cada libro, se ordenan sus palabras clave
            ArrayList<String> palabrasKey = libro.getPalabrasClaves();
            Collections.sort(palabrasKey, Comparator.reverseOrder());//palabras clave ordenadas alfabeticamente en sentido inverso
            libro.setPalabrasClaves(palabrasKey);
            libro.traverse();
        });
    }
    //Pregunta 5
    public static void agrupadoPorAutor(List<Libro> listaLibros) {
        System.out.println("--------------Agrupado por Autor---------------");
    Map<String, List<Libro>> agrupado = listaLibros.stream()//se crea un mapa 
                .collect(Collectors.groupingBy(l -> l.getAutor()));//se agrupa por autor
            agrupado.keySet().stream().sorted().forEach(l -> {
                System.out.println("Autor: " + l);//se muestra por grupo(Autor)
                List<Libro> librosPorAutor = agrupado.get(l);
                librosPorAutor.sort((l1, l2) -> l1.getAutor().compareTo(l2.getAutor()));
                //dentro del grupo, se ordena por anio de edicion
                librosPorAutor.sort((l1, l2) -> Year.parse(l1.getUltEdicion().split("/")[2]).compareTo(Year.parse(l2.getUltEdicion().split("/")[2])));
                librosPorAutor.forEach(lib -> lib.traverse());
            });
    }
    //Pregunta 6
    public static void agrupadoPorYear(List<Libro> listaLibros) {
        System.out.println("--------------Agrupado por Año---------------");
        Map<Year, List<Libro>> agrupado = listaLibros.stream()//se crea un mapa
                .collect(Collectors.groupingBy(l -> Year.parse(l.getUltEdicion().split("/")[2])));//se agrupa por anio de edicion
        agrupado.keySet().stream().sorted().forEach(l -> {//se muestra por grupo(Anio de Edicion)
            System.out.println("Year: " + l);
            List<Libro> librosPorAnio = agrupado.get(l);
            librosPorAnio.sort((l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo()));//dentro del grupo, se ordena por titulo
            librosPorAnio.forEach(lib -> lib.traverse());
        });
    }
    //Pregunta 7
    public static void imprimirLibrosConPalabrasIniciadasConP(List<Libro> listaLibros) {
        System.out.println("--------------Tienen palabras que inician con \"P\"---------------");
        listaLibros.stream()
            //se filtra el stream para comprobar que palabras claves, de un libro, empiezan con P (2 o mas)
            .filter(libro -> libro.getPalabrasClaves().stream().filter(pc -> pc.startsWith("P")).count() >= 2)
            //una vez aplicado el filtro, se ordena respecto al ISBN
            .sorted((libro1, libro2) -> libro1.getISBN().compareTo(libro2.getISBN()))
            .forEach(l -> {//se imprimen los datos del libro 
                System.out.println("ISBN: " + l.getISBN());
                System.out.println("Titulo: " + l.getTitulo());
                System.out.println("Autor: " + l.getAutor());
                System.out.println("Palabras Clave: " + l.getPalabrasClaves()
                    //solamente se muestran las palabras claves que empiezan con "P"
                    .stream().filter(pc -> pc.startsWith("P")).collect(Collectors.toList()));
                System.out.println();
            });
             
    }
    //Pregunta 8
    public static void imprimirLibrosSinPalabrasIniciadasConP(List<Libro> listaLibros) {
        System.out.println("--------------No tienen palabras que inician con \"P\"---------------");

        listaLibros.stream()
                //se filtra el stream para comprobar que palabras claves, de un libro, no empiecen con "P"
                .filter(libro -> libro.getPalabrasClaves().stream().noneMatch(palabra -> palabra.startsWith("P")))
                //una vez aplicado el filtro, se ordena por autor
                .sorted((l1, l2) -> l1.getAutor().compareTo(l2.getAutor()))
                .forEach(l -> {//se imprimen los datos del libro
                    System.out.println("ISBN: " + l.getISBN());
                    System.out.println("Titulo: " + l.getTitulo());
                    System.out.println("Autor: " + l.getAutor());
                    //se muestran todas las palabras clave
                    System.out.println("Palabras Clave: " + l.getPalabrasClaves());
                    System.out.println();
                });
    }

    public static void main(String[] args) {//funcion main 

        ArrayList<Libro> total = leerLibros();
        imprimirLibros(total);
        imprimirTitulo(total);
        imprimirAutor(total);
        agrupadoPorAutor(total);
        agrupadoPorYear(total);
        imprimirLibrosConPalabrasIniciadasConP(total);
        imprimirLibrosSinPalabrasIniciadasConP(total);
    }
}