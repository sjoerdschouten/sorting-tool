package sorting.controller;

import sorting.domain.result.LineSortResult;
import sorting.domain.result.Result;
import sorting.domain.statistic.LineStatictic;

import java.util.*;
import java.util.stream.Collectors;

public class LineEvaluator implements InputEvaluator {
    private final Scanner scanner;
    private List<String> lineList = new ArrayList<>();
    private SortingType sortingType;

    public LineEvaluator(Scanner scanner, SortingType sortingType) {
        this.scanner = scanner;
        this.sortingType = sortingType;
    }

    @Override
    public void readUserInput() {
        while (scanner.hasNextLine()) {
            lineList.add(scanner.nextLine());
        }
    }

    @Override
    public Result sort() {
        switch (sortingType) {
            case NATURAL -> // sort naturally
            {
                Collections.sort(lineList);
                return new LineSortResult(lineList.size(),
                        lineList.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining("\n")));
            }
            case BY_COUNT -> {
                // we sort lexicographically first.
                Map<String, Integer> countMap = new HashMap<>();
                // used a TreeMap here to force natural ordering.
                for (String line : lineList) {
                    countMap.put(line, countMap.getOrDefault(line, 0) + 1);
                }

                List<Map.Entry<String, Integer>> sortedWordEntries = new ArrayList<>(countMap.entrySet());
                sortedWordEntries.sort(
                        Comparator.comparing(Map.Entry<String, Integer>::getValue)
                                .thenComparing(Map.Entry<String, Integer>::getKey)
                );

                Map<String, Integer> sortedByCountMap = new LinkedHashMap<>();
                for (Map.Entry<String, Integer> entry : sortedWordEntries) {
                    sortedByCountMap.put(entry.getKey(), entry.getValue());
                }
//                LinkedHashMap<String, Integer> sortedByCountMap = occurenceMap.entrySet().stream()
//                        .sorted(Map.Entry.comparingByValue())
//                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new
//                        ));


                return new LineStatictic(lineList.size(), sortedByCountMap);
            }
            default -> throw new IllegalArgumentException("Something wrong");
        }
    }

}
