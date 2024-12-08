package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.Map.Entry;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() throws RuntimeException {
        Predicate<Map<?, ?>> mapRequired = Objects::nonNull;

        predicates.put("A", mapRequired);
        return this;
    }

    public MapSchema sizeof(int number) throws RuntimeException {
        Predicate<Map<?, ?>> mapSizeof = map ->
                map.size() == number;

        predicates.put("B", mapSizeof);
        return this;
    }

    public <T> void shape(Map<?, BaseSchema<T>> rules) throws RuntimeException {
        Predicate<Map<?, ?>> mapShape = map -> {
            Set<? extends Entry<?, ?>> maps = map.entrySet();
            for (Entry<?, ?> setMap : maps) {
                if (rules.containsKey(setMap.getKey())) {
                    if (!rules.get(setMap.getKey()).isValid((T) setMap.getValue())) {
                        return false;
                    }
                }
            }
            return true;
        };
        Set<? extends Entry<?, BaseSchema<T>>> rule = rules.entrySet();
        for (Entry<?, BaseSchema<T>> set : rule) {
            predicates.put(set.getKey(), mapShape);
        }
    }
}
