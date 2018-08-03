import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Puzzle18Test {
    private String[] TEST_INPUT = {
            "set a 1",
            "add a 2",
            "mul a a",
            "mod a 5",
            "snd a",
            "set a 0",
            "rcv a",
            "jgz a -1",
            "set a 1",
            "jgz a -2"
    };

    private String[] TEST_INPUT_A = {
            "snd 1",
            "snd 2",
            "snd p",
            "rcv a",
            "rcv b",
            "rcv c",
            "rcv d"
    };

    private String[] INPUT = {
            "set i 31",
            "set a 1",
            "mul p 17",
            "jgz p p",
            "mul a 2",
            "add i -1",
            "jgz i -2",
            "add a -1",
            "set i 127",
            "set p 952",
            "mul p 8505",
            "mod p a",
            "mul p 129749",
            "add p 12345",
            "mod p a",
            "set b p",
            "mod b 10000",
            "snd b",
            "add i -1",
            "jgz i -9",
            "jgz a 3",
            "rcv b",
            "jgz b -1",
            "set f 0",
            "set i 126",
            "rcv a",
            "rcv b",
            "set p a",
            "mul p -1",
            "add p b",
            "jgz p 4",
            "snd a",
            "set a b",
            "jgz 1 3",
            "snd b",
            "set f 1",
            "add i -1",
            "jgz i -11",
            "snd a",
            "jgz f -16",
            "jgz a -19"
    };

    @Test
    void solve() {
        assertEquals(4, Puzzle18.solve(TEST_INPUT));
    }

    @Test
    void spike() {
        long result = Puzzle18.solve(INPUT);
        System.out.println("Puzzle18: " + result);
    }

    @Test
    void solveA() {
        assertEquals(3, Puzzle18.solveA(TEST_INPUT_A));
    }

    @Test
    void spikeA() {
        int result = Puzzle18.solveA(INPUT);
        System.out.println("Puzzle18 a: " + result);
    }
}
