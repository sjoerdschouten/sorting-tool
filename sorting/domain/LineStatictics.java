package sorting.domain;

public class LineStatictics implements Statistics {
    public final long amount;
    public final String max;
    public final long maxOccurrences;

    public LineStatictics(long amount, String max, long maxOccurrences) {
        this.amount = amount;
        this.max = max;
        this.maxOccurrences = maxOccurrences;
    }

    @Override
    public long getAmount() {
        return this.amount;
    }

    @Override
    public long getMaxOccurrences() {
        return this.maxOccurrences;
    }

    @Override
    public String getResult() {
        return String.format("Total lines: %d.%nThe longest line:%n%s%n(%d time(s), %d%%).",
                amount, max, maxOccurrences, calcMaxPercentage());
    }
}
