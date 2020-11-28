package methodchain;

public class NavigationPoint {
    private int distance;
    private int azimut;

    public NavigationPoint(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }

    @Override
    public String toString() {
        return "NavigationPoint{" +
                "distance=" + distance +
                ", azimut=" + azimut +
                '}';
    }

    public static void main(String[] args) {
        Robot robot = new Robot(0,0);
        robot.go(3).rotate(4).registerNavigationPoint().go(4).registerNavigationPoint().rotate(-13).registerNavigationPoint();
        System.out.println(robot.navigationPointList.toString());
    }
}
