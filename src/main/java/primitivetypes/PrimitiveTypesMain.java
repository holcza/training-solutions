package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {

        PrimitiveTypes primitiveTypes = new PrimitiveTypes();

        int number = -11;

        System.out.println(primitiveTypes.toBinaryString(number));
        System.out.println(Integer.toBinaryString(number));
        System.out.println(primitiveTypes.toBinaryString(number).equals(Integer.toBinaryString(number)));
    }
}
