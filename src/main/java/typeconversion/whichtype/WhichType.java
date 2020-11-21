package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {
        List<Type> whichType = new ArrayList<>();

        for (Type t : Type.values()) {
            if (t.getMax() >= Long.parseLong(s) && t.getMin() <= Long.parseLong(s)) {
                whichType.add(t);
            }
        }
        return whichType;
    }
}
