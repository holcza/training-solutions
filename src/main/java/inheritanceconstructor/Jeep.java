package inheritanceconstructor;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;


    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        super.modifyFuelAmount(fuel);
    }

    public void drive(int km) {
        if (isEnoughFuel(km)) {
            if (extraFuel > km*super.getFuelRate()/100){
                extraFuel -= km*super.getFuelRate()/100;
            }
            else {
                modifyFuelAmount(-km*super.getFuelRate()/100+extraFuel);
                extraFuel = 0.0;
            }
        } else {
            throw new RuntimeException("Not enough fuel available!");
        }
    }

    private boolean isEnoughFuel(int km) {
        boolean isEnoughFuel = km * super.getFuelRate()/100 > super.getFuel() + extraFuel ? false : true;
        return isEnoughFuel;
    }


    public double calculateRefillAmount() {
        return super.getTankCapacity() + extraCapacity - super.getFuel() - extraFuel;
    }
}
