package sorting.domain.result;

public final class LongSortResult implements SortResult {

    private final long amount;
    private final String sorted;

    public LongSortResult(long amount, String sorted) {
        this.amount = amount;
        this.sorted = sorted;
    }

    @Override
    public long getAmount() {
        return this.amount;
    }

    @Override
    public String getSorted() {
        return this.sorted;
    }

    @Override
    public String getResult() {
        return String.format("Total numbers: %d.%nSorted data: %s", amount, sorted);
    }
}
