import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class abrirLibro {
    public static ArrayList<Libro> leerLibros(){
        ArrayList<Libro> totalLibros = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/libros.txt"));
            br.lines().forEach(line -> {
                String[] data = line.split(",");
                String ISBN = data[0];
                String titulo = data[1];
                String autor = data[2];
                int numEdiciones = Integer.parseInt(data[3]);
                Date ultEdicion = new Date();
                try {
                    ultEdicion = sdf.parse(data[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
}

