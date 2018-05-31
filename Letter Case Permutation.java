class Solution {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();

        find(S, "", res, 0);

        return res;
    }


    private void find(String S, String cur, List<String> res, int index) {
        if (cur.length() == S.length()) {
            res.add(cur);
            return;
        }


        for (int i = index; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                find(S, cur + c, res, i + 1);
            } else {
                // letter
                find(S, cur + c, res, i + 1);
                find(S, cur + convertCase(c), res, i + 1);
            }
        }


    }


    private char convertCase(char c) {
        if (Character.isUpperCase(c)) {
            return Character.toLowerCase(c);
        } else {
            return Character.toUpperCase(c);
        }
    }


}