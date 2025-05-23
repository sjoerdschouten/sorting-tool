package sorting.controller;

import sorting.domain.WordStatistics;
import sorting.domain.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordEvaluator implements InputEvaluator {
    private final Scanner scanner;
    private List<String> wordList = new ArrayList<>();

    public WordEvaluator(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public void readUserInput() {
        while (scanner.hasNext()) {
            wordList.add(scanner.next());
        }
    }

    @Override
    public Statistics evaluate() {
        long amount = wordList.size();
        String max = findgreatest();
        long maxOccurences = Collections.frequency(wordList, max);
        return new WordStatistics(amount, max, maxOccurences);
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
