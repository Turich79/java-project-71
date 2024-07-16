package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        String content = readFile(filepath);
        String format = getFileType(filepath);
        return makeMap(content, format);
    }

    private static String readFile(String filepath) throws Exception {
        Path file1 = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(file1)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }
        return Files.readString(file1);
    }

    private static String getFileType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }

    private static Map<String, Object> makeMap(String content, String format) throws JsonProcessingException {
        ObjectMapper objectMapper = chooseFormat(format);
        return objectMapper.readValue(content, new TypeReference<>() { });
    }

    private static ObjectMapper chooseFormat(String format) {
        return "json".equals(format) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }

}
