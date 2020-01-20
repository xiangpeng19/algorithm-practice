public class Solution {
    public void rotate(int[][] matrix) {
        int layers = matrix.length / 2;
        int n = matrix.length;
        for (int layer = 0; layer < layers; layer++)
        	for(int i = layer; i < matrix.length - 1 - layer; i++) {
        		int temp = matrix[i][layer];   
        		matrix[i][layer] = matrix[n - 1 - layer][i];
        		matrix[n - 1 - layer][i] = matrix[n - 1 - i][n - 1 - layer];
        		matrix[n - 1 - i][n - 1 - layer] = matrix[layer][n - 1 - i];
        		matrix[layer][n - 1 - i] = temp;
        	}
        
/*        for (int i = 0; i < layer/2; i++) {
        	for (first = i, last = matrix.length - 1 - i;first < last; first++) {
        		int tmp = matrix[i][first];
        		matrix[i][first] = matrix[last-first][i];
        		matrix[last-first][i] = matrix[last-i][last-first];
        		matrix[last-i][last-first] = matrix[first][last-i];
        		matrix[first][last-i] = tmp;
        	}
        }*/
        for (int i = 0; i < matrix.length; i++) {
        	System.out.println();
        	for (int j = 0; j < matrix.length; j++) 
        		System.out.print(matrix[i][j] + " ");
        }
        		
    } 
    
    public static void main(String[] args) {
//		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
//    	int matrix[][] = {{1,2},{3,4}};
		int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	new Solution().rotate(matrix);
	}
}