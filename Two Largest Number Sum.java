
public class Solution {
    public int maxSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int first = nums[0] > nums[1] ? nums[0] : nums[1];
        int second = nums[0] <= nums[1] ? nums[0] : nums[1];

        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        int result = first + second;
        if (result - first != second) {
            return 0;
        } else {
            return result;
        }
    }
}