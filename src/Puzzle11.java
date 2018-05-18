import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Puzzle11 {
    public static void main(String[] args) {
        System.out.printf("End distance: %d\nmax distance: %s\n", solve(args[0]), solveA(args[0]));
    }

    protected static int solve(String args) {
        Puzzle11.Hex origin = new Puzzle11.Hex(0, 0, 0);
        return convertInput(args, origin).getFirst().distance(origin);
    }

    private static Deque<Hex> convertInput(String args, Hex seed) {
        Deque<Hex> stack = new ArrayDeque<>();
        stack.addFirst(seed);
        Arrays.stream(args.split(",")).forEachOrdered(dir -> {
            Hex next = stack.peekFirst().move(Direction.valueOf(dir.toUpperCase()));
            stack.addFirst(next);
        });
        return stack;
    }

    protected static int solveA(String args) {
        Puzzle11.Hex origin = new Puzzle11.Hex(0, 0, 0);
        return convertInput(args, origin).stream().mapToInt(origin::distance).max().orElse(-1000);
    }

    // see https://www.redblobgames.com/grids/hexagons/
    enum Direction {
        N, S, // X axes
        NE, SW, // Y axes
        NW, SE  // Z axes
    }

    static class Hex {
        final int X;
        final int Y;
        final int Z;

        Hex(int x, int y, int z) {
            X = x;
            Y = y;
            Z = z;
        }

        Hex move(Direction dir) {
            switch (dir) {
                case N:
                    return new Hex(this.X, this.Y + 1, this.Z - 1); // X axes const
                case S:
                    return new Hex(this.X, this.Y - 1, this.Z + 1);
                case NE:
                    return new Hex(this.X + 1, this.Y, this.Z - 1); // Y axes const
                case SW:
                    return new Hex(this.X - 1, this.Y, this.Z + 1);
                case NW:
                    return new Hex(this.X - 1, this.Y + 1, this.Z);  // Z axes const
                case SE:
                    return new Hex(this.X + 1, this.Y - 1, this.Z);
                default:
                    throw new RuntimeException("Unknown direction");
            }
        }

        int distance(Hex other) {
            return (Math.abs(this.X - other.X) + Math.abs(this.Y - other.Y) + Math.abs(this.Z - other.Z)) / 2;
        }

        @Override
        public String toString() {
            return "Hex{" +
                    "X=" + X +
                    ", Y=" + Y +
                    ", Z=" + Z +
                    '}';
        }
    }
}
