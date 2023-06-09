import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
import uy.edu.um.adt.LinkedList.MyList;

import java.time.LocalDate;
import java.util.Scanner;

;
public class Main {
    private static MyList<User> usuarios=new MyLinkedListImpl();
    private static MyList<Tweet> tweets=new MyLinkedListImpl(); //HAY QUE VER DE Q TIPO DE LISTA USAMOS, PARA MEJORAR LA EFICIENCIA
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite que informacion requiere: ");
        System.out.println("0.Carga de datos");
        System.out.println("1.Los 10 pilotos mas mencionados en un mes especifico");
        System.out.println("2.Los 15 usuarios con mas tweets");
        System.out.println("3.Cantidad de hashtags distintos para un dia dado");
        System.out.println("4.Los hashtags mas usados en un dia dado");
        System.out.println("5.Top 7 cuentas con mas likes");
        System.out.println("6.Cantidad de tweets con una palabra o frase especifica");
        int opcion;
        do {
            System.out.println("Digite que informacion requiere: ");
            System.out.println("0.Carga de datos");
            System.out.println("1.Los 10 pilotos mas mencionados en un mes especifico");
            System.out.println("2.Los 15 usuarios con mas tweets");
            System.out.println("3.Cantidad de hashtags distintos para un dia dado");
            System.out.println("4.Los hashtags mas usados en un dia dado");
            System.out.println("5.Top 7 cuentas con mas likes");
            System.out.println("6.Cantidad de tweets con una palabra o frase especifica");
            System.out.println("7.Salir del programa");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    try {
                        CargaDeDatos.CargaDeDatos();
                    } catch (Exception e) {
                        e.printStackTrace(); //no creo q sea esta excepcion
                        continue;
                    }

                case 1:
                    int year;
                    int month;
                    System.out.println("Digite el año que desea consultar: ");
                    try {
                        year = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Formato de año incorrecto");
                        continue;
                    }
                    System.out.println("Digite el mes que desea consultar: ");
                    try {
                        month = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Formato de mes incorrecto");
                        continue;
                    }
                    LocalDate fecha = LocalDate.of(year, month, 1); //Esta parte funciona, adquiere la fecha
                    continue;

                case 2:
                    continue;

                case 3:
                    Scanner scfecha = new Scanner(System.in);
                    System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
                    try {
                        String format = scfecha.nextLine();
                        LocalDate dia = LocalDate.parse(format);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto");
                        continue;
                    }
                    continue;

                case 4:
                    Scanner scfecha2 = new Scanner(System.in);
                    System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
                    String format = scfecha2.nextLine();
                    LocalDate dia = LocalDate.parse(format);
                    continue;
                case 5:
                    continue;
                case 6:
                    System.out.println("Digite la palabra o frase que desea buscar: ");
                    String frase = sc.nextLine();
                    int veces = encontrarTweets(frase);
                    System.out.println("La cantidad de tweets con la palabra o frase especifica es: " + veces);
                    continue;

                case 7:
                    System.out.println("Salir del programa");
                    break;

                default:
                    System.out.println("Opcion no valida,vuelva a intentarlo");
                    continue;
            }


        } while (opcion != 7);
    }
    public static int encontrarTweets(String frase){
        int cantidad=0;
        for(int i=0;i<tweets.size();i++){
            if(tweets.get(i).getContent().contains(frase)){
                cantidad++;
                }
         }
        return cantidad;
    }
}

