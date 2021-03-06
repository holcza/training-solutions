package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        double r = 2;
        double h = 3;
        final double z;
        System.out.println("A PI értéke: " + CircleCalculator.PI);
        System.out.println("A henger felülete: " + cylinderCalculator.calculateSurfaceArea(r, h));
        System.out.println("A henger térfogata: " + cylinderCalculator.calculateVolume(r, h));

        CircleCalculator circleCalculator = new CircleCalculator();
        System.out.println(circleCalculator.calculatePerimeter(10));

    }
}
