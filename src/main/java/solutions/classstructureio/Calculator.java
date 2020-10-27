package solutions.classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add first int number");
        int number1 = scanner.nextInt();
        System.out.println("Add second int number");
        int number2 = scanner.nextInt();
        System.out.println(number1+"+"+number2);
        System.out.println(number1+number2);
    }
}
