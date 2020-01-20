
public class Solution {

	public static boolean isPalindrome(int x) {
		
		if (x < 0)
			return false;
		int length = 1; //the bits of int x
		while (x / length >= 10) {
			length *= 10;
		}
		while (x != 0) {
			int right = x % 10;
			int left = x / length;
			
			if (left != right)
				return false;
		
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		isPalindrome(102222);
	}
}
