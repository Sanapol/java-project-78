package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<Object, Predicate<T>> predicates = new HashMap<>();

    public boolean isValid(T value) {
        Set<Map.Entry<Object, Predicate<T>>> predicate = predicates.entrySet();

        for (Map.Entry<Object, Predicate<T>> test : predicate) {
            if (!test.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }
}
