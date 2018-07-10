class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[len - i - 1] = right[len - i] * nums[len - i];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;        
    }

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        Arrays.fill(res, 1);

        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    
}