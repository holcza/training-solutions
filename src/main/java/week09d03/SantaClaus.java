package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {
    private List<Person> personList = new ArrayList<>();

    public SantaClaus(List<Person> personList) {
        this.personList = personList;
    }

    public void getThroughChimneys(){
        for (Person p: personList){
            p.setPresent();
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public static void main(String[] args) {

        SantaClaus santaClaus = new SantaClaus(List.of(
                new Person("Ági",2),
                new Person("Gábor",16),
                new Person("Laci",10)));

        santaClaus.getThroughChimneys();

        System.out.println(santaClaus.getPersonList());
    }
}
