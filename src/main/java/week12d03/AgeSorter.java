package week12d03;

import java.util.Arrays;

public class AgeSorter {

    public int[] sortAges(int[] ages){
        int[] countAges = new int[130];
        for (int a:ages){
            countAges[a]++;
        }

        int[] orderedAges = new int[ages.length];
        int index =0;
        for (int i =0;i<countAges.length;i++){
            if (countAges[i]>0){
                for (int j = 0;j<countAges[i];j++) {
                    orderedAges[index] = i;
                    index++;
                }
            }
        }

        return orderedAges;
    }

    public static void main(String[] args) {
        AgeSorter as = new AgeSorter();
        System.out.println(Arrays.toString(as.sortAges(new int[]{4,6,2,1,4})));
    }
}
