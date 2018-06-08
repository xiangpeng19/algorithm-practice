public class Solution {
    /*
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int n = digits.length;
        int[] res = new int[n + 1];
        // we initialize carry to 1 so it will automatically plus one
        // we don't need to do any special cases later on
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
           res[i + 1] = (carry + digits[i]) % 10;
           carry = (carry + digits[i]) / 10;
        }
        if (carry == 1) {
            res[0] = 1;
            return res;
        } else {
            int[] noCarry = new int[n];
            for (int i = 0; i < n; i++) {
                noCarry[i] = res[i + 1];
            }
            return noCarry;
        }
    }



    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return digits;
        }

        int len = digits.length;

        int carry = 1;

        for (int i = len - 1; i >= 0; i--) {
            int num = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = num;
        }

        if (carry == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }
}