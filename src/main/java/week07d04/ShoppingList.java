package week07d04;

import week06d04.ShoppingCart;

import java.util.Scanner;

public class ShoppingList {

    public long calculatePath(String path) {
        Scanner scanner = new Scanner(path);
        String pathLine = "";
        long sum = 0;
        while (scanner.hasNextLine()) {
            pathLine = scanner.nextLine();
            String[] parts = pathLine.split(";");
            sum += Long.parseLong(parts[1]) * Long.parseLong(parts[2]);
        }

        return sum;
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        long sum =  shoppingList.calculatePath("kenyér;2;3\ntej;3;4");
        System.out.println(sum);
    }
}
