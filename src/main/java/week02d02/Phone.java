package week02d02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public int getMem() {
        return mem;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Telefon1 típusa: ");
        String type1 = scanner.nextLine();
        System.out.println("Telefon1 memória mérete: ");
        int mem1 = scanner.nextInt();
        scanner.nextLine();
        Phone phone1 = new Phone(type1, mem1);
        System.out.println("Telefon2 típusa: ");
        String type2 = scanner.nextLine();
        System.out.println("Telefon2 memória mérete: ");
        int mem2 = scanner.nextInt();
        scanner.nextLine();
        Phone phone2 = new Phone(type2, mem2);

        System.out.println("Első telefon típusa: " + phone1.type + " ,memória mérete: " + phone1.mem);
        System.out.println("Második telefon típusa: " + phone2.type + " ,memória mérete: " + phone2.mem);
    }
}
