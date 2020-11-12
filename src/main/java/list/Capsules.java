package list;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> capsules = new ArrayList<>();

    public void addLast(String capsule) {
        capsules.add(capsule);
    }

    public void addFirst(String capsule) {
        capsules.add(0, capsule);
    }

    public void removeFirst() {

        List<String> capsulesModified = new ArrayList<>();
        for (int i = 0; i < capsules.size(); i++) {
            if (i != 0) {
                capsulesModified.add(capsules.get(i));
            }
        }
        capsules = capsulesModified;
    }

    public List<String> getColores() {
        return capsules;
    }

    public void removeLast() {

        List<String> capsulesModified = new ArrayList<>();
        for (int i = 0; i < capsules.size(); i++) {
            if (i != (capsules.size() - 1)) {
                capsulesModified.add(capsules.get(i));
            }
        }
        capsules = capsulesModified;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("red");
        capsules.addFirst("blue");
        capsules.addLast("green");
        System.out.println(capsules.getColores());

        capsules.removeFirst();
        System.out.println(capsules.getColores());

        capsules.removeLast();
        System.out.println(capsules.getColores());

        List<String> capsuleToClear = capsules.getColores();
        capsuleToClear.clear();
        capsuleToClear = capsules.getColores();
        System.out.println(capsuleToClear);
    }
}
