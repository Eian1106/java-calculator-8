package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String DEFAULT_CUSTOM_DELIMITERS_TEXT = "//;\\n";
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final List<String> delimiters = new ArrayList<>(List.of(DEFAULT_DELIMITERS));

    public static boolean hasCustomDelimiter(String text) {
        boolean start = text.regionMatches(0, DEFAULT_CUSTOM_DELIMITERS_TEXT, 0, 2);
        boolean end = text.regionMatches(3, DEFAULT_CUSTOM_DELIMITERS_TEXT, 3, 2);

        return start && end;
    }
}
