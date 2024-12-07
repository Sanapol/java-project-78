package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() throws Exception {
        Predicate<Map<?, ?>> mapRequired = Objects::nonNull;

        predicates.put("A", mapRequired);
        return this;
    }

    public MapSchema sizeof(int number) throws Exception {
        Predicate<Map<?, ?>> mapSizeof = map ->
                map.size() == number;

        predicates.put("B", mapSizeof);
        return this;
    }

    public <T> void shape(Map<?, BaseSchema<T>> rules) throws Exception {
        Predicate<Map<?, ?>> mapShape = map -> {
            Set<? extends java.util.Map.Entry<?, ?>> maps = map.entrySet();
            for (Map.Entry<?, ?> setMap : maps) {
                if (rules.containsKey(setMap.getKey())) {
                    try {
                        if (!rules.get(setMap.getKey()).isValid((T) setMap.getValue())) {
                            return false;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
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
