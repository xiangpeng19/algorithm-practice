
public class Solution {
	
	
	public static int lengthOfLastWord(String s) {
		char c;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c != ' ') {
				
				count++;
			}
			else {
				if (i == s.length() - 1) {
					return count;
				}
				if (s.charAt(i+1) != ' ' ) {
					count = 0;	
				} 
				
			}
			
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		String s = "hell go yo  yooo";
		int x = lengthOfLastWord(s);
		System.out.println(x);
	}
}
