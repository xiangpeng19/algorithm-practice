public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) return 0;
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int curArea = calculateArea(heights, left, right);
            maxArea = curArea > maxArea ? curArea : maxArea;
            
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return maxArea;
    }

    private int calculateArea(int[] heights, int left, int right) {
        int height = Math.min(heights[left], heights[right]);
        int length = right - left;
        return height * length;
    }
}