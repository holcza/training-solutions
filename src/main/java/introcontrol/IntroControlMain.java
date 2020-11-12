package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl=new IntroControl();
        System.out.println(introControl.substractTenIfGreaterThanTen(20));
        System.out.println(introControl.substractTenIfGreaterThanTen(9));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(1));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Helga"));

        System.out.println(introControl.calculateBonus(10000000));
        System.out.println(introControl.calculateBonus(10000));

        System.out.println(introControl.calculateConsumption(6,200));
        System.out.println(introControl.calculateConsumption(5,4));

        introControl.printNumbers(10);

        introControl.printNumbersBetween(5, 8);

        introControl.printNumbersBetweenAnyDirection(6,9);
        introControl.printNumbersBetweenAnyDirection(10,5);

        introControl.printOddNumbers(10);





    }
}
