public class Solution {
    /*
     * @param nums: a list of n integers
     * @return: true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            } else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    third = stack.pop();
                }
            }

            stack.push(nums[i]);
        }
        return false;
    }
}