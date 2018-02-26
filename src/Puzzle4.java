import java.util.function.Function;

public class Puzzle4 {
    public static void main(String[] args) {
        System.out.println(solve(args));
        System.out.println(solveA(args));
    }

    protected static long solve(String[] args) {
        return streamArgs(args, s -> s);
    }

    protected static long solveA(String[] args) {
        return streamArgs(args, s -> new String(s.codePoints().sorted().toArray(), 0, s.length()));
    }

    private static long streamArgs(String[] args, Function<String, String> mapper) {
        return java.util.Arrays.stream(args, 0, args.length).filter(str -> {
            String[] split = str.split(" ");
            return java.util.Arrays.stream(split, 0, split.length)
                    .map(mapper)
                    .distinct().count() == split.length;
        }).count();
    }
}
