package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        Predicate<String> stringRequired = string ->
                string != null && !string.isEmpty();

        predicates.put("A", stringRequired);
        return this;
    }

    public StringSchema minLength(int size) {
        Predicate<String> stringMinLength = string ->
                string.length() >= size;

        predicates.put("B", stringMinLength);
        return this;
    }

    public StringSchema contains(String contain) {
        Predicate<String> stringContains = string ->
                string.contains(contain);

        predicates.put("C", stringContains);
        return this;
    }
}
