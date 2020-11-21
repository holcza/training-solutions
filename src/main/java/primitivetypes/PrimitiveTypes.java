package primitivetypes;

public class PrimitiveTypes {

    public final static int BIT = 32;

    public String toBinaryString(int n) {
        String binary = "";
        boolean sign=n>0? true:false;
        int count=0;
        while (Math.abs(n) > 0||count<BIT) {
            if (Math.abs(n)>0){
                if (sign){

                    binary += Math.abs(n % 2);
                } else {
                    binary += Math.abs(n % 2)==0? 1:0;
                }
                n /= 2;
            } else {
                if (sign){

                    binary +="0";
                } else {
                    binary +="1";
                }
            }
            count++;
        }

        String binaryReverse="";

        for(int i=0;i<binary.length();i++){
            if (i==0){

            }
            binaryReverse+=binary.substring(binary.length()-i-1,binary.length()-i);
        }


        if (sign){
            binary=binaryReverse;
        }else{
            String lastNumber=binaryReverse.substring(binaryReverse.length()-1);
            String reverseLastNumber = "0".equals(lastNumber) ? "1" :"0";
            binary = binaryReverse.substring(0, binaryReverse.length() - 1) + reverseLastNumber;
        }

        return binary;
    }
}
