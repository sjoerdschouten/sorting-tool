package sorting.domain;

public enum DataType {
    LONG("long", "numbers"),
    LINE("line", "lines"),
    WORD("word", "words");

    private final String value;
    private final String printName;

    DataType(String value, String printName) {
        this.value = value;
        this.printName = printName;

    }

    public static DataType fromString(String value) {
        for (DataType type : DataType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not a recognized dataType.");
    }

    public String getValue() {
        return value;
    }

    public String getPrintName() {
        return printName;
    }
}
