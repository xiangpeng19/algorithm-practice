package excludes;

public class Solution {

    // move all zero to the end of array
    public int[] moveZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int start = 0, end = nums.length - 1;

        while (start < end) {
            // end pointer points to the first non-zero number from right
            while (end > start && nums[end] == 0) {
                end--;
            }

            // start pointer points to the first zero number from left
            while (start < end && nums[start] != 0) {
                start++;
            }

            swap(nums, start, end);
        }
        return nums;

    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
