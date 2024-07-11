package hexlet.code;

import org.junit.jupiter.api.Test;

//import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private final String path1 = "src/test/resources/file1.json";
    private final String path2 = "src/test/resources/file2.json";

    private final Path testFile1 = Paths.get("src/test/resources/expected/test1").toAbsolutePath().normalize();

    @Test
    public void test1() throws Exception {
//        String expected = Files.readString(testFile1);
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String was = Differ.generate(path1, path2, "");
//        System.out.println(expected);
//        System.out.println(was);
//        System.out.println(expected.equals(was.trim()));
        assertEquals(expected, was);
    }
}
