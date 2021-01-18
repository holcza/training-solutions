package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairFinderTest {
    @Test
    public void findPairsTest(){
        PairFinder pairFinder = new PairFinder();

        assertEquals(pairFinder.findPairs(new int[]{5, 1, 4, 5}),1);
        assertEquals(pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}),3);
    }
}
