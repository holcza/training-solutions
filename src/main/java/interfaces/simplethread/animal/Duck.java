package interfaces.simplethread.animal;

public class Duck implements Animal {

    private int numberOfLegs=2;
    private String name = "Duck";

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String getName() {
        return name;
    }
}
