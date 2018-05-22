import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle13Test {

    private static final String[] INPUT_DATA = {"0: 3", "1: 2", "2: 9", "4: 4", "6: 4", "8: 6", "10: 6", "12: 8", "14: 5",
            "16: 6", "18: 8", "20: 8", "22: 8", "24: 6", "26: 12", "28: 12", "30: 8",
            "32: 10", "34: 12", "36: 12", "38: 10", "40: 12", "42: 12", "44: 12", "46: 12",
            "48: 14", "50: 14", "52: 8", "54: 12", "56: 14", "58: 14", "60: 14", "64: 14",
            "66: 14", "68: 14", "70: 14", "72: 14", "74: 12", "76: 18", "78: 14", "80: 14",
            "86: 18", "88: 18", "94: 20", "98: 18"};

    private static final String[] TEST_DATA = {"0: 3", "1: 2", "4: 4", "6: 4"};

    @Test
    void solve() {
        assertEquals(24, Puzzle13.solve(TEST_DATA));
    }

    @Test
    void testLayerOfRange2MovesUpAndDown() {
        Puzzle13.Layer layer = new Puzzle13.Layer(2, 0);
        assertTrue(layer.isAtTop(0));
        assertFalse(layer.isAtTop(1));
        assertTrue(layer.isAtTop(2));
    }

    @Test
    void testLayerOfRange3MovesUpAndDown() {
        Puzzle13.Layer layer = new Puzzle13.Layer(3, 0);
        assertTrue(layer.isAtTop(0));
        for (int i = 0; i < 3; i++) {
            assertFalse(layer.isAtTop(i + 1));
        }
        // second up and down
        assertTrue(layer.isAtTop(4));
        for (int i = 0; i < 3; i++) {
            assertFalse(layer.isAtTop(i + 5));
        }
        assertTrue(layer.isAtTop(8));
    }

    @Test
    void testCalculateSeverity() {
        Puzzle13.Firewall firewall = Puzzle13.Firewall.buildFirewall(TEST_DATA);
        assertEquals(24, firewall.caught(0).sum());
    }

    @Test
    void spike() {
        int result = Puzzle13.solve(INPUT_DATA);
        System.out.println("Puzzle13: " + result);
        assertEquals(1704, result);
    }

    @Test
    void solveA() {
        assertEquals(10, Puzzle13.solveA(TEST_DATA));
    }

    @Test
    void spikeA() {
        int result = Puzzle13.solveA(INPUT_DATA);
        System.out.println("Puzzle13 a: " + result);
        assertEquals(3970918, result);
    }
}
