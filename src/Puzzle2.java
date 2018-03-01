import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Puzzle2 {

    public static void main(String[] args) {
        System.out.println(solve(args));
        System.out.println(solveA(args));
    }

    protected static int solve(String[] args) {
        return calc(args, integerStream -> {
                    IntSummaryStatistics statistics = integerStream.collect(Collectors.summarizingInt(Integer::intValue));
                    return statistics.getMax() - statistics.getMin();
                }
        );
    }

    protected static int solveA(String[] args) {
        return calc(args, integerStream -> {
                    List<Integer> collect = integerStream.sorted().collect(Collectors.toList());
                    for (int i = 0; i < collect.size(); i++) {
                        for (int j = collect.size() - 1; j > i; j--) {
                            if (collect.get(j) % collect.get(i) == 0) {
                                return collect.get(j) / collect.get(i);
                            }
                        }
                    }
                    return 0;
                }
        );
    }

    private static int calc(String[] args, Function<Stream<Integer>, Integer> rule) {
        return stream(args, 0, args.length).mapToInt(s -> {
            String[] split = s.split(",");
            Stream<Integer> integerStream = stream(split).map(Integer::parseInt);
            return rule.apply(integerStream);
        }).sum();
    }

}
