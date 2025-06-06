package sorting.result;

import sorting.domain.DataType;

import java.util.Map;

public class ByCountResult<T> implements IByCountResult {
    public final long amount;
    public final Map<T, Integer> occurenceMap;
    private final DataType dataType;

    public ByCountResult(long amount, Map<T, Integer> occurenceMap, DataType dataType) {
        this.amount = amount;
        this.occurenceMap = occurenceMap;
        this.dataType = dataType;
    }

    @Override
    public String getResult() {
        return String.format("Total %s: %d.%n", dataType.getPrintName(), amount) +
                buildReport();
    }

    @Override
    public long getAmount() {
        return this.amount;
    }

    private String buildReport() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<T, Integer> entry : occurenceMap.entrySet()) {
            T elem = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / amount * 100;

            sb.append(String.format("%s: %d time(s), %.0f%%%n", elem, count, percentage));
        }
        return sb.toString();
    }
}
