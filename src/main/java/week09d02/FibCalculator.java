package week09d02;

import java.util.ArrayList;
import java.util.List;

public class FibCalculator {

    private List<Long> fibonacci = new ArrayList<>();

    public List<Long> getFibonacci() {
        return fibonacci;
    }

    private long calculateNextFibonacci(int i) {
        long nextFibonacci;
        if (i == 0) {
            nextFibonacci = 0;
        } else if (i == 1) {
            nextFibonacci = 1;
        } else {
            if (fibonacci.size() >= i) {
                nextFibonacci = fibonacci.get(i - 1) + fibonacci.get(i - 2);
            } else {
                nextFibonacci = calculateNextFibonacci(i - 1) + calculateNextFibonacci(i - 2);
            }
        }
        return nextFibonacci;
    }

    public long sumEvens(int bound) {
        int i = 0;
        long sumEvens = 0;


        while (sumEvens < bound) {
            if (fibonacci.size() < i + 1) {
                fibonacci.add(calculateNextFibonacci(i));

            }
            if (fibonacci.get(i) % 2 == 0 ) {
                if (sumEvens + fibonacci.get(i)<=bound){

                    sumEvens += fibonacci.get(i);
                } else {
                    break;
                }
            }

            i++;
        }
        return sumEvens;
    }

    public static void main(String[] args) {
        FibCalculator fibCalculator = new FibCalculator();
        System.out.println(fibCalculator.sumEvens(10));
        System.out.println(fibCalculator.getFibonacci());

        System.out.println(fibCalculator.sumEvens(20));
        System.out.println(fibCalculator.getFibonacci());

        System.out.println(fibCalculator.sumEvens(45));
        System.out.println(fibCalculator.getFibonacci());
    }
}
