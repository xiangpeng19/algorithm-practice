class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        
        //index - subarray end index, value - subarray start index
        int[] sub = new int[A.length];
        int resultIndex = -1;
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            if (max * A[i] > A[i] || min * A[i] > A[i]) {
                sub[i] = sub[i - 1];
            } else {
                sub[i] = i;
            }
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                resultIndex = i;
                result = max;
            }
        }

        return result;
    }
}