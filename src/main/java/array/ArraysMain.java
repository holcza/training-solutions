package array;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {
    public String numberOfDaysAsString(){
        int []numberOfDays = new int[12];
        for (int i = 0; i < numberOfDays.length; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11) {
                numberOfDays[i] = 31;
            } else {
                if (i == 1) {
                    numberOfDays[i] = 28;
                } else {
                    numberOfDays[i] = 30;
                }
            }

        }

        return Arrays.toString(numberOfDays);
    }

    public List<String > daysOfWeek(){
        String [] week = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        return Arrays.asList(week);
    }

    public void multiplicationTable(int size) {
        int[][] multiTable = new int[size][size];

        for (int i = 0; i < multiTable.length; i++) {
            for (int j = 0; j < multiTable[i].length; j++) {
                multiTable[i][j] = (i + 1) * (j + 1);
            }
        }
        System.out.println(Arrays.deepToString(multiTable));

    }

    public boolean sameTempValues (double[] day, double[] anotherDay){

        return Arrays.equals(day,anotherDay);
    }

    public boolean sameTempValuesDayLight (double[] day, double[] anotherDay){
        int minHour=min(day.length,anotherDay.length);

        return Arrays.equals(Arrays.copyOfRange(day,0,minHour-1),Arrays.copyOfRange(anotherDay,0,minHour-1));
    }

    public int min(int a, int b){
        return Math.min(a,b);
    }

    public boolean wonLottery (int[] givenNumbers, int[] finalNumbers){
        Arrays.sort(givenNumbers);
        Arrays.sort(finalNumbers);
       return Arrays.equals(givenNumbers,finalNumbers);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(arraysMain.daysOfWeek().toString());
        arraysMain.multiplicationTable(5);
        double[] day = new double[24];
        double[] anotherDay1 = new double[24];
        double[] anotherDay2 = new double[23];
        double[] anotherDay3 = new double[25];

        for (int i =0;i<day.length;i++){
            day[i]=i;
        }
        for (int i =0;i<anotherDay1.length;i++){
            anotherDay1[i]=i;
        }
        for (int i =0;i<anotherDay2.length;i++){
            anotherDay2[i]=i;
        }
        for (int i =0;i<anotherDay3.length;i++){
            anotherDay3[i]=i;
        }
        System.out.println(arraysMain.sameTempValues(day,anotherDay1));
        System.out.println(arraysMain.sameTempValues(day,anotherDay2));
        System.out.println(arraysMain.sameTempValues(day,anotherDay3));
        System.out.println(arraysMain.sameTempValuesDayLight(day,anotherDay1));
        System.out.println(arraysMain.sameTempValuesDayLight(day,anotherDay2));
        System.out.println(arraysMain.sameTempValuesDayLight(day,anotherDay3));

        int[] givenNumbers={1,2,3,4,5};
        int[] finalNumbers={1,3,2,5,4};
        System.out.println(arraysMain.wonLottery(givenNumbers,finalNumbers));

    }
}
