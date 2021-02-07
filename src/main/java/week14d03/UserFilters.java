package week14d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilters {
    public UserFilter createFilter(List<Predicate<User>> predicates) {
        return users ->
                users.stream()
                        .filter(predicates.stream().reduce(a -> true, Predicate::and))
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        final UserFilter filter = new UserFilters().createFilter(Arrays.asList(
                (user) -> user.getAge() > 18,
                (user) -> user.getName().startsWith("A")
        ));
        System.out.println(filter.filter(new ArrayList<>(Arrays.asList(
                new User("Marton", 16, "Racz Aladar utca 99/b"),
                new User("Attila", 19, "Kazmer utca 4")
        ))));
    }
}

