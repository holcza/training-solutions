package primitivetypes;

public class PrimitiveTypes {

    public final static int BIT = 32;

    public String toBinaryString(int n) {
        String binary = "";
        int count=0;
        while (n > 0||count<BIT) {
            if (n>0){

                binary += n % 2;
                n /= 2;
            } else {
                binary +="0";
            }
            count++;
        }

        String binaryReverse="";

        for(int i=0;i<binary.length();i++){
            if (i==0){

            }
            binaryReverse+=binary.substring(binary.length()-i-1,binary.length()-i);
        }
        return binaryReverse;
    }
}
