import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle10Test {

    private static final String[] INPUT = {"70", "66", "255", "2", "48", "0", "54", "48", "80"
            , "141", "244", "254", "160", "108", "1", "41"};

    @Test
    void solve() {
        int result = Puzzle10.solve(new String[]{"3", "4", "1", "5"}, 5);
        assertEquals(12, result);
    }

    @Test
    void spike() {
        int result = Puzzle10.solve(INPUT, 256);
        System.out.println("Puzzle10: " + result);
        assertEquals(7888, result);
    }

    @ParameterizedTest
    @CsvSource(value = {":a2582a3a0e66e6e86e3812dcb672a272", "AoC 2017:33efeb34ea91902bb2f59c9920caa6cd",
            "1,2,3:3efbe78a8d82f29979031a4aa0b16a9d", "1,2,4:63960835bcdc130f0b66d7ff4f6a5a8e"}, delimiter = ':')
    void solveA(String input, String expectedHash) {
        String denseHash = Puzzle10.solveA(new String[]{input}, 256);
        assertEquals(expectedHash, denseHash);
    }

    @Test
    void spikeA() {
        String joinedInput = Arrays.stream(INPUT).collect(Collectors.joining(","));
        String result = Puzzle10.solveA(new String[]{joinedInput}, 256);
        System.out.println("Puzzle10 a: " + result);
        assertEquals("decdf7d377879877173b7f2fb131cf1b", result);
    }
}