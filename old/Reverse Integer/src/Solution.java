

public class Solution {
	public static int reverse(int x) {
		int temp = x;
		int result = 0;
		int count = 0;
		int a;
		//count how many bits
		
		
		if (x > 0) {
			for (; temp > 0; temp /= 10, count++);
			while (x > 0) {
				if (result >= 2147483647) {
					result = 0;
					break;
				}			
				a = x % 10;
				result += Math.pow(10, count - 1) * a;

				count--;
				x /= 10; 
			}		
		}
		else {
			x = 0 - x;
			temp = x;
			for (; temp > 0; temp /= 10, count++);
			while (x > 0) {
				if (result >= 2147483647) {
					result = 0;
					break;
				}			
				a = x % 10;
				result += Math.pow(10, count - 1) * a;

				count--;
				x /= 10;
			}
			result = -result;
		}

		
		return result;
	}
	
	public static void main(String[] args) {
		int x;
		x = reverse(-123);
		System.out.println(x);
	}

}





