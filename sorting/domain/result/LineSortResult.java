package sorting.domain.result;

public class LineSortResult implements SortResult {
    private final long amount;
    private final String sorted;

    public LineSortResult(long amount, String sorted) {
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
        return String.format("Total lines: %d.%nSorted data: %n%s", amount, sorted);
    }
}
