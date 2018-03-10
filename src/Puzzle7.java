import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Puzzle7 {

    public static void main(String[] args) {
        Puzzle7Result result = solve(args);
        System.out.printf("Bottom Prog %s, corrected weight: %d\n"
                , result.BottomProgram, result.CorrectedWeight);
    }

    public static Puzzle7Result solve(String[] args) {
        String input = Arrays.stream(args, 0, args.length).collect(Collectors.joining("\n"));
        Puzzle7Lexer lexer = new Puzzle7Lexer(CharStreams.fromString(input + "\n"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Puzzle7Parser parser = new Puzzle7Parser(tokens);
        parser.list().prog().stream().map(p -> new Prog(p.name().ID().getSymbol().getText()
                , Integer.parseInt(p.weight().INT().getSymbol().getText())
                , p.disc() == null ? Collections.emptyList() : p.disc().name().stream()
                .map(n -> n.ID().getSymbol().getText()).collect(toList())))
                .forEach(ProgCollection.INSTANCE::add);
        List<Prog> allProgs = new ArrayList<>(ProgCollection.INSTANCE.getAllProgs());
        allProgs.removeAll(allProgs.stream().flatMap(Prog::DiscProgs).distinct().collect(Collectors.toSet()));
        Prog rootProg = allProgs.get(0);
        Prog wrongProg = rootProg.findWrongProg();
        Map<Integer, List<Prog>> discWeights = rootProg.DiscProgs().collect(groupingBy(Prog::weight));
        Map<Integer, Integer> frequencies = discWeights.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getValue().size(), Map.Entry::getKey));
        int wrongWeight = frequencies.get(1);
        int balancedWeight = frequencies.get(rootProg.Disc.size() - 1);
        return new Puzzle7Result(rootProg.Name, (wrongProg.Weight - wrongWeight + balancedWeight));
    }

    protected static class Puzzle7Result {
        public final String BottomProgram;
        public final int CorrectedWeight;

        private Puzzle7Result(String bottomProgram, int correctedWeight) {
            BottomProgram = bottomProgram;
            CorrectedWeight = correctedWeight;
        }
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
        final int Weight;
        final List<ProgProxy> Disc = new ArrayList<>();

        private Prog(String name, int weight, List<String> childNames) {
            Name = name;
            Weight = weight;
            Disc.addAll(childNames.stream().map(ProgProxy::new).collect(toList()));
        }

        @Override
        public String toString() {
            return "Prog{" +
                    "Name='" + Name + '\'' +
                    ", Weight=" + Weight +
                    ", Disc=" + Disc +
                    '}';
        }

        Stream<Prog> DiscProgs() {
            return Disc.stream().map(ProgProxy::getProg);
        }

        int weight() {
            return Weight + Disc.stream().mapToInt(c -> c.getProg().weight()).sum();
        }

        Prog findWrongProg() {
            Map<Integer, List<Prog>> groupBy = Disc.stream().map(ProgProxy::getProg).collect(groupingBy(Prog::weight));
            Optional<Map.Entry<Integer, List<Prog>>> found = groupBy.entrySet().stream().filter(e -> e.getValue().size() == 1)
                    .findFirst();
            return found.map(integerListEntry -> integerListEntry.getValue().get(0).findWrongProg()).orElse(this);
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
