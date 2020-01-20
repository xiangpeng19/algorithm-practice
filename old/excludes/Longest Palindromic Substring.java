package excludes;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        boolean f[][] = new boolean[len][len];
        int max = 0;
        String res = null;

        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || f[i + 1][j - 1])) {
                    f[i][j] = true;

                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }

                }

            }
        }
        return res;
    }
}