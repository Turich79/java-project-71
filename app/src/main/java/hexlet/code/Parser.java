package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String format) throws JsonProcessingException {
        return makeMap(content, format);
    }

    private static Map<String, Object> makeMap(String content, String format) throws JsonProcessingException {
        ObjectMapper objectMapper = chooseFormat(format);
        return objectMapper.readValue(content, new TypeReference<>() { });
    }

    private static ObjectMapper chooseFormat(String format) {
        return "json".equals(format) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }

}
