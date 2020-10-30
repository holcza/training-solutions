package solutions.statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        System.out.println("Adj meg egy számot:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner. nextInt();
        System.out.println("A szám osztható 3-mal : "+(number%3==0 ? true : false));
    }
}
