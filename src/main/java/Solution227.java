import java.util.ArrayDeque;
import java.util.Deque;

public class Solution227 {
    public int calculate(String s) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(c = s.charAt(i))) {
                    int digit = c - '0';
                    num = num * 10 + digit;
                    i++;
                }
                i--;
                stack1.push(num);
            } else {
                if (stack2.isEmpty()) {
                    stack2.push(c);
                } else {
                    if (isHigher(c, stack2.peek())) {
                        stack2.push(c);
                    } else {
                        while (!stack2.isEmpty() && !isHigher(c, stack2.peek())) {
                            calculate(stack1, stack2);
                        }
                        stack2.push(c);
                    }
                }
            }
        }
        while (!stack2.isEmpty()) {
            calculate(stack1, stack2);
        }
        return stack1.pop();
    }

    private boolean isHigher(char cur, char top) {
        return (cur == '*' || cur == '/') && (top == '+' || top == '-');
    }

    private void calculate(Deque<Integer> stack1, Deque<Character> stack2) {
        Integer num2 = stack1.pop();
        Integer num1 = stack1.pop();
        Character option = stack2.pop();
        int result;
        switch (option) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        stack1.push(result);
    }
}
