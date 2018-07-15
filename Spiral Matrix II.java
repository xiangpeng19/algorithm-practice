public class Solution {
    /*
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here
        int[][] res = new int[n][n];
        if (n < 1) return res;
        int circles = n / 2;
        int val = 1;
        for (int i = 0; i < circles; i++) {
            int last = n - i - 1;
            for (int j = i ; j < last; j++) {
                res[i][j] = val++;
            }
            for (int j = i ; j < last; j++) {
                res[j][last] = val++;
            }
            for (int j = last ; j > i; j--) {
                res[last][j] = val++;
            }
            for (int j = last ; j > i; j--) {
                res[j][i] = val++;
            }
        }
        if (n % 2 == 1) res[n / 2][n / 2] =val;
        return res;
    }



    public int[][] generateMatrix(int n) {
        int levels = n / 2;
        int[][] res = new int[n][n];
        int v = 1;

        for (int level = 0; level < levels; level++) {
            for (int i = level; i < n - level - 1; i++) {
                res[level][i] = v;
                v++;
            }

            for (int i = level; i < n - level - 1; i++) {
                res[i][n - level - 1] = v;
                v++;
            }

            for (int i = n - level - 1; i > level; i--) {
                res[n - level - 1][i] = v;
                v++;
            }
            
            for (int i = n - level - 1; i > level; i--) {
                res[i][level] = v;
                v++;
            }

        }

        if (n % 2 == 1) {
            res[n / 2][n / 2] = v;
        }

        return res;
        
    }
}