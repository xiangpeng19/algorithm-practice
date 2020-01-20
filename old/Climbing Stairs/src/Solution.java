
public class Solution {

	
	public static int climbStairs(int n) {
		int rst = 0;
    	int a = 1;
    	int b = 2;
        if (n == a)
        	return 1;
        if (n == b)
        	return 2;
        for (int i = 2; i < n; i++) {
        	rst = a + b;
        	a = b;
        	b = rst;
        }
        return rst;
		}
    
	
	
	public static void main(String[] args) {
		
	}
}
