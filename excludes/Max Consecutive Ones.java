package excludes;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int localMax = 0;

        if (nums == null || nums.length == 0) {
            return max;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                localMax++;
            } else {
                max = Math.max(max, localMax);
                localMax = 0;
            }
        }

        return Math.max(max, localMax);
    
        
    }
}