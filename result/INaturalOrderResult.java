package sorting.result;

public interface INaturalOrderResult extends Result {
    /**
     * gets the amount of elements.
     *
     * @return the amount of input elements.
     */
    long getAmount();

    /**
     * gets the sorted elements in a string format.
     *
     * @return the sorted elements
     */
    String getSorted();
}
