/**
 * Created by lxp19_000 on 2015-07-15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[start + end - i];
            nums[start + end - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        new Solution().rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}