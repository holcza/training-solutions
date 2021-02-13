package week10d05;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public void findMinMaxSum(int[] arr) {
        Arrays.sort(arr);
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length && i < 4; i++) {
            min += arr[i];
            max += arr[arr.length - 1 - i];
        }

        System.out.printf("The min sum is %d, the max sum is %d", min, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Give the numbers for the min and max sum operation");
        int index = 0;
        String s = scanner.nextLine();
        String[] arrString = s.split(" ");
        int[] arr = new int[arrString.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }

        new Calculator().findMinMaxSum(arr);
    }
}
