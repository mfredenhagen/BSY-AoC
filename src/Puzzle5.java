import java.util.Arrays;
import java.util.function.Function;

public class Puzzle5 {
    public static void main(String[] args) {
        System.out.println("" + solve(args));
        System.out.println("" + solveA(args));
    }

    protected static int solve(String[] args) {
        return calc(args, i -> ++i);
    }

    protected static int solveA(String[] args) {
        return calc(args, i -> i + (i >= 3 ? -1 : 1));
    }

    private static int calc(String[] args, Function<Integer, Integer> rule) {
        int[] jumps = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        int current = 0, hops = 0;
        while (current < jumps.length) {
            int dist = jumps[current];
            jumps[current] = rule.apply(dist);
            current += dist;
            hops++;
        }
        return hops;
    }
}
