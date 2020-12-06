package interfaces.simplethread.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animalList = new ArrayList<>();

    public Zoo(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public int getNumberOfAnimals() {
        return animalList.size();
    }

    public int getNumberOfLegs() {
        int sum = 0;
        for (Animal a : animalList) {
            sum += a.getNumberOfLegs();
        }
        return sum;
    }
}
