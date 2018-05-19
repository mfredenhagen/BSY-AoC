import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle12Test {


    private static final String DATA = "0 <-> 2\n" +
            "1 <-> 1\n" +
            "2 <-> 0, 3, 4\n" +
            "3 <-> 2, 4\n" +
            "4 <-> 2, 3, 6\n" +
            "5 <-> 6\n" +
            "6 <-> 4, 5\n";

    @Test
    void testSolve() throws Exception {
        assertEquals(6, Puzzle12.solve(new ByteArrayInputStream(DATA.getBytes())));
    }

    @Test
    void testSolveA() throws Exception {
        assertEquals(2, Puzzle12.solveA(new ByteArrayInputStream(DATA.getBytes())));
    }

    @Test
    void spike() throws Exception {
        int result = Puzzle12.solve(getClass().getResourceAsStream("Puzzle12.txt"));
        System.out.println("Puzzle12: " + result);
        assertEquals(239, result);
    }

    @Test
    void spikeA() throws Exception {
        int result = Puzzle12.solveA(getClass().getResourceAsStream("Puzzle12.txt"));
        System.out.println("Puzzle12 a: " + result);
        assertEquals(215, result);
    }
}
