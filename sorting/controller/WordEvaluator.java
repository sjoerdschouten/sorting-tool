package sorting.controller;

import sorting.domain.result.Result;
import sorting.domain.result.WordSortResult;
import sorting.domain.statistic.LongStatistic;
import sorting.domain.statistic.WordStatistic;

import java.util.*;
import java.util.stream.Collectors;

public class WordEvaluator implements InputEvaluator {
    private final Scanner scanner;
    private final SortingType sortingType;
    private List<String> wordList = new ArrayList<>();

    public WordEvaluator(Scanner scanner, SortingType sortingType) {
        this.scanner = scanner;
        this.sortingType = sortingType;
    }


    @Override
    public void readUserInput() {
        while (scanner.hasNext()) {
            String word = scanner.next();
            wordList.add(word);
        }
    }

    @Override
    public Result sort() {

        switch (sortingType) {
            case NATURAL -> // sort naturally
            {
                Collections.sort(wordList);
                return new WordSortResult(wordList.size(),
                        wordList.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining("\n")));
            }
            case BY_COUNT -> {

                // create a map to count occurences
                Map<String, Integer> countMap = new LinkedHashMap<>();
                for (String word : wordList) {
                    countMap.put(word, countMap.getOrDefault(word, 0 ) + 1);
                }

                // Create a list from the entry set of the count map.
                List<Map.Entry<String, Integer>> sortedWordEntries = new ArrayList<>(countMap.entrySet());
                sortedWordEntries.sort(
                        Comparator.comparing(Map.Entry<String, Integer>::getValue)
                                .thenComparing(Map.Entry<String, Integer>::getKey)
                );

//                sortedWordEntries.sort(new Comparator<Map.Entry<String, Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
//                        int keyComparison = entry1.getKey().compareTo(entry2.getKey());
//                        if (keyComparison != 0) {
//                            return keyComparison;
//                        } else {
//                            return entry1.getValue().compareTo(entry2.getValue());
//                        }
//                    }
//                });
                // create a new LinkedHashMap to maintain the order.
                Map<String, Integer> sortedByCountMap = new LinkedHashMap<>();
                for (Map.Entry<String, Integer> entry : sortedWordEntries) {
                    sortedByCountMap.put(entry.getKey(), entry.getValue());
                }

                return new WordStatistic(wordList.size(), sortedByCountMap);
            }
            default -> throw new IllegalArgumentException("Something wrong");
        }


    }

    private String findgreatest() {
        String longestword = "";
        for (String word : wordList) {
            if (word.length() > longestword.length()) {
                longestword = word; // update longest word.
            } else if (word.length() == longestword.length()) {
                // same length need to compare alphabetically
                if (word.compareTo(longestword) < 0) {
                    longestword = word; // update to the alphabetically first word
                }
            }
        }
        return longestword;
    }
}
