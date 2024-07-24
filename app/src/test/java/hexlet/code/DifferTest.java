package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static final String DEFAULT_PATH = "src/test/resources/fixtures/";
    private static String json1;
    private static String json2;
    private static String yml1;
    private static String yml2;
    private static String expPlain;
    private static String expJson;
    private static String expStylish;

    @BeforeAll
    public static void init() throws Exception {
        json1 = DEFAULT_PATH + "file1.json";
        json2 = DEFAULT_PATH + "file2.json";
        yml1 = DEFAULT_PATH + "file1.yml";
        yml2 = DEFAULT_PATH + "file2.yml";
        Path resultPlain = Paths.get(DEFAULT_PATH + "result_plain.txt").toAbsolutePath().normalize();
        Path resultStylish = Paths.get(DEFAULT_PATH + "result_stylish.txt").toAbsolutePath().normalize();
        Path resultJson = Paths.get(DEFAULT_PATH + "result_json.txt").toAbsolutePath().normalize();
        expJson = getExpected(resultJson);
        expPlain = getExpected(resultPlain);
        expStylish = getExpected(resultStylish);
    }

    public static String getExpected(Path path) throws Exception {
        return Files.readString(path);
    }

    @Test
    public void generateJsonPlain() throws Exception {
        String was = Differ.generate(json1, json2, "plain");
        assertEquals(expPlain, was);
    }

    @Test
    public void generateYmlPlain() throws Exception {
        String was = Differ.generate(yml1, yml2, "plain");
        assertEquals(expPlain, was);
    }

    @Test
    public void generateJsonStylish() throws Exception {
        String was = Differ.generate(json1, json2, "stylish");
        assertEquals(expStylish, was);
    }

    @Test
    public void generateYmlStylish() throws Exception {
        String was = Differ.generate(yml1, yml2, "stylish");
        assertEquals(expStylish, was);
    }

    @Test
    public void generateJsonJson() throws Exception {
        String was = Differ.generate(json1, json2, "json");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode tree1 = mapper.readTree(expJson);
        JsonNode tree2 = mapper.readTree(was);

        assertEquals(tree2, tree1);
    }

    @Test
    public void generateYmlJson() throws Exception {
        String was = Differ.generate(yml1, yml2, "json");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode tree1 = mapper.readTree(expJson);
        JsonNode tree2 = mapper.readTree(was);

        assertEquals(tree2, tree1);
    }

    @Test
    public void generateJsonDefault() throws Exception {
        String was = Differ.generate(json1, json2);
        assertEquals(expStylish, was);
    }

    @Test
    public void generateYmlDefault() throws Exception {
        String was = Differ.generate(yml1, yml2);
        assertEquals(expStylish, was);
    }
}
