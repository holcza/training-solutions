package catalog;

import java.util.List;

public class Validators {
    public static boolean isBlank(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List<String> objects) {
        if (objects == null || objects.size() == 0) {
            return true;
        }
        return false;
    }
}
