package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = readFile(filepath1);
        String content2 = readFile(filepath2);

        Map<String, Object> map1 = makeMap(content1);
        Map<String, Object> map2 = makeMap(content2);

        return compareMap(map1, map2);
    }

    public static String readFile(String filepath) throws Exception {
        Path file1 = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(file1)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }
        return Files.readString(file1);
    }

    public static Map<String, Object> makeMap(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }

    public static String compareMap(Map<String, Object> map1, Map<String, Object> map2) {
        String result = "{\n";
        TreeMap<String, Object> treeMapAll = new TreeMap<>(map1);
        //сначала делаем общий Мар, чтобы были все ключи в нем
        treeMapAll.putAll(map2);

        for (Map.Entry<String, Object> entry : treeMapAll.entrySet()) {
            String key = entry.getKey();
            boolean has1 = map1.containsKey(key);
            boolean has2 = map2.containsKey(key);
            if (has1 && has2) {
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                if (value1.equals(value2)) {
                    result += "    " + key + ": " + value1 + "\n";
                } else {
                    result += "  - " + key + ": " + value1 + "\n";
                    result += "  + " + key + ": " + value2 + "\n";
                }
            } else if (has1 && !has2) {
                Object value1 = map1.get(key);
                result += "  - " + key + ": " + value1 + "\n";
            }  else if (!has1 && has2) {
                Object value2 = map2.get(key);
                result += "  + " + key + ": " + value2 + "\n";
            }
        }
        result = result + "}";

        return result;
    }

}
