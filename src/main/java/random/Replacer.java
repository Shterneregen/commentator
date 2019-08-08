package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Replacer {

    private Replacer() {
    }

    static String commentText(String text, String firstComment, String lastComment, String delimiter) {
        String[] linesA = text.split("\\r?\\n");
        List<String> lines = new ArrayList<>(Arrays.asList(linesA));
        lines = lines.stream()
                .filter(l -> !l.isEmpty())
                .map(l -> commentLine(l, firstComment, lastComment))
                .collect(Collectors.toList());
        return String.join(delimiter, lines);
    }

    private static String commentLine(String line, String firstComment, String lastComment) {
        StringBuilder result = new StringBuilder();
        result.append(firstComment).append(line);
        if (!lastComment.isEmpty()) {
            result.append(lastComment);
        }
        return result.toString();
    }
}
