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

}