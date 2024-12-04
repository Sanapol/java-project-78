package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringSchemaTest {

    @Test
    void isValidTest() {
        Validator v = new Validator();

        StringSchema shema = v.string();

        v.required();

        var answer = v.isValid("object");
        System.out.println(answer);
        assertEquals(answer, true);
    }
}