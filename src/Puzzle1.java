import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Puzzle1 {

    private static final int DECIMAL = 10;

    private static class Pair {
        final char _1;
        final char _2;
        Pair(char _1, char _2) {
            this._1 = _1;
            this._2 = _2;
        }
        boolean equalValues() {
            return _1 == _2;
        }
    }

    public static void main(String[] args) {
        if(!args[0].matches("\\d+")) {
            throw new IllegalArgumentException("Only digits are allowed -> " + args[0]);
        }
        System.out.println(solve(args, 1));
    }

    protected static int solve(String[] args, int distance) {
        final String series = args[0] + args[0].substring(0, distance); // overflow
        Stream<Pair> pairStream = IntStream.range(distance, series.length())
                .mapToObj(i -> new Pair(series.charAt(i - distance), series.charAt(i)));
        return pairStream.filter(Pair::equalValues).mapToInt(p -> Character.digit(p._1, DECIMAL)).sum();
    }
}
