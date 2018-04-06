public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        
        if (A == null || A.length == 0) {
            return false;
        }
        int max = A[0];

        for (int i = 0; i < A.length && i <= max; i++) {
            if (max >= A.length - 1) {
                return true;
            }
            
            if (max == 0) {
                return false;
            }


            max = max > i + A[i] ? max: i + A[i];
        }

        return false;
    }
}