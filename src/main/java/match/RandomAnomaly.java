package match;

import java.util.Arrays;
import java.util.Random;

public class RandomAnomaly {

    public double[] randomNumbers(int size, double max, int scale) {

        double[] numbers = new double[size];

        Random rnd = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt((int) (max * Math.pow(10, scale))) / (double) Math.pow(10, scale);
        }

        return numbers;

    }

    public double roundAfterSum(double[] numbers) {
        int sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers) {
        int sum = 0;
        for (double number : numbers) {
            sum += Math.round(number);
        }
        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);

        return roundAfterSum(numbers) - sumAfterRound(numbers);
    }

    public static void main(String[] args) {
        RandomAnomaly randomAnomaly = new RandomAnomaly();
        double average = 0;
        double count = 0;
        for (int i = 0; i < 100; i++) {

            average += randomAnomaly.difference(1000, 1000000, 5);
            count++;
        }

        System.out.println(average / count);

        Random rnd = new Random();
        System.out.println(rnd.nextInt((int) (1000 * Math.pow(10, 2))) / (double) Math.pow(10, 2));

    }


}
