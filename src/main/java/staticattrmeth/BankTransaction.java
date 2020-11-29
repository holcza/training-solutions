package staticattrmeth;

import java.math.BigDecimal;

public class BankTransaction {

    private final static long MIN = 1;
    private final static long MAX = 10000000;

    private static long currentMinValue;
    private static long currentMaxValue;

    private static BigDecimal currentSumValue;
    private static long currentCount;


    private long trxValue;

    public BankTransaction(long trxValue) {
        if (trxValue < MIN || trxValue > MAX) {
            throw new IllegalArgumentException("");
        }
        this.trxValue = trxValue;
        if (trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        if (trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }

        currentSumValue = currentSumValue.add(new BigDecimal(trxValue));
        currentCount++;
    }

    public static void initTheDay() {
        currentMinValue = Long.MAX_VALUE;
        currentMaxValue = Long.MIN_VALUE;
        currentCount = 0;
        currentSumValue = new BigDecimal(0);
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static long getCurrentMinValue() {
        if (currentCount == 0) {
            return 0;
        }
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        if (currentCount == 0) {
            return 0;
        }
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return currentSumValue;
    }

    public static BigDecimal averageOfTransaction() {
        if (currentCount == 0) {
            return new BigDecimal(0);
        }
        return getSumOfTrxs().divide(new BigDecimal(currentCount));
    }

}
