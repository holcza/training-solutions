package operationwithdouble;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        System.out.println("Mi az eredmény? 1213 + 456,876 / 789,432 *( 67,9876 - 69,4567 )");
        double result = 1213 + 456.876 / 789.432 * (67.9876 - 69.4567);
        System.out.println(result);
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        scanner.nextLine();
        if (Math.abs(number - result) < 0.0001) {
            System.out.println("Eltaláltad");
        } else {
            System.out.println("Nem jó eredmény");
        }

    }
}
