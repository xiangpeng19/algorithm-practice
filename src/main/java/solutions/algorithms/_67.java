package solutions.algorithms;

public class _67 {

    public static class Solution {

        public String addBinary(String a, String b) {
            // make sure a is always shorter than b
            if (a.length() > b.length()) {
                return addBinary(b, a);
            }

            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int lenA = a.length();
            int lenB = b.length();
            for (int i = 0; i < lenA; i++) {
                int digitA = a.charAt(lenA - i - 1) - '0';
                int digitB = b.charAt(lenB - i - 1) - '0';
                int digit = (digitA + digitB + carry) % 2;
                carry = (digitA + digitB + carry) / 2;
                sb.append(digit);
            }

            for (int i = 0; i < lenB - lenA; i++) {
                int digitB = b.charAt(lenB - lenA - i - 1) - '0';
                int digit = (digitB + carry) % 2;
                carry = (digitB + carry) / 2;
                sb.append(digit);
            }

            if (carry == 1) {
                sb.append(1);
            }

            return sb.reverse().toString();
        }

    }

}
