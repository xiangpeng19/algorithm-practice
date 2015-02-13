
public class Solution {
    public static int maxSubArray(int[] A) {
    	int max = A[0];
    	int sum = A[0];
    	for (int i = 1; i < A.length; i++) {
    		if (sum < 0) sum = A[i];
    		else sum += A[i];
    		
    		if (sum > max) max = sum;
    		
    	}
    	
    	return max;
    	
    	
    	
    	/*        int max = Integer.MIN_VALUE;
 
        for (int i = 0; i < A.length; i++) {
        	int temp = 0;
        	for (int j = i; j < A.length-1; j++) {
				temp += A[j];
					if (temp > max) max = temp;
			}
		}
        return max;*/
    }
    
    public static void main(String[] args) {
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		int t = maxSubArray(a);
		System.out.println(t);
	}
}
