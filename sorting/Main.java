package sorting;

import sorting.controller.Mode;
import sorting.controller.SortingToolController;
import sorting.view.ConsolePrinter;

import java.util.Arrays;
import java.util.List;

/**
 * main class for the sorting tool.
 */
public class Main {
    private static final String USAGE = "Usage: java SortingTool [-dataType long|line|word].";
    private static final String DATA_OPTION = "-dataType";

    public static void main(final String[] args) {
        new SortingToolController(getMode(args), new ConsolePrinter()).run();
    }

    static Mode getMode(String[] args) {
        if (args.length == 0) {
            return Mode.WORD;
        }
        List<String> argList = Arrays.asList(args);
        if (argList.contains("-sortIntegers")) {
            return Mode.SORT_LONG;
        }
        if (!argList.contains(DATA_OPTION) || argList.indexOf(DATA_OPTION) >= argList.size() - 1) {
            throw new IllegalStateException(USAGE);
        }
        return switch (args[argList.indexOf(DATA_OPTION) + 1]) {
            case "long" -> Mode.LONG;
            case "line" -> Mode.LINE;
            case "word" -> Mode.WORD;
            default -> throw new IllegalStateException(USAGE);
        };
    }
}