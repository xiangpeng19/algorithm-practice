
public class Solution {
	public static int minPathSum(int[][] grid) {
//		return dynamic(grid.length - 1, grid[0].length - 1, grid);
		if (grid.length == 0);
		int sum[][] = new int[grid.length][grid[0].length];
		
		sum[0][0] = grid[0][0];
		
		for (int i = 1; i < grid.length; i++)
			sum[i][0] = sum[i-1][0] + grid[i][0];
		for (int j = 1; j < grid[0].length; j++)
			sum[0][j] = sum[0][j-1] + grid[0][j];
		for (int i = 1; i < grid.length; i++)
			for (int j = 1; j < grid[0].length; j++)
				sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
		
		return sum[grid.length - 1][grid[0].length - 1];
    
        
	}

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] f = new int[row][col];

        f[0][0] = grid[0][0];

        for (int i = 1; i < col; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < row; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                f[i][j] = grid[i][j] + Math.min(f[i][j - 1], f[i - 1][j]);
            }
        }

        return f[row - 1][col - 1];        
    }	
	
//time exceeds limit
/*	public static int dynamic(int i, int j, int[][] grid) {
		if (i == 0 && j == 0) return grid[0][0];
		int sum = 0;
		if (i == 0) {
			for (int t = 0; t <= j; t++) sum += grid[i][t];
			return sum;
		}
		if (j == 0) {
			for (int t = 0; t <= i; t++) sum += grid[t][j];
			return sum;
		}
		return Math.min(dynamic(i-1, j, grid), dynamic(i, j-1, grid)) + grid[i][j];
	}
	*/
	public static void main(String[] args) {
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};

		System.out.println(minPathSum(grid));
	}
}
