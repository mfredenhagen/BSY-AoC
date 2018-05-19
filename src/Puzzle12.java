import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Puzzle12 {

    public static void main(String[] args) throws IOException {
        InputStream stream = Puzzle12.class.getResourceAsStream("./Puzzle12.txt");
        System.out.print("Reachable Programs from Program('0'): " + solve(stream));
        stream = Puzzle12.class.getResourceAsStream("./Puzzle12.txt");
        System.out.println("; number of groups: " + solveA(stream));
    }

    protected static int solve(InputStream in) throws IOException {
        loadProgCollection(in);
        Prog root = ProgCollection.INSTANCE.get("0");
        return getGroupFor(root).size();
    }

    private static void loadProgCollection(InputStream in) throws IOException {
        ProgCollection.INSTANCE.getAllProgs().clear();
        CharStream source = CharStreams.fromStream(in);
        Puzzle12Lexer lexer = new Puzzle12Lexer(source);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Puzzle12Parser parser = new Puzzle12Parser(tokens);
        parser.list().prog().stream().map(progContext -> {
            Prog result = new Prog(progContext.name().getText());
            parsePipes(result, progContext.pipes().name());
            return result;
        }).forEach(ProgCollection.INSTANCE::add);
    }

    private static Set<Prog> getGroupFor(Prog root) {
        Deque<Prog> queue = new LinkedList<>();
        Set<Prog> visited = new HashSet<>();
        visited.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            Prog prog = queue.remove();
            prog.Pipes.forEach(pp -> {
                if (visited.add(pp.getProg())) {
                    queue.add(pp.getProg());
                }
            });
        }
        return visited;
    }

    protected static int solveA(InputStream in) throws IOException {
        loadProgCollection(in);
        Prog root = ProgCollection.INSTANCE.get("0");
        Set<Prog> allProgs = new HashSet<>(ProgCollection.INSTANCE.getAllProgs());
        Set<Prog> groupFor = getGroupFor(root);
        int result = 0;
        while (!allProgs.isEmpty()) {
            result++;
            allProgs.removeAll(groupFor);
            Iterator<Prog> progIterator = allProgs.iterator();
            if (progIterator.hasNext()) {
                groupFor = getGroupFor(progIterator.next());
            }
        }
        return result;
    }

    private static void parsePipes(Prog result, List<Puzzle12Parser.NameContext> name) {
        name.stream().map(RuleContext::getText).forEach(result::addPipe);
    }

    private static class ProgCollection {
        static final ProgCollection INSTANCE = new ProgCollection();
        private final Map<String, Prog> progs = new HashMap<>();

        void add(Prog prog) {
            progs.put(prog.Name, prog);
        }

        Prog get(String name) {
            return progs.get(name);
        }

        Collection<Prog> getAllProgs() {
            return progs.values();
        }
    }

    private static class Prog {
        final String Name;
        final List<ProgProxy> Pipes;

        Prog(String name) {
            Name = name;
            Pipes = new ArrayList<>();
        }

        void addPipe(String name) {
            Pipes.add(new ProgProxy(name));
        }

        @Override
        public String toString() {
            return Name +
                    " <-> " + Pipes.stream().map(p -> p.getProg().Name).collect(Collectors.joining(", "))
                    ;
        }

        private class ProgProxy {
            final String progName;
            private Prog prog;

            private ProgProxy(String progName) {
                this.progName = progName;
            }

            Prog getProg() {
                if (prog == null) {
                    prog = ProgCollection.INSTANCE.get(progName);
                }
                return prog;
            }

            @Override
            public String toString() {
                return "ProgProxy{" +
                        "prog=" + getProg().Name +
                        '}';
            }
        }
    }
}
