package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringSchemaTest {

    @Test
    void StringTest() {
        Validator v = new Validator();

        StringSchema shema = v.string();

        shema.required();
        shema.minLength(2);
        shema.contains("A");
        shema.minLength(4);
        shema.contains("x");

        assertTrue(shema.isValid("Alex"));
        assertFalse(shema.isValid(""));
        assertFalse(shema.isValid(null));
        assertFalse(shema.isValid("Max"));
    }

    @Test
    void NumbreTest() {
        Validator v = new Validator();

        NumberSchema shema = v.number();

        shema.required();
        assertTrue(shema.isValid(-200));

        shema.positive();
        assertTrue(shema.isValid(200));

        shema.range(2, 100);
        assertTrue(shema.isValid(40));

        assertFalse(shema.isValid(101));
        assertFalse(shema.isValid(-20));
        assertFalse(shema.isValid(1));
        assertFalse(shema.isValid(null));

    }
}