
public class Solution {
    public void sortColors(int[] A) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == 0) c0++;
        	if (A[i] == 1) c1++;
        	if (A[i] == 2) c2++;
        }
        
        for (int i = 0; i < A.length; i++) {
        	if (i < c0) A[i] = 0;
        	else if (i < (c0 + c1)) A[i] = 1;
        		 else A[i] = 2;
        }
    }
    
    public static void main(String[] args) {
    	int A[] = {0,2,1,2,2,1,2,2,1,0,0,0};
    	new Solution().sortColors(A);
	}
}
