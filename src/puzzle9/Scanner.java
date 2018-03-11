package puzzle9;

public class Scanner {
    private GarbageDetector gd = new GarbageDetector();

    public ScanResult scan(char c) {
        if (gd.isGarbage(c) || ',' == c) return ScanResult.NOTHING;
        if ('{' == c) return ScanResult.OPEN_GROUP;
        if ('}' == c) return ScanResult.CLOSE_GROUP;
        throw new IllegalArgumentException(c + " is not in garbage or a group delimiter @");
    }

    public int garbageCount() {
        return gd.countGarbage.get();
    }

    public enum ScanResult {
        OPEN_GROUP, CLOSE_GROUP, NOTHING
    }
}
