import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Puzzle19 {

    public static void main(String[] args) {
        System.out.println("Puzzle 18 recovered frequencies: " + solve(args[0]) + " and times program 1 send a value: " + solveA(args[0]));
    }

    public static String solve(String input) {
        Map<Coord, Character> route = parseRoute(input);
        return new Paket().follow(route);
    }

    private static Map<Coord, Character> parseRoute(String input) {
        class IndexedString {
            final int i;
            private final String line;

            private IndexedString(int i, String line) {
                this.i = i;
                this.line = line;
            }

            private Stream<Map.Entry<Coord, Character>> toStream() {
                return IntStream.range(0, line.length() - 1).mapToObj(j -> Map.entry(new Coord(i, j), line.charAt(j)));
            }
        }
        final String[] strings = input.split("\n");
        Map<Coord, Character> result = new HashMap<>();
        IntStream.range(0, strings.length).mapToObj(j -> new IndexedString(j, strings[j]))
                .flatMap(IndexedString::toStream)
                .filter(entry -> entry.getValue() >= '+').forEach(it -> result.put(it.getKey(), it.getValue()));
        return result;
    }

    public static int solveA(String input) {
        Map<Coord, Character> route = parseRoute(input);
        Paket paket = new Paket();
        paket.follow(route);
        return paket.getSteps();
    }

    private static class Coord {
        private final int x;

        private final int y;

        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coord coord = (Coord) o;

            if (x != coord.x) return false;
            return y == coord.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private static class Paket {

        private final StringBuffer result = new StringBuffer();
        private int steps;

        String getResult() {
            return result.toString();
        }

        int getSteps() {
            return steps;
        }

        String follow(final Map<Coord, Character> route) {
            Coord coord = route.keySet().stream().filter(key -> key.getX() == 0).findFirst().orElseThrow(() -> new RuntimeException("new start coord"));
            Character current = route.get(coord);
            Direction dir = Direction.DOWN;
            do {
                steps++;
                if (current == '+') {
                    dir = findNeighbor(coord, dir, route);
                }
                if (current >= 'A' && current <= 'Z') {
                    result.append(current);
                }
                coord = neighbor(coord, dir);
                current = route.get(coord);
            } while (current != null);
            return getResult();
        }

        private Direction findNeighbor(Coord start, Direction dir, Map<Coord, Character> route) {
            return Arrays.stream(Direction.values()).filter(it -> it != dir.opposite())
                    .filter(f -> route.get(neighbor(start, f)) != null).findFirst().orElseThrow(() -> new RuntimeException("no neighbor"));
        }

        Coord neighbor(Coord coord, Direction dir) {
            switch (dir) {
                case TOP:
                    return new Coord(coord.getX() - 1, coord.getY());
                case DOWN:
                    return new Coord(coord.getX() + 1, coord.getY());
                case LEFT:
                    return new Coord(coord.getX(), coord.getY() - 1);
                case RIGHT:
                    return new Coord(coord.getX(), coord.getY() + 1);
            }
            return null;
        }

        private enum Direction {
            DOWN, TOP, LEFT, RIGHT;

            Direction opposite() {
                switch (this) {
                    case DOWN:
                        return TOP;
                    case TOP:
                        return DOWN;
                    case LEFT:
                        return RIGHT;
                    case RIGHT:
                        return LEFT;
                    default:
                        throw new RuntimeException("Satisfy compiler");
                }
            }
        }

    }
}
