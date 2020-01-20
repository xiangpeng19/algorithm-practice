class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                int last = stack.pop();
                int second = stack.pop();
                int cur = last + second;
                sum += cur;
                stack.push(second);
                stack.push(last);
                stack.push(cur);
            } else if (op.equals("D")) {
                int last = stack.peek();
                int cur = 2 * last;
                sum += cur;
                stack.push(cur);
            } else if (op.equals("C")) {
                int last = stack.pop();
                sum -= last;
            } else {
                int cur = Integer.parseInt(op);
                stack.push(cur);
                sum += cur;
            }
        }

        return sum;
        
    }
}