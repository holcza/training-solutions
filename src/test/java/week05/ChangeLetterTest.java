package week05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    public void changeVowelTest(){
        ChangeLetter changeLetter=new ChangeLetter();

        assertEquals("t*t*t*t*t*",changeLetter.changeVowels("tatetitotu"));
    }
}
