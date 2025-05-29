package sorting.domain.result;

public class WordSortResult implements SortResult {
    private final long amount;
    private final String sorted;

    public WordSortResult(long amount, String sorted) {
        this.amount = amount;
        this.sorted = sorted;
    }


    @Override
    public long getAmount() {
        return this.amount;
    }

    @Override
    public String getSorted() {
        return sorted;
    }

    @Override
    public String getResult() {
        return String.format("Total words: %d.%nSorted data: %s", amount, sorted);
    }
}
