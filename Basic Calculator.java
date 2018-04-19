public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == ' ') {
                continue;
            } else if (Character.isDigit(cur)) {
                number = number * 10 + cur - '0';
            } else if (cur == '+') {
                result += number * sign;
                sign = 1;
                number = 0;
            } else if (cur == '-') {
                result += number * sign;
                sign = -1;
                number = 0;
            } else if (cur == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                number = 0;
            } else if (cur == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }

        }

        if (number != 0) result += sign * number;
        return result;
    }
}