package sorting.controller;

import sorting.domain.LineStatictics;
import sorting.domain.Result;
import sorting.domain.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LineEvaluator implements InputEvaluator {
    private List<String> lineList = new ArrayList<>();
    private Scanner scanner;

    public LineEvaluator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void readUserInput() {
        while (scanner.hasNextLine()) {
            lineList.add(scanner.nextLine());
        }
    }

    @Override
    public Statistics evaluate() {
        long amount = lineList.size();
        String max = "";
        for (String line : this.lineList) {
            if (line.length() > max.length()) {
                max = line;
            }
        };
        long maxOccurences = Collections.frequency(this.lineList, max);
        return new LineStatictics(amount, max, maxOccurences);
     }
}
