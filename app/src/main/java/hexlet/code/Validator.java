package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    public final StringSchema string() throws RuntimeException {
        try {
            return new StringSchema();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public final NumberSchema number() throws RuntimeException {
        try {
            return new NumberSchema();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public final MapSchema map() throws RuntimeException {
        try {
            return new MapSchema();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
