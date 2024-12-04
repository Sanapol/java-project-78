package hexlet.code;

import java.util.ArrayList;
import java.util.function.Predicate;

public class StringSchema extends Validator {

    public void required() {
        Predicate<String> stringRequired = string ->
                string != null || !string.isEmpty();

        predicates.add(stringRequired);
    }

    public void minLength(int size) {
        Predicate<String> stringMinLength = string ->
                string.length() >= size;

        predicates.add(stringMinLength);
    }

    public void contains(String contain) {
        Predicate<String> stringContains = string ->
                string.contains(contain);

        predicates.add(stringContains);
    }
}
