package introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        System.out.println("1. Felhasználók listázása\n" +
                "2. Felhasználó felvétele\n" +
                "Többi: Kilépés");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number==1){
            System.out.println("Felhasználók listázása");
        }else{
            if (number==2){
                System.out.println("Felhasználó felvétele");
            }
        }
    }
}
