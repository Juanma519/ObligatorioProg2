import uy.edu.um.adt.Queue.EmptyQueueException;

import java.time.LocalDate;
import java.util.Scanner;

;
public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    try {
                        CargaDeDatos.cargaDeDatos();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error en la carga de datos");
                        continue;
                    }
                    break;

                case 1:
                    opcion1(sc);
                    break;

                case 2:
                    opcion2();
                    break;

                case 3:
                    opcion3(sc);
                    break;

                case 4:
                    opcion4(sc);
                    break;
                case 5:
                    opcion5();
                    break;
                case 6:
                    opcion6(sc);
                    break;

                case 7:
                    System.out.println("Salir del programa");
                    sc.close();
                    break;


                default:
                    System.out.println("Opcion no valida,vuelva a intentarlo");
                    break;
            }


        } while (opcion != 7);
    }
    public static void mostrarMenu(){
        System.out.println("Digite que informacion requiere: ");
        System.out.println("0.Carga de datos");
        System.out.println("1.Los 10 pilotos mas mencionados en un mes especifico");
        System.out.println("2.Los 15 usuarios con mas tweets");
        System.out.println("3.Cantidad de hashtags distintos para un dia dado");
        System.out.println("4.Los hashtags mas usados en un dia dado");
        System.out.println("5.Top 7 cuentas con mas likes");
        System.out.println("6.Cantidad de tweets con una palabra o frase especifica");
        System.out.println("7.Salir del programa");
    }
    public static void opcion1(Scanner sc){
        int year = 0;
        int month=0;
        System.out.println("Digite el año que desea consultar: ");
        try {
            year = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Formato de año incorrecto");
        }
        System.out.println("Digite el mes que desea consultar: ");
        try {
            month = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Formato de mes incorrecto");

        }
        LocalDate fecha = LocalDate.of(year, month, 1);
    }
    public static void opcion2() throws EmptyQueueException {
        CargaDeDatos.usuariosConMasTweets();
    }
    public static void opcion3(Scanner sc){
        System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
        sc.nextLine();
        String format = sc.nextLine();
        LocalDate dia = LocalDate.parse(format);
        try {
            CargaDeDatos.hashtagsDistintosDia(dia);
            System.out.println("La cantidad de hashtags distintos el" + dia + " son: " + CargaDeDatos.hashtagsDistintosDia(dia));
        }catch (Exception e){
            System.out.println("La cantidad de hashtags distintos el" + dia + " son: 0 ");
        }
    }

    public static void opcion4(Scanner sc){

        System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
        sc.nextLine();
        String format = sc.nextLine();
        LocalDate dia = LocalDate.parse(format);
    }
    public static void opcion5() throws EmptyQueueException {
        CargaDeDatos.usuariosMasLikeados();

    }
    public static void opcion6(Scanner sc){
        System.out.println("Digite la palabra o frase que desea buscar: ");
        sc.nextLine();
        String frase = sc.nextLine();
        int veces = CargaDeDatos.encontrarTweets(frase);
        System.out.println("La cantidad de tweets con la palabra o frase especifica es: " + veces);

    }
}

