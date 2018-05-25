import java.util.stream.Stream;

public class Puzzle15 {

    static final int A_CRITERIA = 4;
    static final int B_CRITERIA = 8;
    static final int NO_CRITERIA = 1;
    static final int JUDGE_COUNT = 40_000_000;
    static final int JUDGE_A_COUNT = 5_000_000;
    private static final int A_FACTOR = 16807;
    private static final int B_FACTOR = 48271;
    private static final int MOD = 2147483647;

    public static void main(String[] args) {
        int aStart = Integer.parseInt(args[0]);
        int bStart = Integer.parseInt(args[1]);
        System.out.println("Puzzle 15 judge final count: " + solve(aStart, bStart, JUDGE_COUNT) + " and with additional criteria: " + solveA(aStart, bStart, JUDGE_A_COUNT));
    }

    protected static int solve(int aStart, int bStart, int limit) {
        return (int) generators(aStart, bStart, NO_CRITERIA, NO_CRITERIA).limit(limit).filter(PairOfLongs::compareWord).count();
    }

    static Stream<PairOfLongs> generators(long aStart, long bStart, int aCriteria, int bCriteria) {
        return Stream.iterate(new PairOfLongs(next(aStart, A_FACTOR, aCriteria), next(bStart, B_FACTOR, bCriteria))
                , t -> new PairOfLongs(next(t.getA(), A_FACTOR, aCriteria), next(t.getB(), B_FACTOR, bCriteria)));
    }

    private static long next(long base, long factor, int criteria) {
        long tmp = base;
        tmp = (tmp * factor) % MOD;
        if ((tmp % criteria) == 0) {
            return tmp;
        }
        return next(tmp, factor, criteria);
    }

    protected static int solveA(int aStart, int bStart, int limit) {
        return (int) generators(aStart, bStart, A_CRITERIA, B_CRITERIA).limit(limit).filter(PairOfLongs::compareWord).count();
    }

    static class PairOfLongs {
        private final long a;
        private final long b;

        PairOfLongs(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public long getA() {
            return a;
        }

        long getB() {
            return b;
        }

        boolean compareWord() {
            return (a & 0xFFFF) == (b & 0xFFFF);
        }
    }
}
