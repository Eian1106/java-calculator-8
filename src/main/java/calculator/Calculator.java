package calculator;

public class Calculator {
    public static void run() {
        String userInput = Input.getUserInput();

        String text = Parser.getAdditionSubstring(userInput);

        Validator.validInput(text);

        String[] StringNumbers = Parser.splitDelimiter(text);
        Integer[] numbers = Parser.stringToInteger(StringNumbers);

        int result = Adder.sum(numbers);

        System.out.println("결과 : " + result);
    }


}
