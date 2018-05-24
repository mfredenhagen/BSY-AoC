import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Puzzle13 {

    public static void main(String[] args) {
        System.out.println("Firewall-Severity for picosecond 0:" + solve(args) + " and pass through at " + solveA(args));
    }

    protected static int solve(String[] args) {
        return Puzzle13.Firewall.buildFirewall(args).caught(0).sum();
    }

    protected static int solveA(String[] args) {
        return Puzzle13.Firewall.buildFirewall(args).passThrough();
    }

    static class Layer {

        private final int depth;
        private final int range;

        Layer(int range, int depth) {
            this.depth = depth;
            this.range = range - 1;
        }

        boolean isAtTop(int time) {
            // idea borrowed from https://github.com/tginsberg/advent-2017-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2017/Day13.kt
            return (time + depth) % (2 * range) == 0;
        }

        int getSeverity() {
            return depth * (range + 1);
        }

        public int getDepth() {
            return depth;
        }

    }

    static class Firewall {

        private final List<Layer> layers;


        Firewall() {
            this.layers = new ArrayList<>();
        }

        static Firewall buildFirewall(String[] data) {
            Puzzle13.Firewall firewall = new Puzzle13.Firewall();
            IntStream.range(0, data.length).forEach(i -> {
                String[] pair = data[i].split(": ");
                int depth = Integer.parseInt(pair[0]);
                firewall.addLayer(new Puzzle13.Layer(Integer.parseInt(pair[1]), depth));
            });
            return firewall;
        }

        void addLayer(Layer layer) {
            layers.add(layer);
        }

        public List<Layer> getLayers() {
            return layers;
        }

        IntStream caught(int time) {
            IntStream.Builder builder = IntStream.builder();
            for (Layer layer : layers) {
                if (layer.isAtTop(time)) {
                    builder.accept(layer.getSeverity());
                }
            }
            return builder.build();
        }

        int passThrough() {
            return IntStream.iterate(0, i -> ++i).filter(time -> caught(time).count() == 0).findFirst().orElse(-1);
        }
    }
}
