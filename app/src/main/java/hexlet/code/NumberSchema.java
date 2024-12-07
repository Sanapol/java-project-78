package hexlet.code;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        Predicate<Integer> numberRequired = Objects::nonNull;

        predicates.put("A", numberRequired);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> numberPositive = number ->
                number > 0;

        predicates.put("B", numberPositive);
        return this;
    }

    public NumberSchema range(int number1, int number2) {
        Predicate<Integer> numberRange = number ->
                number1 <= number && number <= number2;

        predicates.put("C", numberRange);
        return this;
    }
}
