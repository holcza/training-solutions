package week06d01;


public class SeparatedSum {

    public static final String NUMBER_SEPARATOR = ";";
    public static final char SOURCE_SIGN = ',';
    public static final char TARGET_SIGN = '.';

    public SumResult sum(String s) {
        String sModified = s.replace(SOURCE_SIGN, TARGET_SIGN);
        String[] parts = sModified.split(NUMBER_SEPARATOR);
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
