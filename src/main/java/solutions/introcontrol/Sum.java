package solutions.introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Kérek 5 számot egymás után egy sorban szóközzel elválasztva: ");
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i<5;i++){
            sum += scanner.nextInt();
        }
        System.out.println(sum);

    }
}
