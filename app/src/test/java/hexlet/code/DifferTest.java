package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static String json1;
    private static String json2;
    private static String yml1;
    private static String yml2;
    private static Path resultPlain;
    private static Path resultStylish;
    private static Path resultJson;

    @BeforeAll
    public static void init() {
        json1 = "src/test/resources/fixtures/file1.json";
        json2 = "src/test/resources/fixtures/file2.json";
        yml1 = "src/test/resources/fixtures/file1.yml";
        yml2 = "src/test/resources/fixtures/file2.yml";
        resultPlain = Paths.get("src/test/resources/fixtures/result_plain.txt").toAbsolutePath().normalize();
        resultStylish = Paths.get("src/test/resources/fixtures/result_stylish.txt").toAbsolutePath().normalize();
        resultJson = Paths.get("src/test/resources/fixtures/result_json.txt").toAbsolutePath().normalize();
    }

    public static String getExpected(Path path) throws Exception {
        return Files.readString(path);
    }

    public static String getWas(String file1, String file2, String format) throws Exception {
        if (format.isEmpty()) {
            return Differ.generate(file1, file2);
        } else {
            return Differ.generate(file1, file2, format);
        }
    }

    @Test
    public void generateJsonPlain() throws Exception {
        String expected = getExpected(resultPlain);
        String was = getWas(json1, json2, "plain");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlPlain() throws Exception {
        String expected = getExpected(resultPlain);
        String was = getWas(yml1, yml2, "plain");
        assertEquals(expected, was);
    }

    @Test
    public void generateJsonStylish() throws Exception {
        String expected = getExpected(resultStylish);
        String was = getWas(json1, json2, "stylish");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlStylish() throws Exception {
        String expected = getExpected(resultStylish);
        String was = getWas(yml1, yml2, "stylish");
        assertEquals(expected, was);
    }

    @Test
    public void generateJsonJson() throws Exception {
        String expected = getExpected(resultJson);
        String was = getWas(json1, json2, "json");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlJson() throws Exception {
        String expected = getExpected(resultJson);
        String was = getWas(yml1, yml2, "json");
        assertEquals(expected, was);
    }

    @Test
    public void generateJsonDefault() throws Exception {
        String expected = getExpected(resultStylish);
        String was = getWas(json1, json2, "");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlDefault() throws Exception {
        String expected = getExpected(resultStylish);
        String was = getWas(yml1, yml2, "");
        assertEquals(expected, was);
    }

}
