public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        if (n <= 0)
            return "";
        String curRes = "1";
        int start = 1;
        while (start < n) {
            StringBuilder res = new StringBuilder();
            int count = 1;
            for (int j = 1; j < curRes.length(); j++) {
                if (curRes.charAt(j) == curRes.charAt(j - 1))
                    count++;
                else {
                    res.append(count);
                    res.append(curRes.charAt(j - 1));
                    count = 1;
                }
            }
            res.append(count);
            res.append(curRes.charAt(curRes.length() - 1));
            curRes = res.toString();
            start++;
        }
        return curRes;
    }
}