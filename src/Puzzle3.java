import java.util.function.Consumer;
import java.util.stream.Stream;

public class Puzzle3 {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        solve(x, (SpiralCoord c) -> System.out.println(c.distance()));
    }

    protected static void solve(int x, Consumer<SpiralCoord> block) {
        Stream<SpiralCoord> coordStream = Stream.iterate(new SpiralCoord(0, 0, 1, SpiralCoord.Sector.ORIGIN), SpiralCoord::next);
        coordStream.limit(x).skip(x - 1).findFirst().ifPresent(block);
    }

    protected static class SpiralCoord {
        final int X;
        final int Y;
        final int Value;
        final Sector sector;

        SpiralCoord(int x, int y, int value, Sector sector) {
            X = x;
            Y = y;
            Value = value;
            this.sector = sector;
        }

        SpiralCoord next() {
            int newValue = this.Value + 1;
            Sector sector = Math.abs(X) == Math.abs(Y) ? this.sector.next() : this.sector;
            switch ((this.sector == Sector.ORIGIN || this.sector == Sector._4) ? this.sector : sector) {
                case _1:
                    return new SpiralCoord(this.X, this.Y + 1, newValue, sector);
                case _2:
                    return new SpiralCoord(this.X - 1, this.Y, newValue, sector);
                case _3:
                    return new SpiralCoord(this.X, this.Y - 1, newValue, sector);
                default:
                    return new SpiralCoord(this.X + 1, this.Y, newValue, sector);
            }
        }

        @Override
        public String toString() {
            return String.format("SpiralCoord(%6d => %2d, %2d)", Value, X, Y);
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
