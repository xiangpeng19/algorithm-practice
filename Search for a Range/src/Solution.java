
public class Solution {
	public int[] searchRange(int[] A, int target) {
/*		int index = bs(A, target);
		int range[] = {index, index};;
		if (index == -1) {
			range[0] = range[1] = -1;
			return range;
		}
		while (A[range[0]] == A[index]) {
			if (range[0] - 1 < 0) break;
			if (A[range[0] - 1] == A[index]) range[0]--;
		}
		while (A[range[1]] == A[index]){
			if (range[1] + 1 == A.length) break;
			if (A[range[1] + 1] == A[index]) range[1]++;			
			continue;
		}
		return range;*/
		int[] range = new int[2];
		range[0] = bs(A, target - 1) + 1;
		range[1] = bs(A, target);
		if (range[1] == -1 || A[range[1]] != target) {
			range[0] = -1;
			range[1] = -1;	
		}
		return range;
    }
	
	public int bs(int[] A, int target) {
		int low = 0;  
        int high = A.length - 1;  
        int mid = (low + high) / 2;  
        int ret = -1;  
        while(low <= high){  
            if(A[mid] > target){  
                high = mid - 1;  
                mid = ( low + high) / 2;  
            }  
            else{  
                ret = mid;  
                low = mid + 1;  
                mid = (low + high) / 2;  
            }  
        }  
        return ret;  
	}
	
	public static void main(String[] args) {
		int A[] = {2,2};
		for (int i : new Solution().searchRange(A, 3)) {
			System.out.println(i);
		}
		
	}
}
