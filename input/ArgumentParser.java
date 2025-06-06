package sorting.input;

import sorting.domain.DataType;
import sorting.domain.SortingType;

public class ArgumentParser {
    private DataType dataType = DataType.WORD; // Default.
    private SortingType sortingType = SortingType.NATURAL;
    private boolean readFromFile = false;
    private boolean writeToFile = false;
    private String writePath = "";
    private String readPath = "";

    // todo: I think we can refactor this and let the class return an object that holds the entire configuration.

    public void parseArgs(String[] args) {
        if (args.length == 0) {
            printUsage();
            throw new IllegalArgumentException("No arguments provided. Use -dataType <type> and -sortingType <type>.");
        }
        for (int i = 0; i < args.length; i++) {
            if ("-dataType".equals(args[i]) && i + 1 < args.length) {
                try {
                    dataType = DataType.fromString(args[i + 1]);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid data type: " + args[i + 1], e);
                }

                i++; // skip next arg
            } else if ("-sortingType".equals(args[i]) && i + 1 < args.length) {
                try {
                    sortingType = SortingType.fromString(args[i + 1]);
                    // todo: numbers can't have sortingType natural.
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid sorting type: " + args[i + 1], e);
                }
                i++; // skip next arg
            } else if ("-inputFile".equals(args[i]) && i + 1 < args.length) {
                readFromFile = true;
                readPath = args[i + 1];
                i++;
            } else if ("-outputFile".equals(args[i]) && i + 1 < args.length) {
                writeToFile = true;
                writePath = args[i+1];
                i++;

            } else {
                printUsage();
                throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }
    }

    public boolean isReadFromFile() {
        return readFromFile;
    }

    public boolean isWriteToFile() {
        return writeToFile;
    }

    public DataType getDataType() {
        return dataType;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public void printUsage() {
        System.out.println("Usage:");
        System.out.println("  -dataType <type>    Specify the data type (e.g., LONG, LINE, WORD)");
        System.out.println("  -sortingType <type> Specify the sorting type (e.g., NATURAL, BY_COUNT, etc.)");
    }

    public String getWritePath() {
        return writePath;
    }

    public String getReadPath() {
        return readPath;
    }
}
