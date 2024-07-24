package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String format) throws Exception {
        return makeMap(content, format);
    }

    private static Map<String, Object> makeMap(String content, String format) throws Exception {
        ObjectMapper objectMapper = chooseFormat(format);
        return objectMapper.readValue(content, new TypeReference<>() { });
    }

    private static ObjectMapper chooseFormat(String format) throws Exception {
        return switch (format) {
            case "json" -> new ObjectMapper();
            case "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new Exception("Format" + format + "is not correct!");
        };
    }
}
