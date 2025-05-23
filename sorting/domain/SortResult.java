package sorting.domain;

/**
 * SortResult interface, that is implements for different modes (long, line, word, ...).
 * These objects are produced by the Sorter (InputEvaluator) implementations.
 */
public interface SortResult extends Result {

    /**
     * gets the amount of elements.
     * @return the amount of input elements.
     */
    long getAmount();

    /**
     * gets the sorted elements in a string format.
     * @return the sorted elements
     */
    String getSorted();
}
