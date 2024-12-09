package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AllSchemaTest {
    final String nul = null;
    Validator v;
    StringSchema stringSchema;
    NumberSchema numberSchema;
    MapSchema mapSchema;

    @BeforeEach
    public void testPrepare() {
        v = new Validator();

        stringSchema = v.string();
        numberSchema = v.number();
        mapSchema = v.map();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Max", "Alex", "X"})
    void stringTest(String parameter) {

        assertTrue(stringSchema.isValid(parameter));

        stringSchema.required().minLength(2).contains("x");
        stringSchema.contains("Z");

        assertFalse(stringSchema.isValid(parameter));
        assertTrue(stringSchema.isValid("Zed"));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {1, -200, -50})
    void numberTest(Integer parameter) {

        assertTrue(numberSchema.isValid(parameter));

        numberSchema.required().positive().range(2, 3);
        numberSchema.range(2, 100);

        assertFalse(numberSchema.isValid(parameter));
        assertTrue(numberSchema.isValid(30));

    }

    @Test
    void mapTest() {

        mapSchema.sizeof(2).required();

        assertFalse(mapSchema.isValid(null));

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");

        assertFalse(mapSchema.isValid(map));

        map.put("key2", "value2");

        assertTrue(mapSchema.isValid(map));
    }

    @Test
    void mapShapeStringTest() {

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required().contains("o"));
        schemas.put("lastName", v.string().required().minLength(2));

        mapSchema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "S");

        assertFalse(mapSchema.isValid(human1));
    }

    @Test
    void mapShapeNumberTest() {

        mapSchema = v.map().required().sizeof(3);

        Map<Integer, BaseSchema<Integer>> schemas = new HashMap<>();
        schemas.put(6, v.number().required());
        schemas.put(7, v.number().required().positive());
        schemas.put(8, v.number().required().range(5, 20));

        mapSchema.shape(schemas);

        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(6, 8);
        numbers.put(7, 9);
        numbers.put(8, 21);

        assertFalse(mapSchema.isValid(numbers));
    }
}
