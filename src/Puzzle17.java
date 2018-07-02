import java.util.Arrays;

public class Puzzle17 {


    public static void main(String[] args) {
        System.out.println("Puzzle 17 spinlock value after 2017: " + solve(Integer.parseInt(args[0])) + " and after 50_000_000 cycles @ pos 1: " + solveA(Integer.parseInt(args[0])));
    }

    static int solveA(int steps) {
        return new CircularBuffer(steps).iterate(50_000_000, 1);
    }

    static int solve(int steps) {
        CircularBuffer buffer = new CircularBuffer(steps, 2018).iterate(2017);
        return buffer.getContent()[buffer.getCurrentPosition() + 1];
    }

    static class CircularBuffer {
        private final int steps;
        private final int[] content;
        private int current = 0;
        private int length = 1;

        CircularBuffer(int steps) {
            this(steps, 0);
        }

        CircularBuffer(int steps, int size) {
            this.steps = steps;
            this.content = new int[size];
        }

        CircularBuffer iterate(int times) {
            for (int value = 1; value <= times; value++) {
                current = calcIndex(value);
                insert(value);
            }
            length = times + 1;
            return this;
        }

        int iterate(int times, int pos) {
            int result = 0;
            for (int value = 1; value <= times; value++) {
                current = calcIndex(value);
                if (current == pos) {
                    result = value;
                }
            }
            return result;
        }

        private void insert(int value) {
            // shift values after value one place
            System.arraycopy(content, current, content, current + 1, value - current);
            // set the value
            content[current] = value;
        }

        private int calcIndex(int value) {
            return ((current + steps) % value) + 1;
        }

        int[] getContent() {
            return Arrays.copyOf(content, length);
        }

        int getCurrentPosition() {
            return current;
        }
    }

}
