package week05.week05d05;

import org.junit.jupiter.api.Test;
import week05.week05d04.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayListTest {
    @Test
    public void findByLengthGreaterThan() throws IllegalArgumentException{
        PlayList playList =new PlayList();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Song("aaa",-1,"bbb"));
        assertEquals("Not valid length in Seconds", ex.getMessage());

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Song("",23,"bbb"));
        assertEquals("Not valid name", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Song("aaa",23,""));
        assertEquals("Not valid artist", ex2.getMessage());

        playList.addSong(new Song("abab",200,"baba"));
        playList.addSong(new Song("abab",20,"baba"));
        playList.addSong(new Song("abab",224,"baba"));

        assertEquals(2,playList.findByLengthGreaterThan(0).size());

    }
}
