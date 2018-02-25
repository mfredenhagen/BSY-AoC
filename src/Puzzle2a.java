import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Puzzle2a {

    public static void main(String[] args) {
        System.out.println(solve(args));
    }

    protected static int solve(String[] args) {
        return java.util.Arrays.stream(args, 0, args.length).mapToInt(s -> {
            String[] split = s.split(",");
            Stream<Integer> integerStream = Arrays.stream(split).map(Integer::parseInt);
            List<Integer> collect = integerStream.sorted().collect(Collectors.toList());
            for(int i = 0; i < collect.size(); i++) {
                for(int j = collect.size() - 1; j > i; j--) {
                    if (collect.get(j) % collect.get(i) == 0) {
                        return collect.get(j) / collect.get(i);
                    }
                }
            }
            return 0;
        }).sum();
    }
}
