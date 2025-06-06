package sorting.domain;

public enum SortingType {
    NATURAL("natural"),
    BY_COUNT("byCount");

    private final String value;

    SortingType(String value) {
        this.value = value;
    }

    public static SortingType fromString(String value) {
        for (SortingType type : SortingType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not a valid sorting type.");
    }
}
