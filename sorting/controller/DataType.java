package sorting.controller;

public enum DataType {
    LONG("long"), LINE("line"), WORD("word"), SORT_LONG("sortIntegers");

    private final String value;

    DataType(String value) {
        this.value = value;
    }

    public static DataType fromString(String value) {
        for (DataType type : DataType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not a recognized dataType.");
    }
}
