package calculator;

import java.util.List;

public class Validator {
    public static void validInput(String text) {
        if (text.isBlank()){
            return;
        }

        List<String> delimiters = Parser.getDelimitersList();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isDigit(c)) {
                continue;
            }

            if (delimiters.contains(String.valueOf(c))) {
                continue;
            }

            throw new IllegalArgumentException("잘못된 값을 입력했습니다");
        }
    }
}
