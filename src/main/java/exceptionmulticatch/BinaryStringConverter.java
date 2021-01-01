package exceptionmulticatch;

import java.util.Scanner;

public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String s)  {
        if (s==null){
            throw new NullPointerException("binaryString null");
        }
        int length = s.length();
        boolean[] b =new boolean[length];
        for (int i = 0; i<s.length();i++){
            int c = s.charAt(i);
            if (c=='0'){
                b[i]=false;
            } else if (c=='1'){
                b[i]=true;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }

        }
        return b;
    }
    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans==null){
            throw new NullPointerException();
        }
        if (booleans==null||booleans.length==0){
            throw new IllegalArgumentException();
        }

        String s ="";

        for (boolean b: booleans ){
            if (b==false){
                s+="0";
            }
            if (b==true){
                s+="1";
            }
        }
        return s;
    }
}
