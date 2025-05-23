package sorting.domain;

public class WordStatistics implements Statistics {
    private final long amount;
    private final String max;
    private final long maxOccurrences;

    public WordStatistics(long amount, String max, long maxOccurrences) {
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
        return String.format("Total words: %d.%nThe longest word: %s (%d time(s), %d%%).",
                amount, max, maxOccurrences, calcMaxPercentage());
    }
}
