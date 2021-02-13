package week05d04junior;

import org.junit.jupiter.api.Test;
import week05d02.ChangeLetter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    public void changeVowelTest(){
        ChangeLetter changeLetter=new ChangeLetter();

        assertEquals("t*t*t*t*t*",changeLetter.changeVowels("tatetitotu"));
    }
}
