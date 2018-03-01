import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle3Test {

    @ParameterizedTest
    @CsvSource(value = {"1: 0", "12: 3", "23: 2", "1024: 31"}, delimiter = ':')
    void solve(int square, int expected) {
        Puzzle3.solve(square, (Puzzle3.SpiralCoord c) -> assertEquals(expected, c.distance()));
    }

    @Test
    void spike() {
        Puzzle3.solve(312051, (Puzzle3.SpiralCoord c) -> {
            System.out.println(c.distance());
            assertEquals(430, c.distance());
        });
    }

    @Test
    void spike2() {
        Puzzle3.solveA(312051, (Puzzle3.SpiralCoord c) -> {
            System.out.println(c.next().Value);
            assertEquals(312453, c.next().Value);
        });
    }

    @Test
    void solveA() {
        Puzzle3.solveA(747, (Puzzle3.SpiralCoord c) -> assertEquals(806, c.next().Value));
    }
}