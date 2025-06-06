package sorting.strategy;

import sorting.domain.DataType;
import sorting.result.ByCountResult;
import sorting.result.Result;

import java.util.*;

public class CountSortStrategy<T extends Comparable<T>> implements SortingStrategy<T> {

    @Override
    public Result sort(List<T> list, DataType dataType) {
        Map<T, Integer> occurencesMap = new HashMap<>();

        for (T s : list) {
            occurencesMap.put(s, occurencesMap.getOrDefault(s, 0) + 1);
        }

        // Sort the map by occurrences (value) first, then sort by natural order. (key)
        List<Map.Entry<T, Integer>> sortedEntries = new ArrayList<>(occurencesMap.entrySet());
        sortedEntries.sort(
                Comparator.comparing(Map.Entry<T, Integer>::getValue)
                        .thenComparing(Map.Entry::getKey)
        );

        // Convert to regular map.
        Map<T, Integer> sortedByCountMap = new LinkedHashMap<>();
        for (Map.Entry<T, Integer> entry : sortedEntries) {
            sortedByCountMap.put(entry.getKey(), entry.getValue());
        }

        return new ByCountResult<T>(list.size(), sortedByCountMap, dataType);
    }
}
