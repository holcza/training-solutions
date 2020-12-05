package week06d01;


public class SeparatedSum {
    public SumResult sum(String s) {
        String sModified = s.replace(',', '.');
        String[] parts = sModified.split(";");
        double positive = 0;
        double negative = 0;

        for (String p : parts) {
            double value = Double.parseDouble(p);
            if (value >= 0) {
                positive += value;
            } else {
                negative += value;
            }
        }

        return new SumResult(negative, positive);
    }

    public static void main(String[] args) {
        SumResult sumResult = new SeparatedSum().sum("3;2,5;-6;-6,5");
        System.out.println(sumResult);
    }
}
