public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        int count = 0;
        while (start < A.length) {
            if (A[start] == elem) {
                if (start <= end) {
                    swap(A, start, end);
                    count++;
                    end--;
                } else {
                    start++;
                }
            } else {
                start++;
            }
        }
        return A.length - count;
    }

    private void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
