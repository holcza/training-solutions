package solutions.array;

public class ArrayHandler {

    boolean contains(int[] source, int itemToFind){
        boolean result=false;
        for (int i =0;i<source.length;i++){
            if (source[i]==itemToFind){
                result = true;
            }
        }
        return result;
    }

    int find(int[] source, int itemToFind){
        int result=-1;
        for (int i =0;i<source.length;i++){
            if (source[i]==itemToFind){
                result = i;
            }
        }
        return result;

    }

}
