package sorting.domain.statistic;

import java.util.Map;

public class LongStatistic implements Statistics {
    private final long amount;
    private final Map<Long, Integer> occurenceMap;


    public LongStatistic(int amount, Map<Long, Integer> occurenceMap) {
        this.amount = amount;
        this.occurenceMap = occurenceMap;
    }

    @Override
    public String getResult() {
        return String.format("Total numbers: %d.%n", amount) +
                buildReport();
    }
    private String buildReport() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Long, Integer> entry : occurenceMap.entrySet()) {
            Long number = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / amount * 100;

            sb.append(String.format("%s: %d time(s), %.0f%%%n", number, count, percentage));
        }
        return sb.toString();
    }

    @Override
    public long getAmount() {
        return this.amount;
    }
}
