package excludes;

public class Solution {


    public List<String> replaceQuestionMark(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }

        helper(res, input.toCharArray(), "", 0);
        return res;
    }


    private void helper(List<String> res, char[] arr, String cur, int index) {
        if (cur.length() == arr.length) {
            res.add(cur);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] == '?') {
                cur += "1";
                helper(res, arr, cur, i + 1);
                cur = cur.substring(0, cur.length() - 1);
                cur += "0";
                helper(res, arr, cur, i + 1);
                cur = cur.substring(0, cur.length() - 1);
            } else {
                cur += arr[i];
                helper(res, arr, cur, i + 1);
                cur = cur.substring(0, cur.length() - 1);
            }

        }
    }

}