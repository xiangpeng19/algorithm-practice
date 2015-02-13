public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) return false;
        if (target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        
        int row = 0;
        
        while (row < matrix.length) {
        	if (matrix[row][0] <= target) row++;
        	else break;
        }
        
        if (row != 0) row--;
       
        for (int i = 0; i < matrix[0].length; i++) {
        	if (matrix[row][i] == target) return true;
        }
        
        return false;
    }
    
    
    public static void main(String[] args) {
//		int matrix[][] = {{1,2},{3,4},{5,6}};
    	int matrix[][] = {{1}, {3}};
    	System.out.println(new Solution().searchMatrix(matrix, 3));
	}
    
}