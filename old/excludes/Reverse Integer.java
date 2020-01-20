package excludes;

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        int total = 0;
        while (n > 0) {
            int curDigit = n % 10;
            int temp = (total * 10) + curDigit;
            
            // is this the right way to check overflow?
            if (((temp - curDigit) / 10) != total) {
                return 0;
            } else {
                total = temp;
            }
            n /= 10;
        }

        return isNegative ? -total : total;
    }
}