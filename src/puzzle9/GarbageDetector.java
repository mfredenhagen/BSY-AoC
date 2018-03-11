package puzzle9;

import java.util.concurrent.atomic.AtomicInteger;

public class GarbageDetector {

    public AtomicInteger countGarbage = new AtomicInteger();
    private Escape escaped = new Escape();
    private boolean garbageEntered;

    public boolean isGarbage(char c) {
        if (!escaped.ignored(c)) {
            if (c == '<' && !garbageEntered) {
                garbageEntered = true;
            } else if (c == '>') {
                garbageEntered = false;
                return true;
            } else {
                if (garbageEntered) {
                    countGarbage.incrementAndGet();
                }
            }
        }
        return garbageEntered;
    }

    private class Escape {

        private boolean state = false;

        boolean ignored(char c) {
            boolean result = state;
            state = '!' == c && !state;
            return result || '!' == c;
        }
    }
}
