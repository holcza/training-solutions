package week07d04;

import week06d04.ShoppingCart;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ShoppingList {

    public long calculatePath(String path) {
        String pathLine = "";
        long sum = 0;
        try(Scanner scanner = new Scanner(Path.of(path), StandardCharsets.UTF_8)){

            while (scanner.hasNextLine()) {
                pathLine = scanner.nextLine();
                String[] parts = pathLine.split(";");
                sum += Long.parseLong(parts[1]) * Long.parseLong(parts[2]);
            }


        } catch (IOException ioe){
            throw new IllegalStateException("File can not be read",ioe);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException{
        ShoppingList shoppingList = new ShoppingList();
        System.out.println(Path.of("src/main/resources/week07d04.shoppingList.dat").toRealPath());
        long sum =  shoppingList.calculatePath("src/main/resources/week07d04.shoppingList.dat");
        System.out.println(sum);
    }
}
