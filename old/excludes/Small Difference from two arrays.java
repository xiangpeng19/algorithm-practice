package excludes;

class Solution {
    public int smallestDiffFromArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return -1;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx1 = 0;
        int idx2 = 0;
        int diff = Math.abs(nums1[0] - nums2[0]);

        while (idx1 < nums1.length && idx2 < nums2.length) {
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            int abs = Math.abs(num1 - num2);
            diff = abs < diff ? abs : diff;
            if (num1 < num2) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return diff;

    }
}