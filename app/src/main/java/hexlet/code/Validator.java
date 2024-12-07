package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    public StringSchema string() throws Exception {
        try {
            return new StringSchema();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public NumberSchema number() throws Exception {
        try {
            return new NumberSchema();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public MapSchema map() throws Exception{
        try {
            return new MapSchema();
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
