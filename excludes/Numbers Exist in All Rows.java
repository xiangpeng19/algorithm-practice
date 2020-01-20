package excludes;

class Solution {
    public Set<Integer> existAll(int[][] matrix) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) {
            return first;
        }
        for (int i = 0; i < col; i++) {
            first.add(matrix[0][i]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (first.contains(matrix[i][j])) {
                    second.add(matrix[i][j]);
                }
            }
            first.clear();
            first.addAll(second);
            second.clear();
        }

        return first;
    }
}