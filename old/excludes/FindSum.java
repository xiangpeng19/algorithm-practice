package excludes;

class Solution {


    public boolean findSum(int[] nums, int target) {
        if (nums == null && nums.length == 0) {
            return target == 0;
        }

        int start = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > target) {
                sum -= nums[start];
                start++;
            }

            if (sum == target) {
                return true;
            }

        }


        return false;

    }
}
