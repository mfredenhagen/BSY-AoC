import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Puzzle17Test {

    private static final int INPUT = 314;
    private static final int TEST_INPUT = 3;
    private static final int SIZE_A = 2018;

    @Test
    void circularBuffer() {
        // init state
        assertTrue(Arrays.equals(new int[]{0}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(0).getContent()));
        // first step
        assertTrue(Arrays.equals(new int[]{0, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(1).getContent()));
        // second step
        assertTrue(Arrays.equals(new int[]{0, 2, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(2).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 2, 3, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(3).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 2, 4, 3, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(4).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 5, 2, 4, 3, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(5).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 5, 2, 4, 3, 6, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(6).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 5, 7, 2, 4, 3, 6, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(7).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 5, 7, 2, 4, 3, 8, 6, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(8).getContent()));
        assertTrue(Arrays.equals(new int[]{0, 9, 5, 7, 2, 4, 3, 8, 6, 1}, new Puzzle17.CircularBuffer(TEST_INPUT, SIZE_A).iterate(9).getContent()));
        // 2017
        Puzzle17.CircularBuffer buffer = new Puzzle17.CircularBuffer(3, SIZE_A);
        int[] content = buffer.iterate(2017).getContent();
        assertTrue(Arrays.equals(new int[]{1512, 1134, 151, 2017, 638, 1513, 851}, Arrays.copyOfRange(content, buffer.getCurrentPosition() - 3, buffer.getCurrentPosition() + 3 + 1)));
    }

    @Test
    void testCircularIndex() {
        assertEquals(1, calcIndex(1, 3, 0));
        assertEquals(1, calcIndex(2, 3, 1));
        assertEquals(2, calcIndex(3, 3, 1));
        assertEquals(2, calcIndex(4, 3, 2));
        assertEquals(1, calcIndex(5, 3, 2));
        assertEquals(5, calcIndex(6, 3, 1));
        assertEquals(2, calcIndex(7, 3, 5));
        assertEquals(6, calcIndex(8, 3, 2));
        assertEquals(1, calcIndex(9, 3, 6));
    }

    private int calcIndex(int len, int steps, int current) {
        return ((current + steps) % len) + 1;
    }

    @Test
    void testIndexAfter50Million() {
        int i = 0;
        int valuePos1 = 0;
        int index = 0;
        while (i < 50_000_000) {
            index = calcIndex(++i, INPUT, index);
            if (index == 1) valuePos1 = i;
        }
        System.out.println("valuePos1 = " + valuePos1);
    }

    @Test
    void solve() {
        assertEquals(638, Puzzle17.solve(3));
    }

    @Test
    void spike() {
        int result = Puzzle17.solve(INPUT);
        System.out.println("Puzzle17: " + result);
        assertEquals(355, result);
    }

    @Test
    void spikeA() {
        int result = Puzzle17.solveA(INPUT);
        System.out.println("Puzzle17 a: " + result);
        assertEquals(6_154_117, result);
    }
}
