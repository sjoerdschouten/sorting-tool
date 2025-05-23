package sorting.controller;

import sorting.domain.Result;

/**
 * classes implementing InputEvaluator read the user input and calculate statistical information or sort.
 */
public interface InputEvaluator {
    /**
     * read the user input (via Scanner) and store internally.
     */
    void readUserInput();

    /**
     * @return statistical information as the implementation of the Statistics interface.
     */
    Result evaluate();
}
