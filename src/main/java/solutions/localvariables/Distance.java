package solutions.localvariables;

public class Distance {
    private double distance;
    private boolean accurate;

    public Distance(double distance, boolean accurate) {
        this.distance = distance;
        this.accurate = accurate;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isAccurate() {
        return accurate;
    }
}
