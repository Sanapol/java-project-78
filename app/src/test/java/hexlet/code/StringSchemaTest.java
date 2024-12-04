package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringSchemaTest {

    @Test
    void isValidTest() {
        Validator v = new Validator();

        StringSchema shema = v.string();

        shema.required();
        shema.minLength(2);
        shema.contains("A");

        assertEquals(shema.isValid("Alex"), true);
        assertEquals(shema.isValid(""), false);
        assertEquals(shema.isValid(null), false);
        assertEquals(shema.isValid("Max"), false);
    }
}