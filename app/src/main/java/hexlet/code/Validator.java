package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Validator <T> {
    protected ArrayList<Predicate<T>> predicates = new ArrayList<>();

    public boolean isValid(T value) {

        for (var predicate : predicates) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    }

    public StringSchema string() {
        return new StringSchema();
    }
}
