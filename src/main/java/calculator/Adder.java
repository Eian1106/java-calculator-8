package calculator;

public class Adder {
    public static int sum(Integer[] nums) {
        int sum = 0;

        for (Integer num : nums) {
            sum += num;
        }

        return sum;
    }
}
