package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        System.out.println("Hány fő érkezett?: ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        boolean a = true;
        boolean b = true;
        boolean c = true;

        scanner.nextLine();

        if (number>10){
            System.out.println("Maradtak még a parton");
        }else {
            if (number<=2||number==6||number==7||number==9||number==10){
                c=false;
            }
            if (number==3||number==8||number==9||number==10){
                b=false;
            }
            if (number>=4){
                a=false;
            }



            System.out.println("Az 5 fős csónak szabad?: "+a+" , a 3 fős csónak szabad?: "+b+" a 2 fős csónak szabad?: "+c);

        }
    }
}
