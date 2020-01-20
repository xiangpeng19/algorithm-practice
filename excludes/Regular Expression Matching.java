package excludes;

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && f[0][i - 1]) {
                f[0][i + 1] = true;
            }

        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    f[i + 1][j + 1] = f[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    f[i + 1][j + 1] = f[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        f[i + 1][j + 1] = f[i + 1][j - 1];
                    } else {
                        f[i + 1][j + 1] = (f[i + 1][j] || f[i][j + 1] || f[i + 1][j - 1]);
                    }
                }
            }
        }
        return f[s.length()][p.length()];
        
    }
}