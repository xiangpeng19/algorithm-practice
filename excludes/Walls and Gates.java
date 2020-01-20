package excludes;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int row = rooms.length;
        int col = rooms[0].length; 
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int curRow = cur[0];
            int curCol = cur[1];

            if (curRow > 0 && rooms[curRow - 1][curCol] == Integer.MAX_VALUE) {
                rooms[curRow - 1][curCol] = rooms[curRow][curCol] + 1;
                queue.add(new int[] {curRow - 1, curCol});
            }
            if (curCol > 0 && rooms[curRow][curCol - 1] == Integer.MAX_VALUE) {
                rooms[curRow][curCol - 1] = rooms[curRow][curCol] + 1;
                queue.add(new int[] {curRow, curCol - 1});
            }
            if (curRow < row - 1 && rooms[curRow + 1][curCol] == Integer.MAX_VALUE) {
                rooms[curRow + 1][curCol] = rooms[curRow][curCol] + 1;
                queue.add(new int[] {curRow + 1, curCol});
            }
            if (curCol < col - 1 && rooms[curRow][curCol + 1] == Integer.MAX_VALUE) {
                rooms[curRow][curCol + 1] = rooms[curRow][curCol] + 1;
                queue.add(new int[] {curRow, curCol + 1});
            }
        }
    }
}