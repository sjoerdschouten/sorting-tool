package sorting.controller;

import sorting.domain.LongStatistics;
import sorting.domain.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LongEvaluator implements InputEvaluator {
    private final Scanner scanner;
    private List<Long> longList =new ArrayList<>();

    public LongEvaluator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void readUserInput() {
        while (scanner.hasNextInt()) {
            longList.add(scanner.nextLong());
        }
    }

    @Override
    public Result evaluate() {
        long amount = longList.size();
        long max = Collections.max(longList);
        long maxOccurrences = getMaxOccurrences();

        return new LongStatistics(amount,max, maxOccurrences);
    }

    private long getMaxOccurrences() {
        // todo improvement; rewrite this using streams.
        Long greatestNumber = Long.MIN_VALUE;
        int counter = 0;

        for (Long number : longList) {
            if (number > greatestNumber) {
                greatestNumber = number;
                counter = 1;
            } else if (number.equals(greatestNumber)) {
                counter++;
            }
        }
        return counter;
    }
}
