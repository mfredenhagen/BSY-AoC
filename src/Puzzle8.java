import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Puzzle8 {
    public static void main(String[] args) {
        Result result = solve(args);
        System.out.printf("Largest register value after calculation: %d\nHighest value during calculation: %d\n", result.LargestValue, result.HighestValueDuringComputation);
    }

    protected static Result solve(String[] args) {
        String input = Arrays.stream(args, 0, args.length).collect(Collectors.joining("\n"));
        Puzzle8Lexer lexer = new Puzzle8Lexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Puzzle8Parser parser = new Puzzle8Parser(tokens);
        Memory mem = new Memory();
        Maximum max = new Maximum();
        parser.prog().instr().stream().map(instr -> buildInstr(instr, parser)).forEach(instr -> calc(instr, mem, max));
        return new Result(mem.register.values().stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax(),
                max.value);
    }

    private static void calc(Instruction instr, Memory mem, Maximum max) {
        if (instr.condition.apply(mem)) {
            mem.write(instr.register, max.check(instr.operation.apply(mem.read(instr.register), instr.value)));
        }
    }

    private static Instruction buildInstr(Puzzle8Parser.InstrContext instr, Puzzle8Parser parser) {
        String register = instr.register().ID().getSymbol().getText();
        int value = Integer.parseInt(instr.blocks().INT().getSymbol().getText());
        Op op = Op.valueOf(instr.op().getText().toUpperCase());
        Cond cond = buildCond(instr.condition());
        return new Instruction(register, op, value, cond);
    }

    private static Cond buildCond(Puzzle8Parser.ConditionContext condition) {
        String register = condition.register().ID().getSymbol().getText();
        int value = Integer.parseInt(condition.blocks().INT().getSymbol().getText());
        Comp comp = Comp.SYMBOLS.get(condition.comp().getText());
        return new Cond(register, comp, value);
    }

    private enum Op {
        INC {
            @Override
            int apply(int read, int value) {
                return read + value;
            }
        }, DEC {
            @Override
            int apply(int read, int value) {
                return read - value;
            }
        };

        abstract int apply(int read, int value);
    }

    private enum Comp {
        GT {
            @Override
            boolean apply(int read, int value) {
                return read > value;
            }
        }, LT {
            @Override
            boolean apply(int read, int value) {
                return read < value;
            }
        }, EQ {
            @Override
            boolean apply(int read, int value) {
                return read == value;
            }
        }, NEQ {
            @Override
            boolean apply(int read, int value) {
                return read != value;
            }
        }, GTE {
            @Override
            boolean apply(int read, int value) {
                return read >= value;
            }
        }, LTE {
            @Override
            boolean apply(int read, int value) {
                return read <= value;
            }
        };

        static Map<String, Comp> SYMBOLS = init();

        private static Map<String, Comp> init() {
            String[] symbols = {">", "<", "==", "!=", ">=", "<="};
            Map<String, Comp> result = new HashMap<>();
            IntStream.range(0, symbols.length).forEach(i -> result.put(symbols[i], values()[i]));
            return result;
        }

        abstract boolean apply(int read, int value);
    }

    static class Result {
        final int LargestValue;
        final int HighestValueDuringComputation;

        Result(int largestValue, int highestValueDuringComputation) {
            LargestValue = largestValue;
            HighestValueDuringComputation = highestValueDuringComputation;
        }
    }

    private static class Maximum {
        int value = 0;

        int check(int testee) {
            value = testee > value ? testee : value;
            return testee;
        }
    }

    private static class Memory {

        private Map<String, Integer> register = new HashMap<>();

        int read(String reg) {
            return register.computeIfAbsent(reg, s -> 0);
        }

        void write(String reg, int val) {
            register.put(reg, val);
        }
    }

    private static class Cond {
        final String register;
        final Comp comperation;
        final int value;

        private Cond(String register, Comp comperation, int value) {
            this.register = register;
            this.comperation = comperation;
            this.value = value;
        }

        @Override
        public String toString() {
            return "IF " +
                    register + ' ' +
                    comperation + ' ' +
                    value;
        }

        boolean apply(Memory mem) {
            int read = mem.read(register);
            return comperation.apply(read, value);
        }
    }

    private static class Instruction {
        final String register;
        final Op operation;
        final int value;
        final Cond condition;

        private Instruction(String register, Op operation, int value, Cond condition) {
            this.register = register;
            this.operation = operation;
            this.value = value;
            this.condition = condition;
        }

        @Override
        public String toString() {
            return register + ' ' +
                    operation + ' ' +
                    value + ' ' +
                    condition +
                    ';';
        }
    }
}
