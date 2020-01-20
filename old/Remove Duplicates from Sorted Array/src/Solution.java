import java.util.HashMap;

public class Solution {
    public int removeDuplicates(int[] A) {
/*        if (A == null) return 0;
        if (A.length == 1) return 1;
        int count = A.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
        	if (!map.containsKey(A[i])) map.put(A[i], 0);
        	else count--;
        }

        return count;*/
    	if (A.length < 1) return 0;
//        if (A.length == 1) return 1;
    	int first=0, second=1;  
    	while(second < A.length) {  
            if( A[second] == A[second-1]) {  
                second++;  
                continue;  
            }  
              
            A[++first] = A[second++];  
        }  
          
        return first + 1;  
    }
    
    public static void main(String[] args) {
//    	int A[] = {1,2,3,3,4};
    	int A[] = {};
    	System.out.println(new Solution().removeDuplicates(A));
    }
}