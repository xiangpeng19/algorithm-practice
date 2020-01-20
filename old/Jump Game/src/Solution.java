
public class Solution {
    public boolean canJump(int[] A) {
    	int max = A[0];
    	for (int i = 0; i < A.length && i <= max ;i++) {
    		if (max >= A.length - 1) return true;
    		if (max == 0) return false;
    		max = max > i + A[i] ? max : i + A[i];

    	}
    	return false;
    }

    public static void main(String[] args) {
		int A[] = {0};
		System.out.println(new Solution().canJump(A));
	}
}
