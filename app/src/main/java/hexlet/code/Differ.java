package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {


        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);

        List<Map<String, Object>> listComp = compareMaps(map1, map2);

        return Formatter.formStyle(listComp, format);

    }

    private static List<Map<String, Object>> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());

        for (String key : keysSet) {
            boolean has1 = map1.containsKey(key);
            boolean has2 = map2.containsKey(key);
            Map<String, Object> map = new LinkedHashMap<>();
            if (has1 && has2) {
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                if (!Objects.equals(value1, value2)) {
                    map.put("key", key);
                    map.put("oldValue", returnValue(value1));
                    map.put("newValue", returnValue(value2));
                    map.put("status", "updated");
                } else {
                    map.put("key", key);
                    map.put("oldValue", returnValue(value1));
                    map.put("status", "unchanged");
                }
            } else if (has1 && !has2) {
                Object value1 = map1.get(key);
                map.put("key", key);
                map.put("oldValue", returnValue(value1));
                map.put("status", "removed");
            } else if (!has1 && has2) {
                Object value2 = map2.get(key);
                map.put("key", key);
                map.put("newValue", returnValue(value2));
                map.put("status", "added");
            }
            result.add(map);
        }

        return result;
    }

    private static Object returnValue(Object value) {
        return value == null ? "null" : value.toString();
    }
}
