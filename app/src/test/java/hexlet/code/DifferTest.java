package hexlet.code;

import org.junit.jupiter.api.Test;

//import java.nio.file.Files;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private final String path1 = "src/test/resources/file1.json";
    private final String path2 = "src/test/resources/file2.json";
    private final String pathJson1 = "src/test/resources/file1_.json";
    private final String pathJson2 = "src/test/resources/file2_.json";
    private final String pathYml1 = "src/test/resources/file1.yml";
    private final String pathYml2 = "src/test/resources/file2.yml";

//    private final Path testFile1 = Paths.get("src/test/resources/expected/test1").toAbsolutePath().normalize();
    private final Path testFileJson = Paths.get("src/test/resources/expected/testJson.txt").toAbsolutePath().normalize();
    private final Path testFilePlain = Paths.get("src/test/resources/expected/testPlain.txt").toAbsolutePath().normalize();
    private final Path testFileStylish = Paths.get("src/test/resources/expected/testStylish.txt").toAbsolutePath().normalize();

    @Test
    public void generateJsonStylishOld() throws Exception {
//        String expected = Files.readString(testFile1);
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String was = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, was);
    }

    @Test
    public void generateJsonPlain() throws Exception {
        String expected = Files.readString(testFilePlain);
        String was = Differ.generate(pathJson1, pathJson2, "plain");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlPlain() throws Exception {
        String expected = Files.readString(testFilePlain);
        String was = Differ.generate(pathYml1, pathYml2, "plain");
        assertEquals(expected, was);
    }

    @Test
    public void generateJsonJson() throws Exception {
        String expected = Files.readString(testFileJson);
        String was = Differ.generate(pathJson1, pathJson2, "json");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlJson() throws Exception {
        String expected = Files.readString(testFileJson);
        String was = Differ.generate(pathYml1, pathYml2, "json");
        assertEquals(expected, was);
    }

    @Test
    public void generateJsonStylish() throws Exception {
        String expected = Files.readString(testFileStylish);
        String was = Differ.generate(pathJson1, pathJson2, "stylish");
        assertEquals(expected, was);
    }

    @Test
    public void generateYmlStylish() throws Exception {
        String expected = Files.readString(testFileStylish);
        String was = Differ.generate(pathYml1, pathYml2, "stylish");
        assertEquals(expected, was);
    }


}
