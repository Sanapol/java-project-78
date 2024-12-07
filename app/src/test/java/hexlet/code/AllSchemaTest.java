package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AllSchemaTest {

    @Test
    void stringTest() {
        Validator v = new Validator();

        StringSchema schema = v.string();

        schema.required();
        schema.minLength(2);
        assertTrue(schema.isValid("Go"));

        schema.contains("x");
        assertTrue(schema.isValid("Max"));

        schema.minLength(4).contains("A");

        assertTrue(schema.isValid("Alex"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("Max"));
    }

    @Test
    void numberTest() {
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
    void mapTest() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));

        schema.sizeof(2);
        schema.required();

        assertFalse(schema.isValid(null));

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        assertFalse(schema.isValid(map));

        map.put("key2", "value2");

        assertTrue(schema.isValid(map));
    }

    @Test
    void mapShapeStringTest() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", v.string().required().contains("o"));

        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "S");
        assertFalse(schema.isValid(human1));
    }

    @Test
    void mapShapeNumberTest() {
        Validator v = new Validator();

        MapSchema schema = v.map().required().sizeof(3);

        Map<Integer, BaseSchema<Integer>> schemas = new HashMap<>();

        schemas.put(6, v.number().required());
        schemas.put(7, v.number().required().positive());
        schemas.put(8, v.number().required().range(5, 20));

        schema.shape(schemas);

        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(6, 8);
        numbers.put(7, 9);
        numbers.put(8, 21);
        assertFalse(schema.isValid(numbers));
    }
}
