package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() throws Exception {
        Predicate<Integer> numberRequired = Objects::nonNull;

        predicates.put("A", numberRequired);
        return this;
    }

    public NumberSchema positive() throws Exception {
        Predicate<Integer> numberPositive = number ->
                number != null || number > 0;

        predicates.put("B", numberPositive);
        return this;
    }

    public NumberSchema range(int number1, int number2) throws Exception {
        Predicate<Integer> numberRange = number ->
                number != null || number1 <= number && number <= number2;

        predicates.put("C", numberRange);
        return this;
    }
}
