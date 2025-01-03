package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() throws RuntimeException {
        Predicate<String> stringRequired = string ->
                string != null && !string.isEmpty();

        predicates.put("A", stringRequired);
        return this;
    }

    public StringSchema minLength(int size) throws RuntimeException {
        Predicate<String> stringMinLength = string ->
                string.length() >= size;

        predicates.put("B", stringMinLength);
        return this;
    }

    public StringSchema contains(String contain) throws RuntimeException {
        Predicate<String> stringContains = string ->
                string.contains(contain);

        predicates.put("C", stringContains);
        return this;
    }
}
