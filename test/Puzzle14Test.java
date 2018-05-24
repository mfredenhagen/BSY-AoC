import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Puzzle14Test {

    private static final String TEST_DATA = "flqrgnkx";
    private static final String INPUT_DATA = "uugsqrei";

    @Test
    void solve() {
        assertEquals(8108, Puzzle14.solve(TEST_DATA));
    }

    @Test
    void spike() {
        long result = Puzzle14.solve(INPUT_DATA);
        System.out.println("Puzzle14: " + result);
        assertEquals(8194, result);
    }

    @Test
    void solveA() {
        int result = Puzzle14.solveA(TEST_DATA);
        assertEquals(1242, result);
    }

    @Test
    void spikeA() {
        int result = Puzzle14.solveA(INPUT_DATA);
        System.out.println("Puzzle14 a: " + result);
        assertEquals(1141, result);
    }

    @Test
    void adjacentIndexes() {
        assertTrue(Arrays.equals(new int[]{}, Puzzle14.adjacentIndexes(0, 128).toArray()));
        assertTrue(Arrays.equals(new int[]{126}, Puzzle14.adjacentIndexes(127, 128).toArray()));
        assertTrue(Arrays.equals(new int[]{2, 129}, Puzzle14.adjacentIndexes(130, 128).toArray()));
        assertTrue(Arrays.equals(new int[]{126 * 128}, Puzzle14.adjacentIndexes(128 * 127, 128).toArray()));
        assertTrue(Arrays.equals(new int[]{127 * 128 - 1, 128 * 128 - 2}, Puzzle14.adjacentIndexes(128 * 128 - 1, 128).toArray()));
    }
}