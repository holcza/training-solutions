package week05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {
    @Test
    public void validateTest() throws IllegalArgumentException{
        UserValidator userValidator = new UserValidator();
        userValidator.getUsers().add(new User("Kis Gábor",2));
        userValidator.getUsers().add(new User("Kis Anna",1112));
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> userValidator.validate(userValidator.getUsers()));
        assertEquals("not valid user on the index: 1", ex.getMessage());

    }


}
