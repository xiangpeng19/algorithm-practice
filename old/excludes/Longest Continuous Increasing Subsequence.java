package excludes;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                cur = 1;
            } else if (nums[i] > nums[i - 1]) {
                cur++;
            } else {
                max = Math.max(cur, max);
                cur = 1;
            }
        }

        return Math.max(cur, max);        
    }
}