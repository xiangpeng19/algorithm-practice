package excludes;

public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 1;
        }

        int countInc = 1;
        int countDes = 1;
        int max = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                countDes = 1;
                countInc++;
                max = countInc > max ? countInc : max;
            } else if (A[i] < A[i - 1]) {
                countInc = 1;
                countDes++;
                max = countDes > max ? countDes : max;
            }
        }

        return max;
    }
}