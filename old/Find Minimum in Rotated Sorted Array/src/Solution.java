
public class Solution {
    public int findMin(int[] num) {
    	if (num.length == 1) return num[0];
        int start = 0, end = num.length - 1;
        int mid = start + (end - start) >> 1;
        while (start < end) {
        	if (num[start] < num[end]) return num[start];
        	if (num[start] < num[mid]) {
        		//the minimal must be on the right side
        		start = mid + 1;
        		mid = start + (end - start) >> 1;
        	}
        	if (num[start] > num[mid]) {
        		//the minimal must be on the left side
        		end = mid;
        		mid = start + (end - start) >> 1;
        	}
/*        	if (num[mid] > num[end]) {
        		start = mid + 1;
        		mid = start + (end - start) >> 1;
        	}
        	if (num[mid] < num[start]) {
        		end = mid - 1;
        		mid = start + (end - start) >> 1;        		
        	}*/
        }
        return num[start];
    }
    
    public static void main(String[] args) {
		int num[] = {2,1};
		System.out.println(new Solution().findMin(num));
	}
}
