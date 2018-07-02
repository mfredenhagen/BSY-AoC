import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Puzzle16 {

    static final String LINE_OF_DANCERS = "abcdefghijklmnop";

    public static void main(String[] args) {
        System.out.println("Puzzle 16 line of dancers after one dance: " + solve(args[0], LINE_OF_DANCERS) + " and after 1_000_000_000 dances: " + solveA(args[0], LINE_OF_DANCERS));
    }

    protected static String solve(String input, String dancers) {
        return dance(dancers, getMoves(input));
    }

    private static String dance(String dancers, List<Move> moves) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push(dancers);
        moves.forEach(move -> stack.push(move.apply(stack.pop())));
        return stack.pop();
    }

    private static List<Move> getMoves(String input) {
        CharStream source = CharStreams.fromString(input);
        Puzzle16Lexer lexer = new Puzzle16Lexer(source);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Puzzle16Parser parser = new Puzzle16Parser(tokens);
        List<Move> moves = new ArrayList<>();
        new Puzzle16BaseVisitor<Void>() {
            @Override
            public Void visitSpin(Puzzle16Parser.SpinContext ctx) {
                moves.add(new Spin(Integer.parseInt(ctx.INT().getSymbol().getText())));
                return super.visitSpin(ctx);
            }

            @Override
            public Void visitExchange(Puzzle16Parser.ExchangeContext ctx) {
                moves.add(new Exchange(Integer.parseInt(ctx.x().INT().getSymbol().getText()), Integer.parseInt(ctx.y().INT().getSymbol().getText())));
                return super.visitExchange(ctx);
            }

            @Override
            public Void visitPartner(Puzzle16Parser.PartnerContext ctx) {
                moves.add(new Partner(ctx.a().getText(), ctx.b().getText()));
                return super.visitPartner(ctx);
            }
        }.visit(parser.dancemoves());
        return moves;
    }

    protected static String solveA(String input, String dancers) {
        return solveA(input, dancers, 1_000_000_000);
    }

    protected static String solveA(String input, String dancers, int iterations) {
        String tmp = dancers;
        List<String> pastLines = new ArrayList<>();
        pastLines.add(tmp);
        List<Move> moves = getMoves(input);
        // Todo rewrite with Stream.iterate and takeWhile/limit (peek pastLines)
        for (int i = 0; i < iterations; i++) {
            tmp = dance(tmp, moves);
            // check for cycle
            if (dancers.equals(tmp)) {
                return pastLines.get((iterations % (i + 1)));
            } else {
                // recording the dance
                pastLines.add(tmp);
            }
        }
        // if there was no cycle before iterations dances
        return pastLines.get(pastLines.size() - 1);
    }

    private static abstract class Move {
        abstract String apply(String dancers);

        protected String swap(String dancers, int x, int y) {
            char[] chars = dancers.toCharArray();
            char _x = chars[x];
            chars[x] = chars[y];
            chars[y] = _x;
            return new String(chars);
        }
    }

    private static class Spin extends Move {

        private final int value;

        private Spin(int value) {
            this.value = value;
        }

        @Override
        String apply(String dancers) {
            int split = dancers.length() - value;
            return dancers.substring(split) + dancers.substring(0, split);
        }
    }

    private static class Exchange extends Move {

        private final int x;
        private final int y;

        private Exchange(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        String apply(String dancers) {
            return swap(dancers, x, y);
        }
    }

    private static class Partner extends Move {

        private final String a;
        private final String b;

        private Partner(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        String apply(String dancers) {
            int x = dancers.indexOf(a);
            int y = dancers.indexOf(b);
            return swap(dancers, x, y);
        }
    }
}
