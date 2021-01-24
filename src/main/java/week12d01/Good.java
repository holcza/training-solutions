package week12d01;

public class Good implements Comparable<Good> {

    private int weight;

    private int value;

    public Good(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }


    @Override
    public int compareTo(Good o) {
        return (int) (((double) value / weight) - ((double) o.getValue() / o.getWeight()));
    }
}
