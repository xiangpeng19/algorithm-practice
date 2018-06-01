class Solution {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 0;
        right[len - 1] = 0;

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int trapped = 0;

        for (int i = 0; i < len; i++) {
            if (Math.min(left[k], right[k]) - heights[k] > 0) {
                trapped +=  Math.min(left[k], right[k]) - heights[k];
            }

        }
        
        
    }

}