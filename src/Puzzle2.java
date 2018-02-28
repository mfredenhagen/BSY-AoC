import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Puzzle2 {

    public static void main(String[] args) {
        System.out.println(solve(args));
    }

    protected static int solve(String[] args) {
        return stream(args, 0, args.length).mapToInt(s -> {
            String[] split = s.split(",");
            Stream<Integer> integerStream = stream(split).map(Integer::parseInt);
            IntSummaryStatistics statistics = integerStream.collect(Collectors.summarizingInt(Integer::intValue));
            return statistics.getMax() - statistics.getMin();
        }).sum();
    }
}
