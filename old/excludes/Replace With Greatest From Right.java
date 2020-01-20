package excludes;

public class Solution {
    /*
     * @param : An array of integers.
     * @return: nothing
     */
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        // Write your code here.
        if (nums == null || nums.length == 0) {
            return;
        }

        if (nums.length == 1) {
            nums[0] = -1;
            return;
        }

        // the second from last pointer
        int i = nums.length - 2;
        int preMax = curMax = nums[nums.length - 1];
        nums[nums.length - 1] = -1;

        while (i >= 0) {
            curMax = (curMax > nums[i])? curMax : nums[i];
            nums[i] = preMax;
            i--;
            preMax = curMax;
        }

    }
}