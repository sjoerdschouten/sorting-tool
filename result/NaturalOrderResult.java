package sorting.result;

import sorting.domain.DataType;

public class NaturalOrderResult implements INaturalOrderResult {
    private final long amount;
    private final String sorted;
    private final DataType dataType;

    public NaturalOrderResult(long amount, String sorted, DataType dataType) {
        this.amount = amount;
        this.sorted = sorted;
        this.dataType = dataType;
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
        return String.format("Total %s: %d.%nSorted data: %s", dataType.getPrintName(), amount, sorted);
    }
}
