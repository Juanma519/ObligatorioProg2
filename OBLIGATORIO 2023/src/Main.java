import java.time.LocalDate;
import java.util.Scanner;

;
public class Main {
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
                        System.out.println("Error en la carga de datos");
                        break;
                    }
                    break;

                case 1:
                    int year;
                    int month;
                    System.out.println("Digite el año que desea consultar: ");
                    try {
                        year = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Formato de año incorrecto");
                        break;
                    }
                    System.out.println("Digite el mes que desea consultar: ");
                    try {
                        month = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Formato de mes incorrecto");
                        break;
                    }
                    LocalDate fecha = LocalDate.of(year, month, 1); //Esta parte funciona, adquiere la fecha
                    break;

                case 2:
                    break;

                case 3:
                    Scanner scfecha = new Scanner(System.in);
                    System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
                    try {
                        String format = scfecha.nextLine();
                        LocalDate dia = LocalDate.parse(format);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto");
                        break;
                    }
                    break;

                case 4:
                    Scanner scfecha2 = new Scanner(System.in);
                    System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
                    String format = scfecha2.nextLine();
                    LocalDate dia = LocalDate.parse(format);
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Digite la palabra o frase que desea buscar: ");
                    String frase = sc.nextLine();
                    int veces = CargaDeDatos.encontrarTweets(frase);
                    System.out.println("La cantidad de tweets con la palabra o frase especifica es: " + veces);
                    break;

                case 7:
                    System.out.println("Salir del programa");
                    break;

                default:
                    System.out.println("Opcion no valida,vuelva a intentarlo");
                    break;
            }


        } while (opcion != 7);
    }

}

