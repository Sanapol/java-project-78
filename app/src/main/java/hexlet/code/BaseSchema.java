package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<Integer, Predicate<T>> predicates = new HashMap<>();

    public boolean isValid(T value) {
        var predicate = predicates.entrySet();

        for (var test : predicate) {
            if (!test.getValue().test(value)) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        return predicates.toString();
    }
}
