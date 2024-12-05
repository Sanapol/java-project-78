package hexlet.code;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public void required() {
        Predicate<String> stringRequired = string ->
                string != null && !string.isEmpty();

        predicates.put(1, stringRequired);
    }

    public void minLength(int size) {
        Predicate<String> stringMinLength = string ->
                string.length() >= size;

        predicates.put(2, stringMinLength);
    }

    public void contains(String contain) {
        Predicate<String> stringContains = string ->
                string.contains(contain);

        predicates.put(3, stringContains);
    }
}
