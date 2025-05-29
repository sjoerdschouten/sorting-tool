package sorting;

import sorting.controller.ArgumentParser;
import sorting.controller.DataType;
import sorting.controller.SortingToolController;
import sorting.controller.SortingType;
import sorting.view.ConsolePrinter;

import java.util.Scanner;

/**
 * main class for the sorting tool.
 */
public class Main {
    public static void main(final String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ArgumentParser argumentParser = new ArgumentParser();
            argumentParser.parseArgs(args);

            DataType dataType = argumentParser.getDataType();
            SortingType sortingType = argumentParser.getSortingType();

            new SortingToolController(
                    dataType,
                    sortingType,
                    new ConsolePrinter(),
                    scanner)
                    .execute();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }
}