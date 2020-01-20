class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        int res = 0;
        char sign = '+';
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                continue;
            }
            if (Character.isDigit(cur)) {
                num = 10 * num + (cur - '0');
            }
            if (!Character.isDigit(cur) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = cur;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;

    }
}