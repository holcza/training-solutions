package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper){
        isNull(trooper);
        troopers.add(trooper);
    }

    public void moveTrooperByName (String name, Position target){
        isEmpty(name);
        isNull(target);
        findTrooperByName(name).changePosition(target);
    }

    public void moveClosestTrooper(Position target){
        isNull(target);
        moveTrooper(findClosestTrooper(target),target);
    }

    private Trooper findTrooperByName (String name){
        isEmpty(name);
        isEmpty();
        for (Trooper t:troopers){
            if (t.getName().equals(name)){
                return t;
            }
        }
        throw new IllegalArgumentException("");
    }

    private Trooper findClosestTrooper (Position target){
        isNull(target);
        isEmpty();
        double minDistanceFrom= Double.MAX_VALUE;
        int index = 0;
        for (int i =0;i<troopers.size();i++){
            if (troopers.get(i).distanceFrom(target)<minDistanceFrom){
                minDistanceFrom = troopers.get(i).distanceFrom(target);
                index=i;
            }
        }
        return troopers.get(index);

    }

    private void moveTrooper (Trooper trooper, Position target){
        isNull(trooper);
        isNull(target);

        trooper.changePosition(target);
    }

    private void isEmpty(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("");
        }
    }

    private void isEmpty() {
        if (troopers.size()==0) {
            throw new IllegalArgumentException("");
        }
    }

    private void isNull(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("");
        }
    }

    private void isNull(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("");
        }
    }
}
