package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formStyle(List<Map<String, Object>> listComp, String format) throws IOException {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(listComp);
            case "plain":
                return Plain.formatPlain(listComp);
            case "json":
                return Json.formatJson(listComp);
            default:
                System.out.println("Format" + format + "is not correct!");
        }
        return Stylish.formatStylish(listComp);
    }
}
