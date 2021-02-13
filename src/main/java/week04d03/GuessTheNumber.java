package week04d03;

import javax.security.sasl.SaslClient;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Random rnd = new Random();
        int number = rnd.nextInt(100)+1;

        Scanner scanner =new Scanner(System.in);
        int guess=0;
        boolean match=false;
        for (int i =0;i<6;i++){
            System.out.println("Mi a tipped?");
            guess=scanner.nextInt();
            scanner.nextLine();
            if (guess==number){
                System.out.println("Eltaláltad!!:)");
                match=true;
                break;
            } else if (number>guess) {
                System.out.println("Ennél nagyobb");
            } else {
                System.out.println("Ennél kisebb");
            }
        }
        if (match==false){

            System.out.println("Sajnos nem találtad ki!");
            System.out.println(number);
        }

    }
}
