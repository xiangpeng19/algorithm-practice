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
}