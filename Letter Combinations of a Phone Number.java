public class Solution {
    /*
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[][] maps = {
            {},
            {},
            {'a', 'b', 'c'}, 
            {'d', 'e', 'f'}, 
            {'g', 'h', 'i'}, 
            {'j', 'k', 'l'}, 
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, 
            {'t', 'u', 'v'}, 
            {'w', 'x', 'y', 'z'}};

        dfs(res, "", digits, 0, maps);
        return res;
        
    }

    private void dfs(List<String> res, String cur, String digits, int index, char[][] maps) {
        if (index == digits.length()) {
            res.add(new String(cur));
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (int j = 0; j < maps[digit].length; j++) {
            dfs(res, cur + maps[digit][j], digits, index + 1, maps);
        }
    }


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        find(res, "", digits, keyboard, 0);
        
        return res;

    }

    private void find(List<String> res, String cur, String digits, String[] keyboard, int index) {
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            for (int j = 0; j < keyboard[digit].length(); j++) {
                find(res, cur + keyboard[digit].charAt(j), digits, keyboard, i + 1);
            }
        }

    }

}