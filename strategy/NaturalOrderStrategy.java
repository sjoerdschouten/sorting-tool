package sorting.strategy;

import sorting.domain.DataType;
import sorting.result.NaturalOrderResult;
import sorting.result.Result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NaturalOrderStrategy<T extends Comparable<T>> implements SortingStrategy<T> {

    @Override
    public Result sort(List<T> list, DataType dataType) {
        Collections.sort(list);
        return new NaturalOrderResult(
                list.size(),
                list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")),
                dataType
        );
    }
}
