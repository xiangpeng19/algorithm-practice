public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
       public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return true;
        int start = 0, end = s.length() - 1;

        while (start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if (!isAlphanumberic(left)) {
                start++;
                continue;
            }
            if (!isAlphanumberic(right)) {
                end--;
                continue;
            }
            if (!equalsIgnoreCase(left, right)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean equalsIgnoreCase(char a, char b) {
        if (a > b) return equalsIgnoreCase(b, a);
        if (a == b) return true;
        if ((b - a) == ('z' - 'Z')) return true;
        return false;
    }

    private boolean isAlphanumberic(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }
}