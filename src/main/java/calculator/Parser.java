package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String CUSTOM_DELIMITERS_PREFIX = "//";
    private static final String DEFAULT_CUSTOM_DELIMITERS_TEXT = "//;\\n";
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final List<String> delimiters = new ArrayList<>(List.of(DEFAULT_DELIMITERS));

    public static boolean hasCustomDelimiter(String text) {
        boolean start = text.regionMatches(0, DEFAULT_CUSTOM_DELIMITERS_TEXT, 0, 2);
        boolean end = text.regionMatches(3, DEFAULT_CUSTOM_DELIMITERS_TEXT, 3, 2);

        return start && end;
    }

    public static String getAdditionSubstring(String text) {
        if (hasCustomDelimiter(text)) {
            extractCustomDelimiter(text);
            return text.substring(DEFAULT_CUSTOM_DELIMITERS_TEXT.length());
        }

        return text;
    }

    private static void extractCustomDelimiter(String text) {
        addDelimiter(String.valueOf(text.charAt(CUSTOM_DELIMITERS_PREFIX.length())));
    }

    public static void addDelimiter(String text) {
        delimiters.add(text);
    }

    public static List<String> getDelimitersList(){
        return List.copyOf(delimiters);
    }

    public static String[] splitDelimiter(String text) {
        StringBuilder delimitersRegex = new StringBuilder();
        delimitersRegex.append("[");
        for (String delimiter : delimiters) {
            delimitersRegex.append(delimiter);
        }
        delimitersRegex.append("]");
        return text.split(delimitersRegex.toString());
    }

    public static Integer[] stringToInteger(String[] strArr) {
        if (strArr == null) {
            return new Integer[0];
        }

        return Arrays.stream(strArr)
                .map(s -> {
                    String trimmed = s.trim();
                    return trimmed.isEmpty() ? "0" : trimmed;
                })
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
    }
}
