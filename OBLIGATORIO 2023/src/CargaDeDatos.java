import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CargaDeDatos {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("OBLIGATORIO 2023/Data/f1_dataset_test.csv");
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);
        parser.iterator().next();
        int favoritos;
        for (CSVRecord record : parser) {
            String id = record.get(0);  // Acceder al valor de la primera columna
            String username = record.get(1);  // Acceder al valor de la segunda columna
            if (record.get(7).contains(".")) {
                double doubleValue = Double.parseDouble(record.get(7));
                favoritos = (int) Math.round(doubleValue);
            }
            else {
                favoritos = Integer.parseInt(record.get(7));
            }
            String texto = record.get(10);
            String hashtags = record.get(11);
            String source = record.get(12);
            boolean isRetweet;
            if (record.get(13).equalsIgnoreCase("True")) {
                isRetweet = true;
            } else{
                isRetweet = false;
            }
            //User  = new User(id,username);  //HAY UNOS PROBLEMAS CON LOS LONG Y LOS BOOLEAN E INt
            System.out.println(id + " " + username + " " + favoritos + " " + texto + " " + hashtags + " " + source + " " + isRetweet);
        }
//la primera columna no es id
        parser.close();
        in.close();

    }
}
//1 dni 2 user name 3 user location 4 descripcion 5 año creado cuenta 6 followers 7friends 8 favourites
//9verified 10 date del tweet 11 texto del tweet  12 hashtags 13 source 14 isretweet is boolean