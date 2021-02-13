package week05d03;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    private List<User> users = new ArrayList<>();


    public List<User> getUsers() {
        return users;
    }

    public void validate(List<User> users) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == null || users.get(i).getName() == "" || users.get(i).getName().isBlank() || users.get(i).getAge() < 0 || users.get(i).getAge() > 120) {
                throw new IllegalArgumentException("not valid user on the index: " + i);
            }
        }
    }
}
