
import java.util.HashMap;

public class Solution {
	
	
	public static int romanToInt(String s) {
        int res = 0;
  
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] val = {1, 5, 10, 50, 100, 500, 1000};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < 7; i++) {
			map.put(symbol[i], val[i]);
		}
        
        res += map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
			int cur = map.get(s.charAt(i));
			int pre = map.get(s.charAt(i-1));
        	if (cur <= pre) {
				res += cur;
			}
        	else {
				res = res + cur - 2 * pre;
			}
		}
        
        return res;
    }
	
	
	public static void main(String[] args) {
		String test = "MMM";
		int Result = romanToInt(test);
		System.out.println(Result);
	}
}
