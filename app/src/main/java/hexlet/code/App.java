package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.13",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Parameters(paramLabel = "filepath1",
            description = "path to first file")
    private String filepath1;
    @Parameters(paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;

//    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
//    private boolean helpRequested = false;
//
//    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
//    private boolean versionRequested = false;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format stylish, plain, json, no-format [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return null;
    }
}
