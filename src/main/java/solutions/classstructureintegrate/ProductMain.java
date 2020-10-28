package solutions.classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("What is the product?");
        String name=scanner.nextLine();
        System.out.println("What is the price?");
        int price= scanner.nextInt();

        Product product=new Product(name,price);
        System.out.println("The product is "+product.getName()+" with the price: "+product.getPrice());
        product.increasePrice(6);
        System.out.println("The product is "+product.getName()+" with the price: "+product.getPrice());
        product.decreasePrice(4);
        System.out.println("The product is "+product.getName()+" with the price: "+product.getPrice());

    }
}

