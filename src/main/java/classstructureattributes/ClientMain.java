package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client=new Client();
        Scanner scanner =new Scanner(System.in);
        System.out.println("Add the name of the client");
        client.name=scanner.nextLine();
        System.out.println("Add the year of birth of the client");
        client.year=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Add the address of the client");
        client.address=scanner.nextLine();
        System.out.println("The name of the client is "+client.name+", the year of the birth is "+client.year+", the address is "+client.address);

    }
}
