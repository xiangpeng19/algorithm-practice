


public class Solution {
    public int searchInsert(int[] A, int target) {
		if (target < A[0]) return 0;
		if (target > A[A.length-1]) return A.length;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] < target && target < A[i+1]) return i+1;
    		if (A[i] == target) return i;
		}
    	return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
		int A[] = {1,2,3,4,5,6,7,8,9};
		System.out.println(new Solution().searchInsert(A, 12));
	}
}
