import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.LinkedList.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

public class CargaDeDatos {
    public static MyList<Tweet> tweets;
    public static MyList<Hashtag> hashtagsdif;
    public static void CargaDeDatos() throws IOException, NumberFormatException {
        Reader in = new FileReader("OBLIGATORIO 2023/Data/f1_dataset_test.csv");
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);
        parser.iterator().next();
        int favoritos;
        for (CSVRecord record : parser) {
            long idtweet;
            try {
                idtweet = Long.parseLong(record.get(0));
            }  // Acceder al valor de la primera columna
            catch (NumberFormatException e) {
                continue;
            }
            String username = record.get(1);  // Acceder al valor de la segunda columna
            try {
                if (record.get(7).contains(".")) {
                    double doubleValue = Double.parseDouble(record.get(7));
                    favoritos = (int) Math.round(doubleValue);
                } else {
                    favoritos = Integer.parseInt(record.get(7));
                }
            } catch (NumberFormatException e) {
                continue;
            }
            LocalDate fecha;
            try {
                fecha = LocalDate.parse(record.get(9));
            } catch (Exception e) {
                continue;
            }
            String texto = record.get(10);

            String cleanInput = record.get(11).replaceAll("[\\[\\]']", ""); // Eliminar los corchetes y las comillas
            String[] values = cleanInput.split(", "); // Dividir la cadena en partes separadas por comas

            String source = record.get(12);

            boolean isretweet;
            try {
                isretweet = Boolean.parseBoolean(record.get(13));
            } catch (NumberFormatException e) {
                continue;
            }

            //User  = new User(id,username);  //HAY UNOS PROBLEMAS CON LOS LONG Y LOS BOOLEAN E INt
            Tweet tweet = new Tweet(idtweet, texto, username, fecha, source, favoritos, isretweet);
            tweets.add(tweet);
            for (int i = 0; i < values.length; i++) {
                Hashtag hashtag = new Hashtag(values[i], fecha);
                if (!hashtagsdif.contains(hashtag)) {
                    hashtagsdif.add(hashtag);  //CAPAZ SE PUEDE HACER ALGO PARA AGILIZAR, COMO USAR OTRO TIPO DE LISTA
                }
            }
        }
//la primera columna no es id
        parser.close();
        in.close();

    }
    public static int encontrarTweets(String frase){
        int cantidad=0;
        String content="";
        for(int i=0;i<tweets.size();i++){
            content=tweets.get(i).getContent();
            if(content.contains(frase)) {
                cantidad++;
            }
        }

        return cantidad;
    }
}
//1 dni 2 user name 3 user location 4 descripcion 5 año creado cuenta 6 followers 7friends 8 favourites
//9verified 10 date del tweet 11 texto del tweet  12 hashtags 13 source 14 isretweet is boolean