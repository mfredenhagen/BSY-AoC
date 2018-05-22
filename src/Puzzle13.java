import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Puzzle13 {

    public static void main(String[] args) {
        System.out.println("Firewall-Severity for picosecond 0:" + solve(args));
    }

    public static int solve(String[] args) {
        return Puzzle13.Firewall.buildFirewall(args).caught().sum();
    }

    public static int solveA(String[] args) {
        return Puzzle13.Firewall.buildFirewall(args).passThrough();
    }

    static class Layer {

        private final int depth;

        Layer(int depth) {
            this.depth = depth;
        }

        void step() {
        }

        boolean isAtTop() {
            return false;
        }

        int getDepth() {
            return depth;
        }

        int getSeverity() {
            return 0;
        }

        void resetState() {
        }

        int getState() {
            return -1;
        }
    }

    static class RangeLayer extends Layer {

        private final int range;
        private int state = 0;
        private int step = 0;

        RangeLayer(int range, int depth) {
            super(depth);
            this.range = range - 1;
        }

        void step() {
            if (state == range) {
                step = -1;
            }
            if (state == 0) {
                step = 1;
            }
            state += step;
        }

        @Override
        boolean isAtTop() {
            return state == 0;
        }

        @Override
        int getSeverity() {
            return getDepth() * (range + 1);
        }

        @Override
        void resetState() {
            this.state = 0;
            this.step = 1;
        }

        @Override
        int getState() {
            return state;
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
                firewall.addLayer(new Puzzle13.RangeLayer(Integer.parseInt(pair[1]), depth));
            });
            return firewall;
        }

        void addLayer(Layer layer) {
            while (layers.size() < layer.getDepth()) {
                layers.add(new Layer(layers.size()));
            }
            layers.add(layer);
        }

        void step() {
            layers.forEach(Layer::step);
        }

        Stream<Layer> getRangeLayers() {
            return layers.stream().filter(l -> l instanceof RangeLayer);
        }

        IntStream caught() {
            IntStream.Builder builder = IntStream.builder();
            for (Layer layer : layers) {
                if (layer.isAtTop()) {
                    builder.accept(layer.getSeverity());
                }
                step();
            }
            return builder.build();
        }

        int passThrough() {
            int delay = 0;
            while (caught().count() != 0) {
                resetLayers();
                ++delay;
                System.out.println("Waiting " + delay + " picoseconds");
                IntStream.range(0, delay).forEach(i -> step());
            }
            return delay;
        }

        private void resetLayers() {
            Stream<Layer> rangeLayers = getRangeLayers();
            rangeLayers.forEach(Layer::resetState);
        }
    }
}
