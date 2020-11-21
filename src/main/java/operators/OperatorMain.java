package operators;

public class OperatorMain {

    public int multiplyByPowerOfTwo(int number,int numberOfTwoMultilying){

        return number<<numberOfTwoMultilying;

    }
    public static void main(String[] args) {
        Operators operators =new Operators();
        System.out.println(operators.isEven(12));
        System.out.println(operators.isEven(11));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);

        System.out.println(0333);

        System.out.println(16>>2);
        System.out.println(13>>1);
        System.out.println(16<<1);
        System.out.println(13<<1);

        OperatorMain operatorMain =new OperatorMain();
        System.out.println(operatorMain.multiplyByPowerOfTwo(3,4));
    }


}
