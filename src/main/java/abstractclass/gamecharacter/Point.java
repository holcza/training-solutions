package abstractclass.gamecharacter;

public class Point {

    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point anotherPoint) {
        long xDistance = x - anotherPoint.getX();
        long yDistance = y - anotherPoint.getY();
        return (long) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }


}
