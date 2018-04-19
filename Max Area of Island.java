class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    max = Math.max(helper(grid, i, j, isVisited), max);
                }
            }
        }
        return max;

    }

    private int helper(int[][] grid, int i, int j, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 1 || isVisited[i][j]) {
            return 0;
        }

        isVisited[i][j] = true;

        return 1 + helper(grid, i - 1, j, isVisited)
                + helper(grid, i + 1, j, isVisited)
                + helper(grid, i, j - 1, isVisited)
                + helper(grid, i, j + 1, isVisited);
    }
}