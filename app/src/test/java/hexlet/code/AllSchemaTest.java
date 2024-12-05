package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AllSchemaTest {

    @Test
    void StringTest() {
        Validator v = new Validator();

        StringSchema schema = v.string();

        schema.required();
        schema.minLength(2);
        assertTrue(schema.isValid("Go"));

        schema.contains("x");
        assertTrue(schema.isValid("Max"));

        schema.minLength(4);
        schema.contains("A");

        assertTrue(schema.isValid("Alex"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("Max"));
    }

    @Test
    void NumbreTest() {
        Validator v = new Validator();

        NumberSchema schema = v.number();

        schema.required();
        assertTrue(schema.isValid(-200));

        schema.positive();
        assertTrue(schema.isValid(200));

        schema.range(2, 100);
        assertTrue(schema.isValid(40));

        assertFalse(schema.isValid(101));
        assertFalse(schema.isValid(-20));
        assertFalse(schema.isValid(1));
        assertFalse(schema.isValid(null));

    }

    @Test
    void MapTest() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));

        schema.sizeof(2);

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        assertFalse(schema.isValid(map));

        map.put("key2", "value2");

        assertTrue(schema.isValid(map));
    }
}
