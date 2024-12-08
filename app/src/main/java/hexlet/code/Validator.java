package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public final class Validator {

    public StringSchema string() throws RuntimeException {
            return new StringSchema();
    }

    public NumberSchema number() throws RuntimeException {
            return new NumberSchema();
    }

    public MapSchema map() throws RuntimeException {
            return new MapSchema();
    }
}
