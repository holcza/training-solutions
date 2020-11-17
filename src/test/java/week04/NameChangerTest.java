package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
