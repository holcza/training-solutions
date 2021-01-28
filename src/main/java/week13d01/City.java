package week13d01;


import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class City {
    private String number;
    private String name;


    public City(String number, String name) {
        this.number = number;
        this.name = name;

    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "City{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
