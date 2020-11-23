package immutable;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new IllegalArgumentException("no satelite was given");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {

        isEmpty(registerIdent);
        for (Satellite s : satellites) {
            if (s.getRegisterIdent().equals(registerIdent)) {
                return s;
            }
        }
        throw new IllegalArgumentException("no satellite wa find");
    }

    private boolean isEmpty(String stg) {
        if (stg == "" || stg.isBlank()) {
            throw new IllegalArgumentException("no registerID was given");
        }
        return false;
    }
}
