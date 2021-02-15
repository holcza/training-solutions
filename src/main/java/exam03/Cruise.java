package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cruise {

    private Boat boat;

    private LocalDate sailing;

    private double basicPrice;

    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers()<1){
            throw new IllegalArgumentException("No more place on the boat");
        }
        passengers.add(passenger);
        boat = new Boat(boat.getName(),boat.getMaxPassengers()-1);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplier()*basicPrice;
    }

    public Passenger findPassengerByName(String name) {
        if (name == null){
            return null;
        }
        for (Passenger p : passengers){
            if (name.equals(p.getName())){
                return p;
            }
        }
        return null;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> namesInOrder = new ArrayList<>();
        for (Passenger p:passengers){
            namesInOrder.add(p.getName());
        }
        namesInOrder.sort(Collator.getInstance());
        return namesInOrder;
    }

    public double sumAllBookingsCharged() {
        double sum = 0.0;
        for (Passenger p:passengers){
            sum += getPriceForPassenger(p);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Long> numberOfPassengerByClass = new HashMap<>();
        numberOfPassengerByClass = passengers.stream()
                .map(Passenger::getCruiseClass)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Map.Entry entry: numberOfPassengerByClass.entrySet()){
            result.put((CruiseClass)entry.getKey(),(Integer)entry.getValue());
        }
        return result;
    }
}
