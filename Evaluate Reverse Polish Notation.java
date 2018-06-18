class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else if (token.equals("*")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 * op2);
            } else if (token.equals("+")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 + op2);
            } else if (token.equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            }
        }
        
        return stack.pop();
    }

    private boolean isInteger(String token) {
        return token.matches("-?\\d+");
    }


}