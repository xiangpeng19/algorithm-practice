package solutions.algorithms;

public class _125 {

    public static class Solution {

        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            int start = 0, end = s.length() - 1;
            while (start < end) {
                char left = s.charAt(start);
                char right = s.charAt(end);
                if (!isAlphanumeric(left)) {
                    start++;
                    continue;
                }
                if (!isAlphanumeric(right)) {
                    end--;
                    continue;
                }
                if (equalsIgnoreCase(left, right)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean equalsIgnoreCase(char a, char b) {
            return Character.toLowerCase(a) == Character.toLowerCase(b);

        }

        private boolean isAlphanumeric(char c) {
//            return Character.isLetterOrDigit(c);
            return (c <= 'z' && c >= 'a')
                    || (c <= '9' && c >= '0')
                    || (c <= 'Z' && c >= 'A');
        }
    }

}
