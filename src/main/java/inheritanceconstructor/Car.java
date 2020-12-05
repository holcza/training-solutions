package inheritanceconstructor;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (tankCapacity<fuel){
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km){
        if (isEnoughFuel(km)){
            modifyFuelAmount(km*fuelRate/-100);
        } else {
            throw new RuntimeException("Not enough fuel available!");
        }
    }

    private boolean isEnoughFuel(int km){
        boolean isEnoughFuel = km*fuelRate/100>fuel ? false : true;
        return isEnoughFuel;
    }

    public double calculateRefillAmount(){
        return tankCapacity - fuel;
    }
}
