package week11d01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PairFinder {
    public int findPairs(int[] arr){
        int result = 0;
        Arrays.sort(arr);
        int prev = arr[0];
        boolean single = true;
        for (int i = 1;i<arr.length;i++){
            if (prev == arr[i] && single==true){
                result++;
                single = false;
            } else {
                prev = arr[i];
                single = true;
            }
        }
        return result;
    }


}
