package excludes;

class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    markAsVisited(grid, isVisited, i, j);
                    count++;
                }

            }
        }

        return count;
        
    }


    private void markAsVisited(char[][] grid, boolean[][] isVisited, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || isVisited[x][y] || grid[x][y] != '1') {
            return;
        }

        if (grid[x][y] == '1' && !isVisited[x][y]) {
            isVisited[x][y] = true;
        }

        markAsVisited(grid, isVisited, x - 1, y);
        markAsVisited(grid, isVisited, x + 1, y);
        markAsVisited(grid, isVisited, x, y - 1);
        markAsVisited(grid, isVisited, x, y + 1);
    }

}