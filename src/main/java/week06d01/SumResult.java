package week06d01;

public class SumResult {

    private final double negativeSum;
    private final double positiveSum;

    public SumResult(double negativeSum, double positiveSum) {
        this.negativeSum = negativeSum;
        this.positiveSum = positiveSum;
    }

    public double getNegativeSum() {
        return negativeSum;
    }

    public double getPositiveSum() {
        return positiveSum;
    }

    @Override
    public String toString() {
        return "SumResult{" +
                "negativeSum=" + negativeSum +
                ", positiveSum=" + positiveSum +
                '}';
    }
}
