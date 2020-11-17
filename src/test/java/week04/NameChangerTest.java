package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {

    @Test
    void changeFirstNameTest(){

        //Given
        NameChanger nameChanger = new NameChanger("Doe John");
        //When
        nameChanger.changeFistName("Jack");
        //Then
        assertEquals("Doe Jack",nameChanger.getFullName());
    }

    @Test
    void nameChangerTest(){

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> new NameChanger(""));

        assertEquals("Invalid Name: ",iae.getMessage());
    }



}
