package sorting.domain;

public class LongStatistics implements Statistics {
    private final long amount;
    private final long max;
    private final long maxOccurrences;

    public LongStatistics(long amount, long max, long maxOccurrences) {
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
        return String.format("Total numbers: %d.%nThe greatest number: %d (%d time(s), %d%%).",
                amount, max, maxOccurrences, calcMaxPercentage());
    }
}
