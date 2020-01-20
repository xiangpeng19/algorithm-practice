package excludes;

class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        int odd = 0;

        int[] freq = new int[256];
        String mid = "";
        String pattern = "";

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                mid = String.valueOf((char) i);
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                pattern += String.valueOf((char) i);
            }
        }

        if (odd >= 2) {
            return res;
        }


        permute(res, new StringBuilder(), pattern, new boolean[pattern.length()], mid);

        return res;

    }

    private void permute(List<String> res, StringBuilder cur, String pattern, boolean[] used, String mid) {
        if (cur.length() == pattern.length()) {
            res.add(cur.toString() + mid + cur.reverse().toString());
//            cur = new StringBuilder();
            cur.reverse();
            return;
        }

        for (int i = 0; i < pattern.length(); i++) {
            // avoid duplication
            if (i > 0 && pattern.charAt(i) == pattern.charAt(i - 1) && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                cur.append(pattern.charAt(i));
                permute(res, cur, pattern, used, mid);
                cur.setLength(Math.max(cur.length() - 1, 0));
                used[i] = false;
            }
        }

    }
}