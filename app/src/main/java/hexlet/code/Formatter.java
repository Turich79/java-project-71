package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formStyle(List<Map<String, Object>> listComp, String format) throws Exception {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(listComp);
            case "plain":
                return Plain.formatPlain(listComp);
            case "json":
                return Json.formatJson(listComp);
            default:
                throw new Exception("Format" + format + "is not correct!");
        }
    }
}
