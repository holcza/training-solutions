package introinheritance;

public class Boss extends Employee {

    private final static double LEADERSHIP_FACTOR = 0.1;
    private int numberOfEmployees;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getSalary() {
        return super.getSalary() * (numberOfEmployees * LEADERSHIP_FACTOR + 1);
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
