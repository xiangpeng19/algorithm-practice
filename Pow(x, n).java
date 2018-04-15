public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            if (n < 0) {
                return half * half / x;
            } else {
                return half * half * x;
            }
        }
    }
}