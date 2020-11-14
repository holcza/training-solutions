package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume (double r, double h){

        CircleCalculator circleCalculator = new CircleCalculator();

        return circleCalculator.calculateArea(r)*h;
    }

    public double calculateSurfaceArea (double r, double h){

        CircleCalculator circleCalculator = new CircleCalculator();

        return circleCalculator.calculatePerimeter(r)*(h+r);
    }
}
