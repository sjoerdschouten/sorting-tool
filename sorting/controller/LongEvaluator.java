package sorting.controller;


import sorting.domain.result.LongSortResult;
import sorting.domain.result.Result;
import sorting.domain.statistic.LongStatistic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongEvaluator implements InputEvaluator {
    private final Scanner scanner;
    private SortingType sortingType;
    private List<Long> longList = new ArrayList<>();

    public LongEvaluator(Scanner scanner, SortingType sortingType) {
        this.scanner = scanner;
        this.sortingType = sortingType;
    }

    @Override
    public void readUserInput() {
        while (scanner.hasNextInt()) {
            longList.add(scanner.nextLong());
        }
    }

    @Override
    public Result sort() {
        // account for sorting type
        // maybe introduce new sort of statistics?

        switch (sortingType) {
            case BY_COUNT -> {
                // we sort lexicographically first.
                longList.sort(Comparator.naturalOrder());

                // create a map to count occurences
                Map<Long, Integer> countMap = new HashMap<>();
                for (Long number : longList) {
                    countMap.put(number, countMap.getOrDefault(number, 0 ) + 1);
                }

                // Create a list from the entry set of the count map.
                List<Map.Entry<Long, Integer>> entryList = new ArrayList<>(countMap.entrySet());

                // Sort the entry list by value (count)
                entryList.sort(Map.Entry.comparingByValue());

                // create a new LinkedHashMap to maintain the order.
                Map<Long, Integer> sortedByCount = new LinkedHashMap<>();
                for (Map.Entry<Long, Integer> entry : entryList) {
                    sortedByCount.put(entry.getKey(), entry.getValue());
                }

                return new LongStatistic(longList.size(), sortedByCount);
            }

            case NATURAL -> {
                Collections.sort(longList);
                return new LongSortResult(longList.size(),
                        longList.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(" "))
                );
            }
            default -> throw new IllegalArgumentException("Something wrong");
        }
    }
}
