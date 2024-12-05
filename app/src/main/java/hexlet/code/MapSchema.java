package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map> {

    public void required() {
        Predicate<Map> mapRequired = Objects::nonNull;

        predicates.put(1, mapRequired);
    }

    public void sizeof(int number) {
        Predicate<Map> mapSizeof = map ->
                map.size() == number;

        predicates.put(2, mapSizeof);
    }
}
