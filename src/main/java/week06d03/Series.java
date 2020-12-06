package week06d03;

import java.util.ArrayList;
import java.util.List;

public class Series {

    enum Type {INCREASING,DECREASING,MIXED}

    public Type calculateSeriesType (List<Integer> numbers){
        checkException(numbers);
        Type type = numbers.get(0)<numbers.get(1) ? Type.INCREASING : Type.DECREASING;
        for (int i = 2;i<numbers.size();i++){
            if ((type==Type.DECREASING && numbers.get(i)>numbers.get(i-1))
                    ||(type==Type.INCREASING && numbers.get(i)<numbers.get(i-1))) {
                type = Type.MIXED;
            }
        }
        return type;
    }

    private void checkException(List<Integer> numbers) {
        if (numbers ==null || numbers.size()<2){
            throw new IllegalArgumentException("Not enough numbers in the list");
        }
    }

    public static void main(String[] args) {
        Series series = new Series();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        List<Integer> numbers3 = new ArrayList<>();
        List<Integer> numbers4 = new ArrayList<>();

        numbers.add(0);
        numbers.add(2);
        numbers.add(4);
        numbers.add(6);

        numbers2.add(1);
        numbers2.add(5);
        numbers2.add(-6);

        numbers3.add(6);
        numbers3.add(4);
        numbers3.add(3);

        numbers4.add(1);

        Type type = series.calculateSeriesType(numbers);
        Type type2 = series.calculateSeriesType(numbers2);
        Type type3 = series.calculateSeriesType(numbers3);

        System.out.println(type);
        System.out.println(type2);
        System.out.println(type3);
        Type type4 = series.calculateSeriesType(numbers4);
    }
}
