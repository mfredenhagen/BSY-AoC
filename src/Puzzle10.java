import java.util.Arrays;
import java.util.stream.IntStream;


public class Puzzle10 {

    private static final int[] suffix = {17, 31, 73, 47, 23};

    public static void main(String[] args) {
        System.out.printf("Simple hash: %d\nKnot hash: %s\n", solve(args, 256), solveA(args, 256));
    }

    protected static int solve(String[] args, int numValues) {
        int[] lengths = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        int[] hashVector = hashFunction(lengths, 1, numValues);
        return hashVector[0] * hashVector[1];
    }

    protected static String solveA(String[] args, int numValues) {
        int[] lengths = convertInputString(args.length == 0 ? null : args[0]);
        int[] hashVector = hashFunction(lengths, 64, numValues);
        return convertToHex(hashVector);
    }

    private static String convertToHex(int[] values) {
        StringBuilder result = new StringBuilder(32);
        for (int i = 0; i < 256; i += 16) {
            int dense = values[i]
                    ^ values[i + 1]
                    ^ values[i + 2]
                    ^ values[i + 3]
                    ^ values[i + 4]
                    ^ values[i + 5]
                    ^ values[i + 6]
                    ^ values[i + 7]
                    ^ values[i + 8]
                    ^ values[i + 9]
                    ^ values[i + 10]
                    ^ values[i + 11]
                    ^ values[i + 12]
                    ^ values[i + 13]
                    ^ values[i + 14]
                    ^ values[i + 15];
            result.append(String.format("%02x", dense));
        }
        return result.toString();
    }

    private static int[] convertInputString(String args) {
        int[] tmp = args == null ? new int[]{} : IntStream.range(0, args.length()).map(i -> ((int) args.charAt(i))).toArray();
        int[] lengths = new int[tmp.length + suffix.length];
        System.arraycopy(tmp, 0, lengths, 0, tmp.length);
        System.arraycopy(suffix, 0, lengths, tmp.length, suffix.length);
        return lengths;
    }

    private static int[] hashFunction(int[] lengths, int rounds, int numValues) {
        int[] values = IntStream.range(0, numValues).toArray();
        int current = 0;
        for (int skipSize = 0; skipSize < lengths.length * rounds; skipSize++) {
            int length = lengths[skipSize % lengths.length];
            reverse(values, current, length);
            current += (length + skipSize);
            current %= values.length;
        }
        return values;
    }

    private static void reverse(int[] values, int current, int length) {
        if (length < 2) return;
        int tmp = values[current];
        int index = (current + length - 1) % values.length;
        values[current] = values[index];
        values[index] = tmp;
        reverse(values, (current + 1) % values.length, length - 2);
    }

}
