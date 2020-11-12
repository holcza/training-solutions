package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance=new Distance(4.67,false);
        int a= (int) distance.getDistance();
        System.out.println(distance.getDistance()+" "+distance.isAccurate());
        System.out.println(a);
    }
}
