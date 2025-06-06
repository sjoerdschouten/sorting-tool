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

    public void parseArgs(String[] args) {
        if (args.length == 0) {
            printUsage();
            throw new IllegalArgumentException("No arguments provided. Use -dataType <type> and -sortingType <type>.");
        }

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-dataType":
                    dataType = parseDataType(args, i);
                    i++; // skip next arg
                    break;
                case "-sortingType":
                    sortingType = parseSortingType(args, i);
                    i++; // skip next arg
                    break;
                case "-inputFile":
                    readFromFile = true;
                    readPath = parseFilePath(args, i);
                    i++; // skip next arg
                    break;
                case "-outputFile":
                    writeToFile = true;
                    writePath = parseFilePath(args, i);
                    i++; // skip next arg
                    break;
                default:
                    printUsage();
                    throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }
    }

    private DataType parseDataType(String[] args, int index) {
        if (index + 1 >= args.length) {
            throw new IllegalArgumentException("Missing value for -dataType");
        }
        try {
            return DataType.fromString(args[index + 1]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid data type: " + args[index + 1], e);
        }
    }

    private SortingType parseSortingType(String[] args, int index) {
        if (index + 1 >= args.length) {
            throw new IllegalArgumentException("Missing value for -sortingType");
        }
        try {
            return SortingType.fromString(args[index + 1]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid sorting type: " + args[index + 1], e);
        }
    }

    private String parseFilePath(String[] args, int index) {
        if (index + 1 >= args.length) {
            throw new IllegalArgumentException("Missing value for file path");
        }
        return args[index + 1];
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
        System.out.println("  -inputFile <path>   Specify the input file path");
        System.out.println("  -outputFile <path>  Specify the output file path");
        System.out.println("Examples:");
        System.out.println("  java Main -dataType LONG -sortingType NATURAL -inputFile data.txt -outputFile result.txt");
    }

    public String getWritePath() {
        return writePath;
    }

    public String getReadPath() {
        return readPath;
    }
}
