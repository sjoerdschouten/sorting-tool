package sorting.controller;

import sorting.domain.result.Result;
import sorting.view.ConsolePrinter;

import java.util.Scanner;

/**
 * Application controller for Sorting Tool. The run() method is the entry point for the main application.
 * The ConsolePrinter is (mock-friendly) delivered through the constructor. The mode enum decides, which
 * implementation of Evaluator is used in the app.
 */
public class SortingToolController {

    private final InputEvaluator evaluator;
    private final ConsolePrinter consolePrinter;


    public SortingToolController(DataType dataType, SortingType sortingType, ConsolePrinter consolePrinter, Scanner scanner) {
        this.consolePrinter = consolePrinter;
        this.evaluator = switch (dataType) {
            case LONG -> new LongEvaluator(scanner, sortingType);
            case LINE -> new LineEvaluator(scanner, sortingType);
            case WORD -> new WordEvaluator(scanner, sortingType);
            case SORT_LONG -> new LongSorter(scanner);
        };
    }
    /**
     * entry point for the Sorting Tool.
     */
    public void execute() {
        evaluator.readUserInput();
        Result evaluationResult = evaluator.sort();
        consolePrinter.printObject(evaluationResult.getResult());
    }
}
