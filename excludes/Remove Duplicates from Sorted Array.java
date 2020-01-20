package excludes;

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int slow = 0, fast = 1; 
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                swap(nums, slow + 1, fast);
                slow++;
                fast++;
            }
        }
        return slow + 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}