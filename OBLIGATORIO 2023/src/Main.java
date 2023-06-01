import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite que informacion requiere: ");
        System.out.println("1.Los 10 pilotos mas mencionados en un mes especifico");
        System.out.println("2.Los 15 usuarios con mas tweets");
        System.out.println("3.Cantidad de hashtags distintos para un dia dado");
        System.out.println("4.Los hashtags mas usados en un dia dado");
        System.out.println("5.Top 7 cuentas con mas likes");
        System.out.println("6.Cantidad de tweets con una palabra o frase especifica");
        int opcion = sc.nextInt();
        if (opcion==1){
            System.out.println("Digite el año que desea consultar: ");
            int year = sc.nextInt();
            System.out.println("Digite el mes que desea consultar: ");
            int month = sc.nextInt();
        }
        if (opcion==2){

        }
        if (opcion==3){
            System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
            String format = sc.nextLine();
            SimpleDateFormat dia = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (opcion==4){
            System.out.println("Digite el dia en notacion YYYY-MM-DD: ");
            String format = sc.nextLine();
            SimpleDateFormat dia = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (opcion==5){

        }
        if (opcion==6){
            System.out.println("Digite la palabra o frase que desea buscar: ");
            String frase = sc.nextLine();

        }
        else {
            System.out.println("Opcion no valida");
        }




    }
}
