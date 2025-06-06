package sorting.sorter;

import sorting.domain.DataType;
import sorting.result.Result;
import sorting.strategy.SortingStrategy;

import java.util.List;

public class Sorter<T> {

    private SortingStrategy<T> sortingStrategy;

    public void setSortingStrategy(SortingStrategy<T> strategy) {
        this.sortingStrategy = strategy;
    }

    public Result sort(List<T> list, DataType dataType) {
        return sortingStrategy.sort(list, dataType);
    }
}
