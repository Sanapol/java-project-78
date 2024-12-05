package hexlet.code;

import java.util.ArrayList;
import java.util.function.Predicate;


public class Validator {

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }
}
