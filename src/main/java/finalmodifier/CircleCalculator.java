package finalmodifier;

public class CircleCalculator {


    public final static double PI= 3.14;

    public double calculatePerimeter (double r){

        return 2*PI*r;
    }

    public double calculateArea (double r){
        return PI*PI*r;
    }


}
