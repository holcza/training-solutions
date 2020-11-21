package typeconversion.whichtype;

public class WhichTypeMain {
    public static void main(String[] args) {
        WhichType whichType = new WhichType();
        System.out.println(whichType.whichType("2000000"));
        System.out.println(whichType.whichType("300"));
        System.out.println(whichType.whichType("20000000000"));
        System.out.println(whichType.whichType("2"));
    }
}
