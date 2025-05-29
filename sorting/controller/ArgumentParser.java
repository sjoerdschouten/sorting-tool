package sorting.controller;

public class ArgumentParser {
    private DataType dataType = DataType.WORD; // Default.
    private SortingType sortingType = SortingType.NATURAL; // Default.

    public void parseArgs(String[] args) {
        // I think we can come up with better ways of handling this.
        // Check out BiConsumer
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
            } else {
                printUsage();
                throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }
    }

    public DataType getDataType() {
        return dataType;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public void printUsage() {
        System.out.println("Usage:");
        System.out.println("  -dataType <type>    Specify the data type (e.g., LONG, LINE, WORD, SORT_LONG)");
        System.out.println("  -sortingType <type> Specify the sorting type (e.g., NATURAL, BY_COUNT, etc.)");
    }
}
