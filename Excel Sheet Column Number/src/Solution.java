import java.util.HashMap;

public class Solution {

	public static int titleToNumber(String s) {
        int rst = 0;
        String ltr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < 26; i++) {
			map.put(ltr.charAt(i), i+1);
		}
		
		for (int i = s.length(); i > 0; i--) {
			
			rst +=  map.get(s.charAt(s.length() - i)) * Math.pow(26, i-1);
		}
   
        return rst;
    }
	
	
	
	public static void main(String[] args) {
		
		System.out.println(titleToNumber("ABA"));
	}
}
