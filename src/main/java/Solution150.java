import java.util.ArrayDeque;
import java.util.Deque;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!isOption(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = calculate(num1, num2, token);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isOption(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int calculate(int num1, int num2, String option) {
        switch (option) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
