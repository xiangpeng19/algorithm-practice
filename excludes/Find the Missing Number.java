package excludes;

public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int n = nums.length;
        int total = (0 + n) * (n + 1) / 2;

        return total - sum;
    }
};