package introconsturctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;
        addMenu();
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addMenu() {
        System.out.println("Mennyi menüt adnál meg?");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Következő menü: ");

            menu.add(scanner.nextLine());

        }
    }

    @Override
    public String toString() {
        return name + ": férőhely " + capacity +
                "fő, menu " + menu.toString();
    }
}
