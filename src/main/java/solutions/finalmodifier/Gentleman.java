package solutions.finalmodifier;

import java.util.Scanner;

public class Gentleman {

    private static final String MESSAGE_PREFIX = "Hello ";

    public String sayHello(String name) {
        return MESSAGE_PREFIX + name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mi a neved?");
        System.out.println(new Gentleman().sayHello(scanner.nextLine()));
    }
}
