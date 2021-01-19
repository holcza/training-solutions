package week11d04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameLength {
    public List<Integer> getLengths(List<String> names){
        Set<Integer> nameLengths = new HashSet<>();
        for (String n:names){
            if (n.startsWith("J")){
                nameLengths.add(n.length());
            }
        }
        return new ArrayList<>(nameLengths);
    }

    public static void main(String[] args) {
        NameLength nameLength = new NameLength();
        List<String> names = List.of("Joe", "Jack", "Jane", "Jake", "George", "William");
        System.out.println(nameLength.getLengths(names));
    }
}
