package sorting.input;

import sorting.domain.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Reader {


    public static <T> List<T> readInput(Scanner scanner, DataType dataType) {
        Function<Scanner, T> inputFunction = getInputFunction(dataType);
        List<T> list = new ArrayList<>();

        while (scanner.hasNext()) {
            T value = inputFunction.apply(scanner);
            list.add(value);
        }
        return list;
    }

    private static <T> Function<Scanner, T> getInputFunction(DataType dataType) {
        return switch (dataType) {
            // Unfortunately we need to cast here
            case LONG -> (Function<Scanner, T>) (Function<Scanner, Long>) Scanner::nextLong;
            case LINE -> (Function<Scanner, T>) (Function<Scanner, String>) Scanner::nextLine;
            case WORD -> (Function<Scanner, T>) (Function<Scanner, String>) Scanner::next;
            default -> throw new IllegalArgumentException("Unsupported data type" + dataType);
        };
    }
}
