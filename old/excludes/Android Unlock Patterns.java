class Solution {

    private boolean[] used = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += calculatePatterns(-1, i);
            Arrays.fill(used, false);
        }
        return res;
    }

    private boolean isValid(int last, int cur) {
        if (used[cur]) {
            return false;
        }

        // first time, we can choose any one
        if (last == -1) {
            return true;
        }


        // knight's move or adjacent cells (in row or column)
        if ((last + cur) % 2 != 0) {
            return true;
        }

        // end of diagonal
        int mid = (last + cur) / 2;
        if (mid == 4) {
            return used[mid];
        }

        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ( (cur % 3 != last % 3) && (cur / 3 != last / 3)) {
            return true;
        }
        return used[mid];
    }



    private int calculatePatterns(int last, int len) {
        if (len == 0) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(last, i)) {
                used[i] = true;
                sum += calculatePatterns(i, len - 1);
                used[i] = false;
            }
        }

        return sum;

    }
}