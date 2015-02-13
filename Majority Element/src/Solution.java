import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Solution {
	 public static int majorityElement(int[] num) {
		 int count[] = new int[num.length];
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		 for (int i = 0; i < num.length; i++) {
			 if (map.containsKey(num[i])) { 
				 map.put(num[i], map.get(num[i])+1);
				 continue;
			 }
			 map.put(num[i], 1);
			 if (map.get(num[i]) > (num.length/2)) return num[i];
		}
/*		 Iterator iter = map.entrySet().iterator();
		 while (iter.hasNext()) {
			 Entry entry = (Entry) iter.next();
			 if ((int)entry.getValue() > (num.length/2)) {
				return (int)entry.getKey();
			}
		 }*/
		 return -1;
	 }
	 
	 public static void main(String[] args) {
		int num[] = {3, 3, 4};

		 int a = majorityElement(num);
		System.out.println(a);
	}
	 
}
