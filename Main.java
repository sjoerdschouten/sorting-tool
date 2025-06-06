package sorting;

import sorting.domain.DataType;
import sorting.domain.SortingType;
import sorting.input.ArgumentParser;
import sorting.input.Reader;
import sorting.result.Result;
import sorting.sorter.Sorter;
import sorting.strategy.CountSortStrategy;
import sorting.strategy.NaturalOrderStrategy;
import sorting.strategy.SortingStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * main class for the sorting tool.
 */
public class Main {
    public static void main(final String[] args) {
        ArgumentParser argumentParser = new ArgumentParser();
        try {
            argumentParser.parseArgs(args);
            DataType dataType = argumentParser.getDataType();
            SortingType sortingType = argumentParser.getSortingType();
            List<?> toSort = readInput(argumentParser);
            Result result = sortData(toSort, sortingType, dataType);
            writeOutput(argumentParser, result);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }

    private static List<?> readInput(ArgumentParser argumentParser) throws FileNotFoundException {
        Scanner scanner = argumentParser.isReadFromFile() ? new Scanner(new File(argumentParser.getReadPath())) : new Scanner(System.in);
        List<?> toSort;

        switch (argumentParser.getDataType()) {
            case LONG -> {
                toSort = Reader.readInput(scanner, DataType.LONG);
                break;
            }
            case LINE, WORD -> {
                toSort = Reader.readInput(scanner, argumentParser.getDataType());
                break;
            }
            default -> throw new IllegalArgumentException("Unsupported data type: " + argumentParser.getDataType());
        }
        return toSort;
    }

    private static void writeOutput(ArgumentParser argumentParser, Result result) throws IOException {
        if (argumentParser.isWriteToFile()) {
            try (FileWriter writer = new FileWriter(argumentParser.getWritePath())) {
                writer.write(result.getResult());
            }
        } else {
            System.out.println(result.getResult());
        }
    }

    private static <T extends Comparable<T>> Result sortData(List<?> toSort, SortingType sortingType, DataType dataType) {
        Sorter<T> sorter = new Sorter<>();
        SortingStrategy<T> sortingStrategy = createSortingStrategy(sortingType);
        sorter.setSortingStrategy(sortingStrategy);
        // unchecked cast here.
        return sorter.sort((List<T>) toSort, dataType);
    }

    private static <T extends Comparable<T>> SortingStrategy<T> createSortingStrategy(SortingType sortingType) {
        return (sortingType == SortingType.NATURAL) ? new NaturalOrderStrategy<>() : new CountSortStrategy<T>();
    }
}