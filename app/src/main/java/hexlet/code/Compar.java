package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Compar {

    public static List<Map<String, Object>> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());

        for (String key : keysSet) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("key", key);

            if (!map1.containsKey(key)) {
                map.put("value2", value2);
                map.put("status", "added");
            } else if (!map2.containsKey(key)) {
                map.put("value1", value1);
                map.put("status", "removed");
            } else if (!Objects.equals(value1, value2)) {
                map.put("value1", value1);
                map.put("value2", value2);
                map.put("status", "updated");
            } else {
                map.put("value", value1);
                map.put("status", "unchanged");
            }

            result.add(map);
        }

        return result;
    }
}
