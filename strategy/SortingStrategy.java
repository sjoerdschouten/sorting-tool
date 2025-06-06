package sorting.strategy;

import sorting.domain.DataType;
import sorting.result.Result;

import java.util.List;

public interface SortingStrategy<T> {
    Result sort(List<T> list, DataType dataType);
}
