class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int high = nums[len - 1] - nums[0];
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            low = Math.min(low, nums[i + 1] - nums[i]);
        }

        while (low < high) {
            int mid = (high + low) / 2;
            int count = count(nums, mid);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;


    }

    private int count(int[] nums, int dist) {
        int i = 0, res = 0;

        for (int j = 1; j < nums.length; j++) {
            while (i < j && nums[j] - nums[i] > dist) {
                i++;
            }

            res += j - i;
        }

        return res;

    }
}