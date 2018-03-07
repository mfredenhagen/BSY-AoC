import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Puzzle6 {
    public static final int REDISTRIBUTION_CYCLES = 0;
    public static final int INFINITE_LOOP_CYCLES = 1;

    public static void main(String[] args) {
        int[] result = solve(args);
        System.out.printf("%d redistribution cycles and %d cycles in infinite loop\n", result[REDISTRIBUTION_CYCLES], result[INFINITE_LOOP_CYCLES]);
    }

    public static int[] solve(String[] args) {
        ArrayList<Bank> banks = IntStream.range(0, args.length).mapToObj(i -> new Bank(i, Integer.parseInt(args[i])))
                .collect(toCollection(ArrayList::new));
        IntStream.range(0, banks.size()).skip(1).forEach(i -> banks.get(i - 1).setSuccessor(banks.get(i)));
        banks.get(banks.size() - 1).setSuccessor(banks.get(0));
        List<String> combinations = new ArrayList<>();
        combinations.add(calcCombination(banks));
        while (true) {  // TODO rewrite with infinite stream and stream.findAny / matchAny for combinations
            Bank max = banks.stream().max(Comparator.comparingInt(Bank::getBlocks).thenComparing(Comparator.comparingInt(Bank::getNr).reversed())).orElseThrow(IllegalStateException::new);
            Stream.iterate(max.getSuccessor(), Bank::getSuccessor).limit(max.clear()).forEach(Bank::store);
            String combination = calcCombination(banks);
            if (combinations.contains(combination)) {
                break;
            }
            combinations.add(combination);
        }
        return new int[]{combinations.size(), (combinations.size() - combinations.indexOf(calcCombination(banks)))};
    }

    private static String calcCombination(List<Bank> banks) {
        return banks.stream().map(b -> Integer.toString(b.getBlocks())).collect(Collectors.joining(""));
    }

    private static class Bank {
        private final int nr;
        private int blocks;
        private Bank successor;

        private Bank(int nr, int blocks) {
            this.nr = nr;
            this.blocks = blocks;
        }

        int getNr() {
            return nr;
        }

        int getBlocks() {
            return blocks;
        }

        Bank getSuccessor() {
            return successor;
        }

        void setSuccessor(Bank bank) {
            successor = bank;
        }

        int clear() {
            int result = blocks;
            this.blocks = 0;
            return result;
        }

        void store() {
            this.blocks += 1;
        }

        @Override
        public String toString() {
            return "Bank{" +
                    "nr=" + nr +
                    ", blocks=" + blocks +
                    '}';
        }
    }
}
