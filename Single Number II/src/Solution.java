import java.util.HashMap;
import java.util.Iterator;



public class Solution {
	public static int singleNumber(int[] A) {
	
		
		int[] bit = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) != 0) bit[i]++;
				bit[i] = bit[i] % 3;
			}
			result |= bit[i] << i;
		}
		return result;
/*	   if (A.length == 0) return Integer.MAX_VALUE;
	   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	   for (int i = 0; i < A.length; i++) {
		   if (map.containsKey(A[i])) map.put(A[i], map.get(A[i]) + 1);
		   else map.put(A[i], 1);
	   }
	   
	   Iterator iter = map.entrySet().iterator();
	   while(iter.hasNext()) {
		   java.util.Map.Entry entry = (java.util.Map.Entry)iter.next();
		   if ((int)entry.getValue() == 1) return (int)entry.getKey();
	   }
	   
	   return Integer.MAX_VALUE;*/
       
	
       
    }
	
	public static void main(String[] args) {
		int a[] = {1,1,1,2,2,2,3,3,3,4,4,4,5};
		System.out.println(singleNumber(a));
	}
}
