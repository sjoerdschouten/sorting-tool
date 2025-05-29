package sorting.domain.statistic;

import sorting.domain.result.Result;

import java.util.Map;

public interface Statistics extends Result {

    /**
     * get the amount
     * @return amount of input elements
     */
    long getAmount();
//
//    long getMaxOccurrences();
//
//    default long calcMaxPercentage() {
//        return 100 * getMaxOccurrences() / getAmount();
//    }

}
