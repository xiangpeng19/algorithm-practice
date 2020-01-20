
public class Solution {
    public int findPeakElement(int[] num) {
    	int left = 0, right = num.length - 1;
    	int mid; 
    	
    	while (left <= right) {
    		if (right == left) return left;
    		mid = (left + right) / 2;
    		if (num[mid] < num[mid+1])
    			left = mid + 1;
    		else right = mid;
    		
    	}
    	return 0;
/*    	if (num.length == 1) return 0;
    	for (int i = 0; i < num.length; i++) {
    		if (i == 0)
    			if (num[i] > num[i+1]) return i;
    		if (i == num.length - 1)
    			if (num[i] > num[i-1]) return i;
    		if (num[i] > num[i+1] && num[i] > num[i-1]) return i;
    	}
    	return 0;*/
    }
    
    public static void main(String[] args) {
    	int a[] = {1,2,3,1};
    	System.out.println(new Solution().findPeakElement(a));
	}
	
	public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        boolean asc = true;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int next = nums[i + 1];
            if (next < cur && asc) {
                return i;
            }
            if (cur > next) {
                asc = false;
            } else {
                asc = true;
            }

        }

        int end = nums.length - 1;
        int index = (nums[end - 1] < nums[end]) ? end : end - 1;
        return index;
        
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;

    }
}