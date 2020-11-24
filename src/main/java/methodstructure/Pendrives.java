package methodstructure;

import java.util.ArrayList;
import java.util.List;

public class Pendrives {

    List<Pendrive> pendrives= new ArrayList<>();

    public Pendrive best (List<Pendrive> pendrives){
        Pendrive pendrive = pendrives.get(0);
        for (Pendrive p: pendrives){
            if (p.comparePricePerCapacity(pendrive)==-1){
                pendrive=p;
            }
        }
        return pendrive;
    }

    public Pendrive cheapest (List<Pendrive> pendrives){
        Pendrive pendrive = pendrives.get(0);
        for (Pendrive p: pendrives){
            if (p.cheaperThan(pendrive)){
                pendrive=p;
            }
        }
        return pendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity){

        for (Pendrive p:pendrives){
            if (p.getCapacity()==capacity){
                p.risePrice(percent);

            }
        }
    }


}
