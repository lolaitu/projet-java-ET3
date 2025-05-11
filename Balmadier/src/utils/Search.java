package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Search {
    public static <T, U> List<T> inList(List<T> inputs, Function<T, U> getter, U searchValue) {
        List<T> results = new ArrayList<>();
        for (T item : inputs) {
            U value = getter.apply(item);
            if ((value != null && value.equals(searchValue)) ||
                    (value == null && searchValue == null)) {
                results.add(item);
            }
        }
        return results;
    }
}