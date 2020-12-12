package week07d01;

public class Fibonacci {

    public static final Long[] RESULTS = new Long[2000];


    public long fib(int n) {
        if (n < 0) {
            throw new ArithmeticException("Not valid number");
        } else if (n < 2) {
            return n;
        } else {
            if (RESULTS[n] == null) {
                RESULTS[n] = fib(n - 2) + fib(n - 1);
            }
            return RESULTS[n];
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(0));
        System.out.println(fibonacci.fib(2));
        System.out.println(fibonacci.fib(3));
    }
}
