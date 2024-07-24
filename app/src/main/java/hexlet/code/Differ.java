package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = readFile(filepath1);
        String formatIn1 = getFileType(filepath1);
        String content2 = readFile(filepath2);
        String formatIn2 = getFileType(filepath2);

        Map<String, Object> map1 = Parser.parse(content1, formatIn1);
        Map<String, Object> map2 = Parser.parse(content2, formatIn2);

        List<Map<String, Object>> listComp = Compar.compareMaps(map1, map2);

        return Formatter.formStyle(listComp, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String readFile(String filepath) throws Exception {
        Path file1 = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(file1);
    }

    private static String getFileType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
}
