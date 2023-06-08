import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CargaDeDatos {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("ACA VA EL NOMBRE DEL ARCHIVO");
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);

        for (CSVRecord record : parser) {
            String columna1 = record.get(0);  // Acceder al valor de la primera columna
            String columna2 = record.get(1);  // Acceder al valor de la segunda columna
            // ... y así sucesivamente
            System.out.println(columna1 + " - " + columna2);
        }
        parser.close();
        in.close();
    }
}
