package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() throws Exception {
        Predicate<String> stringRequired = string ->
                string != null && !string.isEmpty();

        predicates.put("A", stringRequired);
        return this;
    }

    public StringSchema minLength(int size) throws Exception {
        Predicate<String> stringMinLength = string ->
                string.length() >= size;

        predicates.put("B", stringMinLength);
        return this;
    }

    public StringSchema contains(String contain) throws Exception {
        Predicate<String> stringContains = string ->
                string.contains(contain);

        predicates.put("C", stringContains);
        return this;
    }
}
