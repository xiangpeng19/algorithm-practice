package excludes;

class Solution {
    public int climbStairs(int n) {
        int t1 = 1, t2 = 2, t3 = 4;
        for (int i = 4; i < n; i++) {
            int temp = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = temp;
        }
        return t3;
    }
}