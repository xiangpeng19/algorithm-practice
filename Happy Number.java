public class Solution {
    /*
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // write your code here
        if (n <= 0) return false;
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int pre = n;
            int cur = calculate(n);
            if (set.contains(cur)) {
                return false;
            } else if (cur == 1) {
                return true;
            }
            set.add(cur);
            n = cur;
        }
        return false;
    }

    private int calculate(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
};