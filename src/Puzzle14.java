import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Puzzle14 {

    public static void main(String[] args) {
        System.out.println("Puzzle 14 used squares: " + solve(args[0]) + " in " + solveA(args[0]) + " groups.");
    }

    protected static long solve(String key) {
        return getBinaryGrid(key).filter(i -> i == '1').count();
    }

    protected static int solveA(String key) {
        int[] grid = getBinaryGrid(key).toArray();
        List<Integer> remaining = IntStream.range(0, grid.length).filter(i -> grid[i] == '1').boxed().collect(Collectors.toList());
        Deque<Integer> group = new LinkedList<>();
        int groups = 0;
        while (!remaining.isEmpty()) {
            group.add(remaining.remove(0));
            groups++;
            while (!group.isEmpty()) {
                List<Integer> adjacent = adjacentIndexes(group.pop()).filter(i -> grid[i] == '1').boxed().collect(Collectors.toList());
                Set<Integer> intersect = new HashSet<>(remaining);
                // intersection with remaining indexes
                intersect.retainAll(adjacent);
                remaining.removeAll(intersect);
                // have to be investigated further
                group.addAll(intersect);
            }
        }
        return groups;
    }

    private static IntStream adjacentIndexes(int pos) {
        return adjacentIndexes(pos, 128);
    }

    static IntStream adjacentIndexes(int pos, int size) {
        int x = pos % size;
        int y = pos / size;
        IntStream.Builder builder = IntStream.builder();
        // above
        if ((y - 1) >= 0) {
            builder.accept((y - 1) * size + x);
        }
        // left
        if ((x - 1) >= 0) {
            builder.accept(x - 1 + y * size);
        }
        // right
        if ((x + 1) < size) {
            builder.accept(x + 1 + y * size);
        }
        // below
        if ((y + 1) < size) {
            builder.accept((y + 1) * size + x);
        }
        return builder.build();
    }

    private static IntStream getBinaryGrid(String key) {
        return IntStream.range(0, 128).mapToObj(i -> Puzzle10.solveA(new String[]{key + "-" + i}, 256))
                .map(Puzzle14::toBinary)
                .flatMapToInt(String::chars);
    }

    private static String toBinary(String hex) {
        return IntStream.range(0, hex.length()).mapToObj(hex::charAt)
                .map(c -> StringUtils.leftPad(Integer.toBinaryString(
                        Integer.parseInt("" + c, 16)), 4, '0'))
                .collect(Collectors.joining());
    }
}
