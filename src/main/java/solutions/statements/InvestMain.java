package solutions.statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        System.out.println("Add meg a befektetett összeget: ");
        Scanner scanner = new Scanner(System.in);
        int fund = scanner.nextInt();

        System.out.println("Add meg a kamatlábat: ");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(fund,interestRate);
        System.out.println("Befektetett összeg:");
        System.out.println(investment.getFund());
        System.out.println("Kamatláb: ");
        System.out.println(interestRate);

        System.out.println("Hány napra szeretnéd megnézni a hozamot?");
        int days = scanner.nextInt();

        System.out.println("Hozam "+days+" napra: "+investment.getYield(days));

        System.out.println("Hány napra szeretnéd kivenni a befektetést?");
        days = scanner.nextInt();

        System.out.println("Kivett összeg "+days+" nap után: "+investment.close(days));

        System.out.println("Hány napra szeretnéd kivenni a befektetést?");
        days = scanner.nextInt();

        System.out.println("Kivett összeg "+days+" nap után: "+investment.close(days));
    }
}
