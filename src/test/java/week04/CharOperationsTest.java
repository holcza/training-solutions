package week04;

import org.junit.jupiter.api.Test;
import week04d02.Search;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharOperationsTest {

    @Test
    public void getPositionOfCharTest() {
        Search charOperations = new Search();

        assertEquals(List.of(0, 3), charOperations.getPositionOfChar("alma", "a"));
    }
}
