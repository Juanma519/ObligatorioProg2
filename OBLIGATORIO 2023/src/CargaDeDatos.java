import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
import uy.edu.um.adt.LinkedList.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.atomic.AtomicLong;

public class CargaDeDatos {
    public static MyList<Tweet> tweets;
    public static MyList<String> pilotos;
    public static MyList<Hashtag> hashtagsdif;
    public static MyList<Hashtag> hashtagsdifdia;

    public static void cargaDeDatos() throws IOException, NumberFormatException {
        Reader in = new FileReader("OBLIGATORIO 2023/Data/f1_dataset_test.csv");
        tweets = new MyLinkedListImpl<Tweet>();
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);
        parser.iterator().next();
        int favoritos;
        for (CSVRecord record : parser) {
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
            LocalDateTime fechatweet;
            try {
                fechatweet =convertStringToLocalDateTime(record.get(9));
            } catch (Exception e) {
                System.out.println("Error en la fecha");  //ACA ESTA EK PROBLEMA
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
            long idtweet=generateUniqueId();

            //User  = new User(,username);
            Tweet tweet = new Tweet(idtweet,texto, username, fechatweet, source, favoritos, isretweet);
            tweets.add(tweet);
            for (int i = 0; i < values.length; i++) {
                Hashtag hashtag = new Hashtag(values[i], fechatweet);
                if (!tweet.getHashtags().contains(hashtag)) {
                    tweet.addHashtag(hashtag);  //CAPAZ SE PUEDE HACER ALGO PARA AGILIZAR, COMO USAR OTRO TIPO DE LISTA
                }
            }
        }

        parser.close();
        in.close();

    }
    public static void nombrePilotos(){  //Para leer losm pilotos, funciona
        String busquedaPilotos="OBLIGATORIO 2023/Data/drivers.txt";
        pilotos=new MyLinkedListImpl<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(busquedaPilotos))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pilotos.add(line);

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: ");
        }
    }

    //Consulta 1



    //Consulta 2


    //Consulta 3
    public static int hashtagsDistintosDia(LocalDate dia){

        int cantidad=0;
        hashtagsdifdia=new MyLinkedListImpl<>();
        for (int i = 0; i < tweets.size(); i++) {
            if(dia.compareTo(tweets.get(i).getDate().toLocalDate())==0){
                for (int j = 0; j < tweets.get(i).getHashtags().size(); j++) {
                   if (!hashtagsdifdia.contains(tweets.get(i).getHashtags().get(j))){
                       hashtagsdifdia.add(tweets.get(i).getHashtags().get(j));
                       cantidad++;
                    }
                }
            }
        }
        return cantidad;

    }
    //Consulta 4
    public static String hashtagMasUsadoDia(LocalDate dia) {
        for (int i = 0; i < tweets.size(); i++) {
            if (dia.compareTo(tweets.get(i).getDate().toLocalDate()) == 0) {
                //ACA FALTA PERO ES POR ACA


            }
        }
        return null;
    }
    //Consulta 5
    public static MyList usuariosMasLikeados(){
                return null;
            }

    //Consulta 6
    public static int encontrarTweets(String frase) {
        int cantidad = 0;
        String content = "";
        for (int i = 0; i < tweets.size(); i++) {
            content = tweets.get(i).getContent();
            if (content.contains(frase)) {
                cantidad++;
            }
        }

        return cantidad;
    }
    //Esta parte es para metodos que ayudan a la carga de datos
        private static final AtomicLong idCounter = new AtomicLong(0);  //ESTO ES PARA GENERAR UN ID UNICO

        public static long generateUniqueId() {
            return idCounter.incrementAndGet();
        }
        public static LocalDateTime convertStringToLocalDateTime(String dateString) throws DateTimeParseException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(dateString + formatter);
            return LocalDateTime.parse(dateString, formatter);
        }
}

//0 dni 1 username 2 user location 3 descripcion 4 FECHA CREADO CUENTA DEL USER 5 followers 6friends 7 favourites
//8verified 9 date del tweet CON HORA MINUTO Y SEGUNDO 10 texto del tweet  11 hashtags 12 source 13 isretweet is boolean