import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
    public static int singleNumber(int[] A) {
/*        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //use A[] as keys in hashmap, it saves a lot of time.
        for (int i = 0; i < A.length; i++) {
        	if (map.get(A[i]) == null) {
        		map.put(A[i], 1);
        	} 
        	else map.remove(A[i]);
        	
        }

        
        for(Entry<Integer, Integer> entry:map.entrySet())  
        	return entry.getKey(); 

        return -1;*/
    	
    	//use the XOR operation.
    	if (A == null) return -1;
    	int result = 0;
    	for (int i = 0; i < A.length; i++) {
			result ^= A[i];
		}
    	return result;
    }
    public static void main(String[] args) {
		int A[] = {1, 2, 4, 1, 2, 4, 6, 6, 8};
		System.out.println(singleNumber(A));
	}
}
