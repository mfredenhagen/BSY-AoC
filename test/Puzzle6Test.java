import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle6Test {

    @Test
    void solve() {
        int[] result = Puzzle6.solve(new String[]{"0", "2", "7", "0"});
        assertEquals(5, result[Puzzle6.REDISTRIBUTION_CYCLES]);
        assertEquals(4, result[Puzzle6.INFINITE_LOOP_CYCLES]);
    }

    @Test
    void spike() {
        int[] result = Puzzle6.solve(new String[]{"4", "1", "15", "12", "0", "9", "9", "5", "5", "8", "7", "3", "14", "5", "12", "3"});
        System.out.printf("Puzzle6: %d\nPuzzle6 a: %d\n", result[Puzzle6.REDISTRIBUTION_CYCLES], result[Puzzle6.INFINITE_LOOP_CYCLES]);
        assertEquals(6681, result[Puzzle6.REDISTRIBUTION_CYCLES]);
        assertEquals(2392, result[Puzzle6.INFINITE_LOOP_CYCLES]);
    }
}