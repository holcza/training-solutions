package week14d03;

import java.util.List;

@FunctionalInterface
public interface UserFilter {
    List<User> filter(List<User> users);
}
