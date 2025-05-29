package sorting.controller;

import sorting.domain.result.LongSortResult;
import sorting.domain.result.SortResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * * Evaluator implementation for reading Longs from stdin, sorting and returning the result.
 */
public class LongSorter implements InputEvaluator {
    private List<Long> longList;
    private final Scanner scanner;

    public LongSorter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void readUserInput() {
        ArrayList<Long> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextLong());
        }
        longList = numbers;
    }

    @Override
    public SortResult sort() {
        Collections.sort(longList);
        return new LongSortResult(longList.size(),
                longList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}
