package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérek egy számot: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number>100){
            System.out.println("nagyobb, mint száz");

        }else {
            System.out.println("száz, vagy kisebb");
        }
    }
}
