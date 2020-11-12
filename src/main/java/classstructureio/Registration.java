package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Add username");
        String username= scanner.nextLine();
        System.out.println("Add email");
        String email= scanner.nextLine();
        System.out.println("You registered with username: "+username+" and email: "+email);

    }
}
