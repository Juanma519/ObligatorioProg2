import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.Hash.HashImpl;
import uy.edu.um.adt.Hash.MyHash;
import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
import uy.edu.um.adt.LinkedList.MyList;
import uy.edu.um.adt.Queue.EmptyQueueException;
import uy.edu.um.adt.Queue.ImplPriorityQueue;
import uy.edu.um.adt.Queue.MyPriorityQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class CargaDeDatos {
    public static MyList<Tweet> tweets;
    public static MyList<String> pilotos;
    public static MyHash<Long,Hashtag> hashtagsdiferentes;
    public static MyHash<Long,User> usuarios;
    public static MyList<User> usuariosLinkedList;
    public static int cantidadTweets;
    public static int cantidadUsuarios;

    public static void cargaDeDatos() throws IOException, NumberFormatException {
        Reader in = new FileReader("OBLIGATORIO 2023/Data/f1_dataset_test.csv");
        tweets = new MyLinkedListImpl<Tweet>();
        usuarios= new HashImpl<>(30000);
        usuariosLinkedList=new MyLinkedListImpl<User>();
        hashtagsdiferentes= new HashImpl<>(250000);
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);
        parser.iterator().next();
        int favoritos;
        for (CSVRecord record : parser) {
            String username = record.get(1);  // Acceder al valor de la segunda columna
            String fechaCreado=record.get(4);
            long idUser= generateUniqueId(fechaCreado);

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
            boolean verified;
            try {
                verified = Boolean.parseBoolean(record.get(8));
            }
            catch (NumberFormatException e) {
                continue;
            }
            String paraFecha=record.get(9);
            LocalDateTime fechatweet;
            try {
                fechatweet =convertStringToLocalDateTime(paraFecha);
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
            long idtweet=generateUniqueId(paraFecha);
            Tweet tweet = new Tweet(idtweet,texto, username, fechatweet, source, favoritos, isretweet);
            cantidadTweets++;
            tweets.add(tweet);
            if (!usuarios.contains(idUser)){  //Si no esta el usuario, lo agrega
                User usuarioTemp = new User(idUser,username,verified);
                usuarioTemp.addTweet(tweet.getId(),tweet);
                usuarios.put(usuarioTemp.getId(),usuarioTemp);
                usuariosLinkedList.add(usuarioTemp);
                cantidadUsuarios++;
                 //LOS USUARIOS SE AGREGAN BIEN
                }
            else{
                usuarios.get(idUser).addTweet(tweet.getId(),tweet);
            }
            for (int i = 0; i < values.length; i++) {
                long idhashtag=generateUniqueId(values[i]);
                Hashtag hastagtemp= new Hashtag(idhashtag,values[i]);
                if (!hashtagsdiferentes.contains(idhashtag)){
                    tweet.addHashtag(hastagtemp);
                    hashtagsdiferentes.put(idhashtag,hastagtemp);
                }
                else {
                    tweet.addHashtag(hashtagsdiferentes.get(idhashtag));
                }

            }

        }



        parser.close();
        in.close();

    }
    public static void nombrePilotos(){  //Para leer los pilotos, funciona
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
    public static void usuariosConMasTweets() throws EmptyQueueException{
        ImplPriorityQueue<User> usuariosMasTweets = new ImplPriorityQueue<>();
        for (int i = 0; i <cantidadUsuarios ; i++) {
            User usuarioT = usuariosLinkedList.get(i);
            int prioridad=usuarioT.getCantidadTweets();
            usuariosMasTweets.enqueueWithPriority(usuarioT,prioridad);

        }
        for (int i=0;i<15;i++){
            User usuarioX=usuariosMasTweets.dequeue();
            int cantidad=usuarioX.getCantidadTweets();
            String nombre=usuarioX.getName();
            String verificado;
            if (usuarioX.isVerificado()){
                 verificado="Si";
            }
            else{
                verificado="No";
            }
            System.out.println("Nombre: "+nombre+" Cantidad de tweets: "+cantidad+" Verificado: "+verificado);
        }
    }



    //Consulta 3
    public static int hashtagsDistintosDia(LocalDate dia){

        int cantidad=0;     //ACA FALTA PERO ES POR ACA
        MyHash hashtagsdia=new HashImpl<>(500);
        for (int i = 0; i < cantidadTweets; i++) {
            if(dia.compareTo(tweets.get(i).getDate().toLocalDate())==0){
                for (long j = 0; j < tweets.get(i).getHashtags().size(); j++) {
                    Hashtag tempId=tweets.get(i).getHashtags().get(j);
                   if (!hashtagsdiferentes.contains(tempId.getId())){
                       cantidad++;
                       hashtagsdia.put(tempId.getId(),tempId);
                    }
                }
            }
        }
        return cantidad;

    }
    //Consulta 4
    public static String hashtagMasUsadoDia(LocalDate dia) {
        for (int i = 0; i < cantidadTweets; i++) {
            if (dia.compareTo(tweets.get(i).getDate().toLocalDate()) == 0) {



            }
        }
        return null;
    }
    //Consulta 5
    public static void usuariosMasLikeados() throws EmptyQueueException {
        ImplPriorityQueue<User> usuariosMasLikeados=new ImplPriorityQueue<>();
        for (int i = 0; i <cantidadUsuarios ; i++) {
            User usuarioT = usuariosLinkedList.get(i);
            int prioridad=usuarioT.getFavoritos();
            usuariosMasLikeados.enqueueWithPriority(usuarioT,prioridad);
        }
        for (int i = 0; i < 7; i++) {
            User userfav=usuariosMasLikeados.dequeue();
            String nombre=userfav.getName();
            int favoritos = userfav.getFavoritos();

            int top=i+1;
            System.out.println("Top. "+top+" "+nombre+" tiene "+ favoritos +" likes");
        }


    }

    //Consulta 6
    public static int encontrarTweets(String frase) { //UNA OPCION ES HACER QUE LA HASH TENGA UNA FUNCION CON TODOS LOS VALORES
        int cantidad = 0;
        String content = "";
        for (int i = 0; i < cantidadTweets; i++) {
            content = tweets.get(i).getContent();
            if (content.contains(frase)) {
                cantidad++;
            }
        }

        return cantidad;
    }
    //Esta parte es para metodos que ayudan a la carga de datos

        public static LocalDateTime convertStringToLocalDateTime(String dateString) throws DateTimeParseException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(dateString, formatter);
        }
        public static long generateUniqueId(String fechaCreado) {
            // Aplicar función hash a la cadena para obtener un valor único
            int hashCode = Objects.hash(fechaCreado);

            // Convertir el valor hash en un ID único positivo
            long uniqueId = Math.abs((long) hashCode);
            return uniqueId;
        }
}


//0 dni 1 username 2 user location 3 descripcion 4 FECHA CREADO CUENTA DEL USER 5 followers 6friends 7 favourites
//8verified 9 date del tweet CON HORA MINUTO Y SEGUNDO 10 texto del tweet  11 hashtags 12 source 13 isretweet is boolean