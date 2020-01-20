
public class Solution {
	public static void merge(int A[], int m, int B[], int n) {
		 int resultIndex = 0;
		 int aIndex = m - 1;
		 int bIndex = n - 1;
		 for(resultIndex = m + n - 1 ; resultIndex >= 0 ; resultIndex--){
         if(bIndex < 0){
		            //Sorting complete. remaining numbers in A are already sorted
		            break;
		        }
		        if(aIndex >= 0 && A[aIndex] >= B[bIndex]){
		            A[resultIndex] = A[aIndex];
		            aIndex--;
		        }else{
		            A[resultIndex] = B[bIndex];
		            bIndex--;
		        }
		    }
    }
	
	public static void main(String[] args) {
		int[] A = new int[10];
		for (int i = 0; i < 5; i++) {
			A[i] = 2 * i + 1;
		}
//		A[0] = 1;
//		A[1] = 6;
/*		A[2] = 1;
		A[3] = 1;
		A[4] = 1;*/
		
		int[] B = {1, 3, 6, 8,10};
		int m = 5, n = 5;
		merge(A, m, B, n);
		for (int i : A) {
			System.out.println(i);
		}
		
		
	}
}
