package methodparam;

public class Measurement {

    private double[] measurements;

    public Measurement(double[] measurements) {
        this.measurements = measurements;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        int index = -1;
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] < upper && measurements[i] > lower) {
                index = i;
                break;
            }
        }
        return index;
    }

    public double minimum() {
        double min = Integer.MAX_VALUE;
        for (double m : measurements) {
            if (m < min) {
                min = m;
            }
        }
        return min;
    }

    public double maximum() {
        double max = Integer.MIN_VALUE;
        for (double m : measurements) {
            if (m > max) {
                max = m;
            }
        }
        return max;
    }

    public ExtremValues minmax(){
        ExtremValues extremValues = new ExtremValues(minimum(),maximum());
        return extremValues;
    }
}
