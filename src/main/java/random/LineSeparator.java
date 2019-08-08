package random;

import java.util.Arrays;

public enum LineSeparator {

    CURRENT("Current system separator", System.lineSeparator()),
    WINDOWS("Windows separator", "\r\n"),
    LINUX("Linux separator", "\n");

    private String name;
    private String separator;

    public String getName() {
        return name;
    }

    public String getSeparator() {
        return separator;
    }

    LineSeparator(String name, String separator) {
        this.name = name;
        this.separator = separator;
    }

    public static String getSeparatorByName(String name) {
        return Arrays.stream(LineSeparator.values())
                .filter(ls -> ls.getName().equals(name))
                .findFirst()
                .orElse(CURRENT).getSeparator();
    }
}
