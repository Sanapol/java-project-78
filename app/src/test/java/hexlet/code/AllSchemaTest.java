package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AllSchemaTest {
    private Validator v;
    private StringSchema stringSchema;
    private NumberSchema numberSchema;
    private MapSchema mapSchema;

    @BeforeEach
    public void testPrepare() {
        v = new Validator();

        stringSchema = v.string();
        numberSchema = v.number();
        mapSchema = v.map();
    }

    @ParameterizedTest
    @CsvSource({"Max, Viktor", "Alex, x", "Mix,  "})
    void stringTest(String parameterTrue, String parameterFalse) {

        stringSchema.required().minLength(2).contains("t");
        stringSchema.contains("x");

        assertTrue(stringSchema.isValid(parameterTrue));
        assertFalse(stringSchema.isValid(parameterFalse));
    }

    @ParameterizedTest
    @CsvSource({"3,  ", "50, -1", "100, 101"})
    void numberTest(Integer parameterTrue, Integer parameterFalse) {

        numberSchema.required().positive().range(1, 3);
        numberSchema.range(0, 100);

        assertTrue(numberSchema.isValid(parameterTrue));
        assertFalse(numberSchema.isValid(parameterFalse));
    }

    @Test
    void mapShapeTest() {

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
