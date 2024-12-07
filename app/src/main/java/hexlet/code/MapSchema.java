package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        Predicate<Map<?, ?>> mapRequired = Objects::nonNull;

        predicates.put("A", mapRequired);
        return this;
    }

    public MapSchema sizeof(int number) {
        Predicate<Map<?, ?>> mapSizeof = map ->
                map.size() == number;

        predicates.put("B", mapSizeof);
        return this;
    }

    public <T> void shape(Map<?, BaseSchema<T>> rules) {
        Predicate<Map<?, ?>> mapShape = map -> {
            Set<? extends java.util.Map.Entry<?, ?>> maps = map.entrySet();
            for (Map.Entry<?, ?> setMap : maps) {
                if (rules.containsKey(setMap.getKey())) {
                    if (!rules.get(setMap.getKey()).isValid((T) setMap.getValue())) {
                        return false;
                    }
                }
            }
            return true;
        };
        Set<? extends Map.Entry<?, BaseSchema<T>>> rule = rules.entrySet();
        for (Map.Entry<?, BaseSchema<T>> set : rule) {
            predicates.put(set.getKey(), mapShape);
        }
    }
}
