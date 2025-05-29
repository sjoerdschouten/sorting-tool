package sorting.domain.statistic;

import java.util.Map;

public class LineStatictic implements Statistics {
    public final long amount;
    public final Map<String, Integer> occurenceMap;

    public LineStatictic(long amount, Map<String, Integer> occurenceMap) {
        this.amount = amount;
        this.occurenceMap = occurenceMap;
    }

    @Override
    public long getAmount() {
        return this.amount;
    }

    @Override
    public String getResult() {
        return String.format("Total lines: %d.%n", amount) +
                buildReport();
    }

    private String buildReport() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : occurenceMap.entrySet()) {
            String line = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / amount * 100;

            sb.append(String.format("%s: %d time(s), %.0f%%%n", line, count, percentage));
        }
        return sb.toString();
    }
}
