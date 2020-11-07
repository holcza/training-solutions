package solutions.arrayofarrays;

import java.util.Scanner;

public class ArrayOfArraysMain {
    public int[][] multiplicationTable(int size) {
        int[][] multiTable = new int[size][size];

        for (int i = 0;i<multiTable.length;i++){
            for (int j = 0;j<multiTable[i].length;j++){
                multiTable[i][j]=(i+1)*(j+1);
            }
        }

        return multiTable;
    }

    public static void main(String[] args) {

        System.out.println("Mi legyen a szorzótábla mérete?: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();
        int [] [] table =arrayOfArraysMain.multiplicationTable(size);

        for (int i = 0;i<table.length;i++){
            for (int item: table[i]) {
                System.out.print(item+" ");
            }
            System.out.println("");
        }

    }
}
