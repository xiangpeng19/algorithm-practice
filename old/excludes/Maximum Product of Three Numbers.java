package excludes;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int end = nums.length - 1;

        // all positive 
        if (nums[0] >= 0) {
            return nums[end] * nums[end - 1] * nums[end - 2];
        }

        // all negative
        if (nums[end] < 0) {
            return nums[end] * nums[end - 1] * nums[end - 2];
        }

        // mix
        return Math.max(nums[0] * nums[1] * nums[end], nums[end] * nums[end - 1] * nums[end - 2]);
        
        
    }
}