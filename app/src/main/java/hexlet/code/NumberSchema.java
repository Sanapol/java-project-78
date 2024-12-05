package hexlet.code;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public void required() {
        Predicate<Integer> numberRequired = Objects::nonNull;

        predicates.put(1, numberRequired);
    }

    public void positive() {
        Predicate<Integer> numberPositive = number ->
                number > 0;

        predicates.put(2, numberPositive);
    }

    public void range(int number1, int number2) {
        Predicate<Integer> numberRange = number ->
                number1 <= number && number <= number2;

        predicates.put(3, numberRange);
    }
}
