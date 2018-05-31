public class Solution {
    /*
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */

    public boolean exist(char[][] board, String word) {
        int m = board.length;  
        int n = board[0].length;  
        boolean[][] visited = new boolean[m][n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (dfs(board, word, 0, i, j, visited))  
                    return true;  
            }  
        }  
        return false;  
    }
    
    public boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited) {  
        if (index == word.length())  
            return true;  
        if (rowindex < 0 || colindex < 0 || rowindex >=board.length || colindex >= board[0].length)  
            return false;  
        if (visited[rowindex][colindex])  
            return false;  
        if (board[rowindex][colindex] != word.charAt(index))  
            return false;  
        visited[rowindex][colindex] = true;  
        boolean res = dfs(board, word, index + 1, rowindex - 1, colindex,  
                visited)  
                || dfs(board, word, index + 1, rowindex + 1, colindex, visited)  
                || dfs(board, word, index + 1, rowindex, colindex + 1, visited)  
                || dfs(board, word, index + 1, rowindex, colindex - 1, visited);  
        visited[rowindex][colindex] = false;  
        return res;  
    }


    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, word, isVisited, 0, i, j)) {
                    return true;
                }
            }
        }


        return false;

    }

    private boolean search(char[][] board, String word, boolean[][] isVisited, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (word.charAt(index) != board[x][y] || isVisited[x][y]) {
            return false;
        }

        isVisited[x][y] = true;

        boolean found = search(board, word, isVisited, index + 1, x - 1, y)
                || search(board, word, isVisited, index + 1, x + 1, y)
                || search(board, word, isVisited, index + 1, x, y - 1)
                || search(board, word, isVisited, index + 1, x, y + 1);
        isVisited[x][y] = false;

        return found;

    }
 
}