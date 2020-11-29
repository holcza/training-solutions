package methoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub theBest = goodPubs.get(0);
        for (Pub p : goodPubs) {
            if (p.getOpenFrom().isEarlier(theBest.getOpenFrom())) {
                theBest = p;
            }
        }
        return theBest;
    }


}
