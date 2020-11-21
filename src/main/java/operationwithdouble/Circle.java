package operationwithdouble;

public class Circle {
    private final static double PI = 3.14;

    private int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return PI * diameter;
    }

    public double area() {
        return PI * diameter * diameter / 4;
    }
}
