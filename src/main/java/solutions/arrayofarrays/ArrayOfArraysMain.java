package solutions.arrayofarrays;

import java.util.Scanner;

public class ArrayOfArraysMain {
    public int[][] multiplicationTable(int size) {
        int[][] multiTable = new int[size][size];

        for (int i = 0; i < multiTable.length; i++) {
            for (int j = 0; j < multiTable[i].length; j++) {
                multiTable[i][j] = (i + 1) * (j + 1);
            }
        }

        return multiTable;
    }

    public void printArrayOfArrays(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] >= 100) {
                    System.out.print(a[i][j] + " ");
                } else {
                    if (a[i][j] >= 10) {
                        System.out.print("_" + a[i][j] + " ");
                    } else {
                        System.out.print("__" + a[i][j] + " ");
                    }
                }

            }
            System.out.println("");
        }
    }

    public int[][] triangularMatrix(int size) {
        int[][] triangular = new int[size][];
        for (int i = 0; i < triangular.length; i++) {
            triangular[i] = new int[i + 1];
            for (int j = 0; j < triangular[i].length; j++) {
                triangular[i][j] = i;
            }
        }
        return triangular;
    }

    public int[][] getValues() {
        int[][] calendar = new int[12][];
        for (int i = 0; i < calendar.length; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11) {
                calendar[i] = new int[31];
            } else {
                if (i == 1) {
                    calendar[i] = new int[28];
                } else {
                    calendar[i] = new int[30];
                }
            }
            for (int j = 0; j < calendar[i].length; j++) {
                calendar[i][j] = j;
            }
        }
        return calendar;
    }


    public static void main(String[] args) {

        System.out.println("Mi legyen a szorzótábla mérete?: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();
        int[][] table = arrayOfArraysMain.multiplicationTable(size);
        arrayOfArraysMain.printArrayOfArrays(table);
        System.out.println("Mi legyen a háromszög mérete?: ");
        size = scanner.nextInt();
        scanner.nextLine();
        int[][] triangular = arrayOfArraysMain.triangularMatrix(size);
        arrayOfArraysMain.printArrayOfArrays(triangular);
        scanner.nextLine();
        int[][] calendar = arrayOfArraysMain.getValues();
        arrayOfArraysMain.printArrayOfArrays(calendar);
    }
}
