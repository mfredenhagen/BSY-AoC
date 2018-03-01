import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Puzzle3 {
    static final int X_INDEX = 0;
    static final int Y_INDEX = 1;

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        solve(x, (SpiralCoord c) -> System.out.println(c.distance()));
        solveA(x, c -> System.out.println(c.next().Value));
    }

    protected static void solve(int x, Consumer<SpiralCoord> block) {
        Context.init((sc, coords) -> sc.Value + 1);
        Stream<SpiralCoord> coordStream = Stream.iterate(new SpiralCoord(0, 0, 1, SpiralCoord.Sector.ORIGIN, null), SpiralCoord::next);
        coordStream.limit(x).skip(x - 1).findFirst().ifPresent(block);
    }

    protected static void solveA(int x, Consumer<SpiralCoord> block) {
        Context.init((spiralCoord, coords) -> Stream.iterate(spiralCoord, sc -> sc.Prev).takeWhile(Objects::nonNull)
                .filter(sc -> sc.isAdjacent(coords[X_INDEX], coords[Y_INDEX])).mapToInt(sc -> sc.Value).sum());
        Stream<SpiralCoord> coordStream = Stream.iterate(new SpiralCoord(0, 0, 1, SpiralCoord.Sector.ORIGIN, null), SpiralCoord::next);
        coordStream.takeWhile(sc -> sc.Value <= x).reduce((a, b) -> b).ifPresent(block);
    }

    private static class Context {
        private static Context INSTANCE;
        private final BiFunction<SpiralCoord, int[], Integer> valueGenerator;

        private Context(BiFunction<SpiralCoord, int[], Integer> valueGenerator) {
            this.valueGenerator = valueGenerator;
        }

        private static void init(BiFunction<SpiralCoord, int[], Integer> valueGenerator) {
            INSTANCE = new Context(valueGenerator);
        }

        private static int newValue(SpiralCoord sc, int[] coords) {
            if (INSTANCE == null) {
                throw new IllegalStateException("No Context initialized");
            }
            return INSTANCE.valueGenerator.apply(sc, coords);
        }
    }

    protected static class SpiralCoord {
        final int X;
        final int Y;
        final int Value;
        final Sector sector;
        final SpiralCoord Prev;

        SpiralCoord(int x, int y, int value, Sector sector, SpiralCoord prev) {
            X = x;
            Y = y;
            Value = value;
            this.sector = sector;
            Prev = prev;
        }

        SpiralCoord next() {
            Sector sector = Math.abs(X) == Math.abs(Y) ? this.sector.next() : this.sector;
            final int[] coords = coords((this.sector == Sector.ORIGIN || this.sector == Sector._4) ? this.sector : sector);
            int newValue = Context.newValue(this, coords);
            return new SpiralCoord(coords[X_INDEX], coords[Y_INDEX], newValue, sector, this);
        }

        private int[] coords(Sector sector) {
            switch (sector) {
                case _1:
                    return new int[]{this.X, this.Y + 1};
                case _2:
                    return new int[]{this.X - 1, this.Y};
                case _3:
                    return new int[]{this.X, this.Y - 1};
                default:
                    return new int[]{this.X + 1, this.Y};
            }
        }

        @Override
        public String toString() {
            return String.format("SpiralCoord(%6d => %2d, %2d)", Value, X, Y);
        }

        boolean isAdjacent(int x, int y) {
            return Math.abs(x - X) < 2 && Math.abs(y - Y) < 2;
        }

        int distance() {
            return Math.abs(X) + Math.abs(Y);
        }

        protected enum Sector {
            ORIGIN, _1, _2, _3, _4 {
                @Override
                Sector next() {
                    return _1;
                }
            };

            Sector next() {
                return values()[ordinal() + 1];
            }
        }
    }

}
