import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Puzzle15Test {

    private static final int TEST_A_GEN = 65;
    private static final int TEST_B_GEN = 8921;
    private static final int A_GEN = 783;
    private static final int B_GEN = 325;

    @Test
    void firstFivePairs() {
        long[][] expected = new long[][]{
                {1092455, 430625591},
                {1181022009, 1233683848},
                {245556042, 1431495498},
                {1744312007, 137874439},
                {1352636452, 285222916}
        };
        assertTrue(Arrays.deepEquals(expected, Puzzle15.generators((long) TEST_A_GEN, (long) TEST_B_GEN, Puzzle15.NO_CRITERIA, Puzzle15.NO_CRITERIA)
                .limit(5).map(t -> new long[]{t.getA(), t.getB()}).toArray()));
    }

    @Test
    void solve5Pairs() {
        int result = Puzzle15.solve(TEST_A_GEN, TEST_B_GEN, 5);
        assertEquals(1, result);
    }

    @Test
    void solve() {
        int result = Puzzle15.solve(TEST_A_GEN, TEST_B_GEN, Puzzle15.JUDGE_COUNT);
        assertEquals(588, result);
    }

    @Test
    void spike() {
        int result = Puzzle15.solve(A_GEN, B_GEN, Puzzle15.JUDGE_COUNT);
        System.out.println("Puzzle15: " + result);
        assertEquals(650, result);
    }

    @Test
    void firstFivePairsWithCriteria() {
        long[][] expected = new long[][]{
                {1352636452, 1233683848},
                {1992081072, 862516352},
                {530830436, 1159784568},
                {1980017072, 1616057672},
                {740335192, 412269392}
        };
        assertTrue(Arrays.deepEquals(expected, Puzzle15.generators((long) TEST_A_GEN, (long) TEST_B_GEN, Puzzle15.A_CRITERIA, Puzzle15.B_CRITERIA)
                .limit(5).map(t -> new long[]{t.getA(), t.getB()}).toArray()));
    }

    @Test
    void solveA() {
        int result = Puzzle15.solveA(TEST_A_GEN, TEST_B_GEN, Puzzle15.JUDGE_A_COUNT);
        assertEquals(309, result);
    }

    @Test
    void spikeA() {
        int result = Puzzle15.solveA(A_GEN, B_GEN, Puzzle15.JUDGE_A_COUNT);
        System.out.println("Puzzle15 a: " + result);
        assertEquals(336, result);
    }
}
