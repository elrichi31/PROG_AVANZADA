import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class abrirLibro {
    public static ArrayList<Libro> leerLibros(){
        ArrayList<Libro> totalLibros = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        BufferedReader br = null;

        try {
            FileInputStream file1 = new FileInputStream("src/libros.txt");
            br = new BufferedReader(new InputStreamReader(file1));
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                String ISBN = data[0];
                String titulo = data[1];
                String autor = data[2];
                int numEdiciones = Integer.parseInt(data[3]);
                Date ultEdicion = sdf.parse(data[4]);
                ArrayList<String> palabrasClaves = new ArrayList<>();
                for (int i = 5; i < data.length - 1; i++) {
                    System.out.println(data[i]);
                    palabrasClaves.add(data[i]);

                }
                double precio = Double.parseDouble(data[data.length - 1]);
                Libro libro = new Libro(ISBN, titulo, autor, numEdiciones, ultEdicion, palabrasClaves, precio);
                totalLibros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return totalLibros;
    }
}
