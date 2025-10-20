package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String getUserInput(){
        inputPrompt();
        return Console.readLine();
    }

    public static void inputPrompt(){
        System.out.println(INPUT_PROMPT_MESSAGE);
    }
}
