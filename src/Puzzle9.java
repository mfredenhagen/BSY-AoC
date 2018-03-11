import puzzle9.Scanner;

import java.util.Stack;
import java.util.stream.Stream;

public class Puzzle9 {

    public static void main(String[] args) {
        System.out.println(solve(args[0]));
    }

    protected static Result solve(String arg) {
        Stack<Group> groups = new Stack<>();
        Scanner scanner = new Scanner();
        int score = arg.chars().mapToObj(c -> scanner.scan((char) c)).flatMap(scanResult -> {
            switch (scanResult) {
                case OPEN_GROUP:
                    groups.push(new Group(groups.size() + 1));
                    break;
                case CLOSE_GROUP:
                    return Stream.of(groups.pop());
            }
            return Stream.empty();
        }).mapToInt(group -> group.Score).sum();
        return new Result(score, scanner.garbageCount());
    }

    private static class Group {
        final int Score;

        private Group(int score) {
            Score = score;
        }
    }

    protected static class Result {
        final int Score;
        final int GarbageCount;

        Result(int score, int garbageCount) {
            Score = score;
            GarbageCount = garbageCount;
        }
    }
}
